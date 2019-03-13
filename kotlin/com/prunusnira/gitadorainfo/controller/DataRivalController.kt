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

import com.prunusnira.gitadorainfo.model.Rival
import com.prunusnira.gitadorainfo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
class DataRivalController {
	@Autowired
	lateinit var userService: UserService
	
	@RequestMapping(value=["/rivaladd/{id}/{gtype}"])
	fun rivaladd(req: HttpServletRequest,
				 model: Model,
				 @PathVariable("id") id: Int,
				 @PathVariable("gtype") gtype: String): String {
		val session = req.session
		val token = session.getAttribute("token") as String
		val myid = userService.getUserByToken(token).id
		val referer = req.getHeader("Referer")
		val rd:Rival? = userService.getOneRival(myid, id, gtype)
		if(rd == null) {
			userService.addRival(myid, id, gtype)
			return "redirect:"+referer
		}
		else {
			model.addAttribute("referer", referer)
			return "user/rivalexist"
		}
	}
	
	@RequestMapping(value=["/rivalrm/{id}/{gtype}"])
	fun rivalrm(req: HttpServletRequest,
				@PathVariable("id") id: Int,
				@PathVariable("gtype") gtype: String): String {
		val session = req.session
		val token = session.getAttribute("token") as String
		val myid = userService.getUserByToken(token).id
		val referer = req.getHeader("Referer")
		userService.delRival(myid, id, gtype)
		return "redirect:"+referer
	}
}