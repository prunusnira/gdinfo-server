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
import com.prunusnira.gitadorainfo.model.CountRank
import com.prunusnira.gitadorainfo.model.Music
import com.prunusnira.gitadorainfo.model.Pattern
import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.MusicService
import com.prunusnira.gitadorainfo.service.SkillService
import com.prunusnira.gitadorainfo.service.UserService
import com.prunusnira.gitadorainfo.tool.IPLogger
import com.prunusnira.gitadorainfo.data.FilterProcess
import com.prunusnira.gitadorainfo.data.Const
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.text.ParseException
import javax.servlet.http.HttpServletRequest

@Controller
class PatternController {
	@Autowired
	lateinit var skillService:SkillService
	
	@Autowired
	lateinit var musicService:MusicService
	
	@Autowired
	lateinit var userService:UserService
	
	@RequestMapping(value=["/rank/{gtype}/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun skillRanking(@PathVariable("gtype") gtype: String,
					 @PathVariable("page") page: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val userList = userService.skillRanking(gtype)
		val sendList = Const.getPagedList(userList, page, 30)
		val pages = Const.getListPages(userList, 30)
		
		for(i in 0..sendList.size-1) {
			try {
				sendList[i].uptimelong = sendList[i].updatetime.time
			} catch (e: ParseException) {
				e.printStackTrace()
			}
		}
		
		try {
			node.putPOJO("gtype", mapper.writeValueAsString(gtype))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("allUserList", mapper.writeValueAsString(sendList))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/ptrank/{ver}/{order}/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun ptrankList(req:HttpServletRequest,
				   @PathVariable("ver") ver: String,
				   @PathVariable("order") order: String,
				   @PathVariable("page") page: Int,
				   @RequestParam(value="hot", required=false) hot: String?)
	: String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val session = req.session
		val token = session.getAttribute("token") as String?
		val vers = FilterProcess.filterVer(ver)
		val hotv = FilterProcess.filterHot(hot)
		
		var user:User? = null
		if(token != null)
			user = userService.getUserByToken(token)
		
		val music = ArrayList<Music>()
		if(vers.size == 0) {
			music.addAll(musicService.getMusicInfoAllListAllSong(hotv, order))
		}
		else {
			music.addAll(musicService.getMusicInfoAllList(vers, hotv, order))
		}
		
		val sendList = Const.getPagedList(music, page, 30)
		val pages = Const.getListPages(music, 30)
		
		try {
			node.putPOJO("ver", mapper.writeValueAsString(ver))
			node.putPOJO("hot", mapper.writeValueAsString(hot))
			node.putPOJO("order", mapper.writeValueAsString(order))
			if(user != null) node.putPOJO("user", mapper.writeValueAsString(user))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("musiclist", mapper.writeValueAsString(sendList))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/ptdetail/{mid}/{p}/{page}/{version}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun ptdetail(@PathVariable("mid") mid: Int,
				 @PathVariable("p") patterncode: Int,
				 @PathVariable("page") page: Int,
				 @PathVariable("version") version: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val music = musicService.getMusicInfo(mid)
		val skillList = skillService.getSkillPattern(music.id, patterncode, version)
		val sendList = Const.getPagedList(skillList, page, 30)
		val pages = Const.getListPages(skillList, 30)
		
		val users = ArrayList<User>()
		for(i in 0..sendList.size-1) {
			users.add(userService.getUserById(sendList[i].userid))
		}
		
		try {
			node.putPOJO("music", mapper.writeValueAsString(music))
			node.putPOJO("ptcode", patterncode)
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("list", mapper.writeValueAsString(sendList))
			node.putPOJO("users", mapper.writeValueAsString(users))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/cntrank/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun cntrank(@PathVariable("page") page: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val rank = userService.getPlayCountAll()
		val sendList = Const.getPagedList(rank, page, 30)
		val pages = Const.getListPages(rank, 30)
		
		try {
			node.putPOJO("rank", mapper.writeValueAsString(sendList))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
		} catch (e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
}