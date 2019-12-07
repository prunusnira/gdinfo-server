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
import com.prunusnira.gitadorainfo.data.TowerData
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.Tower
import com.prunusnira.gitadorainfo.service.SkillService
import com.prunusnira.gitadorainfo.service.TowerService
import com.prunusnira.gitadorainfo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TowerController {
	@Autowired
	lateinit var towerService: TowerService
	
	@Autowired
	lateinit var skillService: SkillService
	
	@Autowired
	lateinit var userService: UserService
	
	@RequestMapping(value=["/towerdata/{towername}/{userid}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun towerData(@PathVariable("towername") towername: String,
				  @PathVariable("userid") userid: Int): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val towersongs = towerService.getTowerData(towername)
		val tower = towerService.getTowerInfo(towername)
		val data = ArrayList<TowerData>()
		
		for(d in towersongs) {
			val skill:Skill? = skillService.getSkill(userid, d.musicid, d.ptcode)
			val clear = towerService.checkClear(d, skill)
			
			data.add(TowerData(d, skill, clear))
		}
		try {
			node.putPOJO("tower", mapper.writeValueAsString(tower))
			node.putPOJO("towerlist", mapper.writeValueAsString(data))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	
	
	@RequestMapping(value=["/towerlist"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun towerList(): String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		val towerlist = towerService.getTowerList()
		try {
			node.putPOJO("towerlist", mapper.writeValueAsString(towerlist))
		} catch(e: JsonProcessingException) {
			e.printStackTrace()
		}
		return node.toString()
	}
	
	@RequestMapping(value=["/towertitle/{userid}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun towerTitle(@PathVariable("userid") userid: Int): String {
		return userService.getTowerTitle(userid)
	}
	
	@RequestMapping(value=["/towertitleapply/{userid}/{title}"])
	@ResponseBody
	fun towerTitleApply(@PathVariable("userid") userid: Int,
						@PathVariable("title") title: String): String {
		userService.setTowerTitle(userid, title)
		return "ok"
	}
}