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
import com.prunusnira.gitadorainfo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RecentController {
	val logger = LoggerFactory.getLogger(javaClass)
	
	@Autowired
	lateinit var userService: UserService
	
	@RequestMapping(value=["/d/recent"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun recent(): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val recentUser = userService.getRecentUserList()
		
		try {
			node.putPOJO("recent", mapper.writeValueAsString(recentUser))
		} catch(e:JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
}