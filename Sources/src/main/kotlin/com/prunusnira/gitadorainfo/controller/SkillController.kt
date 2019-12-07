/*****************************************************
 * GITADORA Info Server
 * Developed by Tae Jun Kang a.k.a Prunus Nira
 * (c) Nira 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 *****************************************************/
package com.prunusnira.gitadorainfo.controller

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.prunusnira.gitadorainfo.data.Const
import com.prunusnira.gitadorainfo.data.FilterProcess
import com.prunusnira.gitadorainfo.model.Pattern
import com.prunusnira.gitadorainfo.model.RecentUser
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.SkillTable
import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.MusicService
import com.prunusnira.gitadorainfo.service.SkillService
import com.prunusnira.gitadorainfo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class SkillController {
	@Autowired
	lateinit var skillService: SkillService
	
	@Autowired
	lateinit var musicService: MusicService
	
	@Autowired
	lateinit var userService: UserService
	
	/**
	 * PTYPE
	 * 0: 전체
	 * 1: HOT/OTHER 각각
	 * 2: 전체 스킬표
	 * 3: RE TOP 100
	 * 4: TB TOP 100
	 * 5: RE 스킬표
	 * 6: TB 스킬표
	 * 7: MX TOP 100
	 * 8: MX 스킬표
	 * 1000: EXC
	 */
	@RequestMapping(value=["/skill/{ptype}/{id}/{gtype}/{page}/{order}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun skill(req: HttpServletRequest,
			  @PathVariable("gtype") gtype: String,
			  @PathVariable("ptype") ptype: Int,
			  @PathVariable("order") order: String,
			  @PathVariable("page") page: Int,
			  @PathVariable("id") userid: Int,
			  @RequestParam(value="lv", required=false) level: Int?,
			  @RequestParam(value="rank", required=false) rank: Int?,
			  @RequestParam(value="ver", required=false) ver: String?,
			  @RequestParam(value="hot", required=false) hot: String?): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val session = req.session
		
		var cpage = page
		if(cpage == 0) cpage = 1
		
		val user = userService.getUserById(userid)
		val token = session.getAttribute("token") as String?
		
		val levels = FilterProcess.filterLevel(level)
		val ranks = FilterProcess.filterRank(rank)
		val vers = FilterProcess.filterVer(ver)
		val hotv = FilterProcess.filterHot(hot)
		
		System.out.println(rank)
		System.out.println(ranks)
		
		val skillMap = skillService.getSkillTablePtype(
								ptype, user, gtype, cpage, levels,
								ranks, vers, hotv, order)
		
		var pages = 0
		var sendList = ArrayList<SkillTable>()
		var hsend = ArrayList<SkillTable>()
		var osend = ArrayList<SkillTable>()
		
		if((ptype == 0 || ptype == 3 || ptype == 4 || ptype == 7 || ptype == 9) && skillMap.get(0)!!.size != 0) {
			sendList = Const.getPagedList(skillMap.get(0)!!, page, 30)
			pages = Const.getListPages(skillMap.get(0)!!, 30)
		}
		else if(ptype == 1) {
			if(order == "y") {
				sendList = Const.getPagedList(skillMap.get(0)!!, 1, 25)
			}
			else if(order == "n") {
				sendList = Const.getPagedList(skillMap.get(0)!!, 2, 25)
			}
		}
		else if(ptype == 2 || ptype == 5 || ptype == 6 || ptype == 8 || ptype == 10) {
			hsend = Const.getPagedList(skillMap.get(1)!!, 1, 25)
			osend = Const.getPagedList(skillMap.get(2)!!, 1, 25)
		}
		
		try {
			node.putPOJO("token", mapper.writeValueAsString(token))
			node.putPOJO("user", mapper.writeValueAsString(user))
			node.putPOJO("order", mapper.writeValueAsString(order))
			node.putPOJO("gtype", mapper.writeValueAsString(gtype))
			node.putPOJO("ptype", mapper.writeValueAsString(ptype))
			node.putPOJO("page", mapper.writeValueAsString(page))
			node.putPOJO("pages", mapper.writeValueAsString(pages))
			node.putPOJO("lv", mapper.writeValueAsString(level))
			node.putPOJO("rank", mapper.writeValueAsString(rank))
			node.putPOJO("ver", mapper.writeValueAsString(ver))
			node.putPOJO("hot", mapper.writeValueAsString(hot))
			node.putPOJO("hskill", mapper.writeValueAsString(hsend))
			node.putPOJO("oskill", mapper.writeValueAsString(osend))
			node.putPOJO("skill", mapper.writeValueAsString(sendList))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/music/{mid}/{id}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun musicPattern(@PathVariable("mid") musicid: Int,
					 @PathVariable("id") userid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val skill = skillService.getSkill(userid, musicid)
		val music = musicService.getMusicInfo(musicid)
		
		try {
			node.putPOJO("skill", mapper.writeValueAsString(skill))
			node.putPOJO("music", mapper.writeValueAsString(music))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/exc/{gtype}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun exc(@PathVariable("gtype") gtype: String): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val hs = skillService.getEXCData(gtype, "Y")
		val os = skillService.getEXCData(gtype, "N")
		var totalskill = 0
		for(d in hs)
			totalskill += d.level.toInt()*100*20/1000
		for(d in os)
			totalskill += d.level.toInt()*100*20/1000
		
		val user = User("EXCELLENT",
						totalskill.toDouble()/100,
						totalskill.toDouble()/100)
		
		try {
			node.putPOJO("user", mapper.writeValueAsString(user))
			node.putPOJO("order", mapper.writeValueAsString(user))
			node.putPOJO("gtype", mapper.writeValueAsString(gtype))
			node.putPOJO("ptype", 1000)
			node.putPOJO("page", 1)
			node.putPOJO("pages", 1)
			node.putPOJO("lv", null)
			node.putPOJO("rank", null)
			node.putPOJO("ver", null)
			node.putPOJO("hot", null)
			node.putPOJO("rivalnum", 0)
			node.putPOJO("rival", mapper.writeValueAsString(ArrayList<RecentUser>()))
			node.putPOJO("hskill", mapper.writeValueAsString(hs))
			node.putPOJO("oskill", mapper.writeValueAsString(os))
			node.putPOJO("skill", mapper.writeValueAsString(ArrayList<SkillTable>()))
		}
		catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/musiclist/{ver}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun getMusicList(@PathVariable("ver") ver: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		var vers = ArrayList<Int>()
		vers.add(ver)
		val music = musicService.getMusicInfoAllList(vers, "", "")
		
		try {
			node.putPOJO("music", mapper.writeValueAsString(music))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/getmusic/{mid}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun getMusic(@PathVariable("mid") mid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val m = musicService.getMusicInfo(mid)
		try {
			node.putPOJO("music", mapper.writeValueAsString(m))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}

	@RequestMapping(value=["/skill/snapshot/create/{uid}/{gtype}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun createSnapshot(@PathVariable("uid") uid: Int,
						@PathVariable("gtype") gtype: String): String {
		var user = userService.getUserById(uid)
		skillService.createSnapshot(uid, gtype, user.name)
		return "/skill/snapshot/list/"+uid
	}

	@RequestMapping(value=["/skill/snapshot/list/{uid}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun listSnapshot(@PathVariable("uid") uid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		var list = skillService.listSnapshot(uid)
		try {
			node.putPOJO("list", mapper.writeValueAsString(list))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}

	@RequestMapping(value=["/skill/snapshot/load/{uid}/{date}/{gtype}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun loadSnapshot(@PathVariable("uid") uid: Int,
					@PathVariable("date") date: String,
					@PathVariable("gtype") gtype: String): String {
		return skillService.loadSnapshot(uid, date, gtype)
	}
}