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
import com.prunusnira.gitadorainfo.model.PIUPattern
import com.prunusnira.gitadorainfo.service.PIUService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class PIUController {
	@Autowired
	lateinit var piuService: PIUService
	
	@RequestMapping("/piu")
	fun piuIdx(): String {
		return "piu/piuidx"
	}
	
	@RequestMapping(value=["/piu/data/{type}/{lv}"],
		method=[RequestMethod.POST],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun piuPatterns(@PathVariable("type") type: String,
					@PathVariable("lv") level: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val patterns = piuService.getPatterns(type, level)
		
		try {
			node.putPOJO("patterns", mapper.writeValueAsString(patterns))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/piu/data/over/{type}"],
		method=[RequestMethod.POST],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun patternDoubleOverLimit(@PathVariable("type") type: String): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val patterns = piuService.getPatternsOver(type)
		
		try {
			node.putPOJO("patterns", mapper.writeValueAsString(patterns))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
}