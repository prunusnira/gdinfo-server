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
import com.prunusnira.gitadorainfo.model.Music
import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.MusicService
import com.prunusnira.gitadorainfo.service.UserService
import com.prunusnira.gitadorainfo.data.Const
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class SearchController {
	@Autowired
	lateinit var userService: UserService
	
	@Autowired
	lateinit var musicService: MusicService
	
	@RequestMapping(value=["/search/{stype}/{val}/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun search(req: HttpServletRequest,
			   model: Model,
			   @PathVariable("stype") stype: String,
			   @PathVariable("val") value: String,
			   @PathVariable("page") page: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val session = req.session
		val token = session.getAttribute("token")
		
		if(value == "") {
			model.addAttribute("resultexist", "no")
			return "";
		}
		else if(stype == "name" || stype == "gskill" || stype == "dskill") {
			val userList = userService.getUserSearch(stype, value.toLowerCase())
			val sendList = Const.getPagedList(userList, page, 30)
			val pages = Const.getListPages(userList, 30)
			
			if(token != null) {
				val user = userService.getUserByToken(token as String)
				node.putPOJO("user", mapper.writeValueAsString(user))
			}
			
			node.putPOJO("stype", mapper.writeValueAsString(stype))
			node.putPOJO("val", mapper.writeValueAsString(value))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("resultexist", mapper.writeValueAsString("yes"))
			node.putPOJO("userList", mapper.writeValueAsString(sendList))
			return node.toString()
		}
		else if(stype == "music") {
			val musicList = musicService.getMusicSearch(value.toLowerCase())
			val sendList = Const.getPagedList(musicList, page, 30)
			val pages = Const.getListPages(musicList, 30)
			
			if(token != null) {
				val user = userService.getUserByToken(token as String)
				node.putPOJO("user", mapper.writeValueAsString(user))
			}
			
			node.putPOJO("stype", mapper.writeValueAsString(stype))
			node.putPOJO("val", mapper.writeValueAsString(value))
			node.putPOJO("page", page)
			node.putPOJO("pages", pages)
			node.putPOJO("resultexist", mapper.writeValueAsString("yes"))
			node.putPOJO("userList", mapper.writeValueAsString(sendList))
			return node.toString()
		}
		return ""
	}
}