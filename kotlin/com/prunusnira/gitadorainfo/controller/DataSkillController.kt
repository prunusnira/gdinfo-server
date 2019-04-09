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
class DataSkillController {
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
	@RequestMapping(value=["/d/skill/{ptype}/{id}/{gtype}/{page}/{order}"],
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
			  @RequestParam(value="hot", required=false) hot: String?,
			  @RequestParam(value="rival", required=false) rival: Int?): String {
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
		
		val skillMap = skillService.getSkillTablePtype(
								ptype, user, gtype, cpage, levels,
								ranks, vers, hotv, order)
		
		var pages = 0
		var sendList = ArrayList<SkillTable>()
		var hsend = ArrayList<SkillTable>()
		var osend = ArrayList<SkillTable>()
		
		if((ptype == 0 || ptype == 3 || ptype == 4 || ptype == 7) && skillMap.get(0)!!.size != 0) {
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
		else if(ptype == 2 || ptype == 5 || ptype == 6 || ptype == 8) {
			hsend = Const.getPagedList(skillMap.get(1)!!, 1, 25)
			osend = Const.getPagedList(skillMap.get(2)!!, 1, 25)
		}
		
		// rival - 데이터는 항상 보냄
		val rivalList = userService.getRival(user.id, gtype)
		
		// 라이벌 유저를 불러오도록 선택 했을 경우
		if(rival != null) {
			//val rd = userService.getOneRival(user.id, rival, gtype)
			// sendList의 곡 정보를 토대로 가져오기
			val rivalData = ArrayList<Pattern>()
			val hrival = ArrayList<Pattern>()
			val orival = ArrayList<Pattern>()
			
			if(ptype == 2) {
				for(d in hsend) {
					hrival.add(skillService.getSkillPatternSelf(d.musicid, d.patterncode, rival))
				}
				for(d in osend) {
					orival.add(skillService.getSkillPatternSelf(d.musicid, d.patterncode, rival))
				}
			}
			else {
				for(d in sendList) {
					rivalData.add(skillService.getSkillPatternSelf(d.musicid, d.patterncode, rival))
				}
			}
			val rivalUser = userService.getUserById(rival)
			
			try {
				if(ptype == 2) {
					node.putPOJO("hrival", mapper.writeValueAsString(hrival))
					node.putPOJO("orival", mapper.writeValueAsString(orival))
				}
				else {
					node.putPOJO("rivaldata", mapper.writeValueAsString(rivalData))
				}
				node.putPOJO("rivaluser", mapper.writeValueAsString(rivalUser))
			} catch(e: JsonProcessingException) {
				e.printStackTrace()
			}
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
			node.putPOJO("rivalnum", rival)
			node.putPOJO("rival", mapper.writeValueAsString(rivalList))
			node.putPOJO("hskill", mapper.writeValueAsString(hsend))
			node.putPOJO("oskill", mapper.writeValueAsString(osend))
			node.putPOJO("skill", mapper.writeValueAsString(sendList))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/d/music/{mid}/{id}"],
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
	
	@RequestMapping(value=["/d/exc/{gtype}"],
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
	
	@RequestMapping(value=["/d/musiclist/{ver}"],
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
	
	@RequestMapping(value=["/d/manual/{id}"], method=[RequestMethod.POST])
	@ResponseBody
	fun manual(@RequestParam userid: Int,
			@RequestParam mid: Int,
			@RequestParam pattern: Int,
			@RequestParam version: Int,
			@RequestParam rate: Int,
			@RequestParam score: Int,
			@RequestParam combo: Int,
			@RequestParam isfc: String,
			@RequestParam rank: String,
			@RequestParam lv: Int): String {
		var checkfc:String?
		if(isfc == "true") checkfc = "Y"
		else checkfc = "N"
		
		val data = Skill(userid, mid, version, pattern, rank,
			rate, score, combo, checkfc)
		skillService.addResultOne(data)
		skillService.updateTotalSkill(userid, pattern)
		
		return "200"
	}
	
	@RequestMapping(value=["/d/getmusic/{mid}"],
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
}