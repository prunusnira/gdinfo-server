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
import com.prunusnira.gitadorainfo.model.ClearTable
import com.prunusnira.gitadorainfo.model.NotPlayed
import com.prunusnira.gitadorainfo.service.MusicService
import com.prunusnira.gitadorainfo.service.SkillService
import com.prunusnira.gitadorainfo.service.TowerService
import com.prunusnira.gitadorainfo.service.UserService
import com.prunusnira.gitadorainfo.data.FilterProcess
import com.prunusnira.gitadorainfo.data.Const
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class ProfileController {
	@Autowired
	lateinit var userService: UserService
	
	@Autowired
	lateinit var musicService: MusicService
	
	@Autowired
	lateinit var skillService: SkillService
	
	@Autowired
	lateinit var towerService: TowerService
	
	val logger = LoggerFactory.getLogger(javaClass)
	
	@RequestMapping(value=["/gettoken"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun getToken(req: HttpServletRequest): String? {
		val session = req.session
		val t = session.getAttribute("token")
		var token = ""
		if(t != null) {
			token = t as String
		}
		System.out.println("SESSION TEST3: "+session.getAttribute("TEST"))
		return token
	}
	
	@RequestMapping(value=["/getuser/{token}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun getUserToken(@PathVariable("token") token: String): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val profile = userService.getUserByToken(token)
		try {
			node.putPOJO("mydata", mapper.writeValueAsString(profile))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/getuserid/{id}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun getUserId(req: HttpServletRequest,
				  @PathVariable("id") id: Int): String {
		val session = req.session
		System.out.println("SESSION TEST1: "+session.getAttribute("TEST"))
		session.setAttribute("TEST", "TEST")
		System.out.println("SESSION TEST2: "+session.getAttribute("TEST"))
		val token = session.getAttribute("token")
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val profile = userService.getUserById(id)
		try {
			if(token != null) node.putPOJO("token", mapper.writeValueAsString(token as String))
			node.putPOJO("mydata", mapper.writeValueAsString(profile))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/skillrecord/{id}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun profile(@PathVariable("id") userid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val record = userService.getSkillRecord(userid)
		try {
			node.putPOJO("record", mapper.writeValueAsString(record))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/cleartable/{gtype}/{id}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun clearTable(@PathVariable("id") uid: Int,
				   @PathVariable("gtype") gtype: String): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val clearTable = ClearTable()
		if(gtype == "gf") {
			clearTable.totalPatternCount = musicService.getTotalPatternCountGF()
			clearTable.patternCount = skillService.getPatternCount(0, uid)
		}
		else if(gtype == "dm") {
			clearTable.totalPatternCount = musicService.getTotalPatternCountDM()
			clearTable.patternCount = skillService.getPatternCount(1, uid)
		}
		
		try {
			node.putPOJO("ctable", mapper.writeValueAsString(clearTable))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/mybest/{id}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun mostplayed(@PathVariable("id") userid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		
		val mbp = skillService.getMybestPattern(userid, 0)
		val mbpg = skillService.getMybestPattern(userid, 1)
		val mbpd = skillService.getMybestPattern(userid, 2)
		val mbm = skillService.getMybestMusic(userid)
		try {
			node.putPOJO("mybestp", mapper.writeValueAsString(mbp))
			node.putPOJO("mybestpg", mapper.writeValueAsString(mbpg))
			node.putPOJO("mybestpd", mapper.writeValueAsString(mbpd))
			node.putPOJO("mybestm", mapper.writeValueAsString(mbm))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/setopencount"])
	fun opencount(@RequestParam(value="open", required=false) open: String,
				  @RequestParam(value="id") userid: Int)
	: String {
		userService.updateOpenCount(open, userid)
		return "redirect:/profile"
	}
	
	@RequestMapping(value=["/d/setcomment"])
	fun comment(@RequestParam(value="val", required=false) comment: String,
				@RequestParam(value="id") userid: Int): String {
		userService.updateComment(comment, userid)
		return "redirect:/profile"
	}
	
	@RequestMapping(value=["/notplayed/{gtype}/{id}/{vertype}/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun notplayed(@PathVariable("gtype") gtype: String,
				  @PathVariable("id") userid: Int,
				  @PathVariable("vertype") vertype: Int,
				  @PathVariable("page") page: Int,
				  @RequestParam(value="ver", required=false) version: String?,
				  @RequestParam(value="order", required=false) order: String?,
				  @RequestParam(value="lv", required=false) level: Int?,
				  @RequestParam(value="hot", required=false) hot: String?): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val notPlayedList = ArrayList<NotPlayed>()
		
		val levels = FilterProcess.filterLevel(level)
		val vers = FilterProcess.filterVer(version)
		val hotv = FilterProcess.filterHot(hot)
		val orderval = FilterProcess.filterOrder(order)
		
		notPlayedList.addAll(musicService.getNotPlayed(gtype, userid, vertype, vers, orderval, levels, hotv))
		
		val sendList = Const.getPagedList(notPlayedList, page, 30)
		val pages = Const.getListPages(notPlayedList, 30)
		
		try {
			node.putPOJO("music", mapper.writeValueAsString(sendList))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("gtype", mapper.writeValueAsString(gtype))
			node.putPOJO("order", mapper.writeValueAsString(orderval))
			node.putPOJO("lv", mapper.writeValueAsString(levels))
			node.putPOJO("hot", mapper.writeValueAsString(hotv))
			node.putPOJO("ver", mapper.writeValueAsString(vers))
			node.putPOJO("userid", userid)
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping("/resetdata")
	@ResponseBody
	fun resetData(@RequestParam("id") id: Int): String {
		userService.reset(id)
		skillService.reset(id)
		return "200"
	}
	
	@RequestMapping("/d/profile/towerupdate/{id}")
	@ResponseBody
	fun updateTowerProfile(@PathVariable("id") id: Int): String {
		return towerService.updateTowerProfile(id, skillService).toString()
	}
	
	@RequestMapping("/profile/towerstatus/tower/{id}")
	@ResponseBody
	fun getTowerClearProfile(@PathVariable("id") id: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val info = towerService.getTowerList() as ArrayList
		info.remove("towerSample")
		info.remove("towerManage")
		info.remove("towerTest")
		info.remove("towerStatusClear")
		info.remove("towerStatusFloor")
		val tower = towerService.selectTowerStatus(id)
		
		node.putPOJO("list", mapper.writeValueAsString(info))
		node.putPOJO("tower", mapper.writeValueAsString(tower))
		return node.toString()
	}
	
	@RequestMapping("/profile/towerstatus/floor/{id}")
	@ResponseBody
	fun getTowerFloorProfile(@PathVariable("id") id: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val floor = towerService.selectFloorStatus(id)
		
		node.putPOJO("floor", mapper.writeValueAsString(floor))
		return node.toString()
	}
	
	@RequestMapping("/profile/countupdate/{id}")
	@ResponseBody
	fun updateTotalCount(@PathVariable("id") id: Int): String {
		var gfc:Int = skillService.getPlayCountGF(id)
		var dfc:Int = skillService.getPlayCountDM(id)
		userService.updatePlayCount("gf", gfc, id)
		userService.updatePlayCount("dm", dfc, id)
		userService.updatePlayCount("all", gfc+dfc, id)
		
		return "ok";
	}
}