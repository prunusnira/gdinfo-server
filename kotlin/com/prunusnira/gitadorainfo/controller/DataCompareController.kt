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
import com.prunusnira.gitadorainfo.service.RivalService
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
import javax.servlet.http.HttpServletRequest

@Controller
class DataCompareController {
	@Autowired
	lateinit var userService:UserService
	
	@Autowired
	lateinit var rivalService:RivalService
	
	@RequestMapping(value=["/d/comparison/{id}/{gtype}/{page}"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun targetSkill(req: HttpServletRequest,
					@PathVariable("id") id:Int,
					@PathVariable("gtype") gtype:String,
					@PathVariable("page") page:Int,
					@RequestParam(value="lv", required=false) level:Int?,
					@RequestParam(value="rank", required=false) rank:Int?,
					@RequestParam(value="ver", required=false) ver:String?,
					@RequestParam(value="hot", required=false) hot:String?,
					@RequestParam(value="rival", required=false) rival:Int?,
					@RequestParam(value="order", required=false) order:String?)
	:String {
		val mapper = ObjectMapper()
		val node = mapper.createObjectNode()
		
		/*
		 * sequence
		 * 1. Get User's All Skill Data
		 * 2. Get Opponent's All Skill Data
		 * 3. Make a INNER JOIN BY music id and pattern id for both player.
		 * 4. Get 1P WIN, 2P WIN, DRAW, NO PLAY at specific pattern by statistic query
		 * 5. other informations are given by AJAX
		 */
		val session = req.session
		val token = session.getAttribute("token") as String
		
		val rivalUser = userService.getUserById(id)
		val currentUser = userService.getUserByToken(token)
		
		// param settigs
		val levels = FilterProcess.filterLevel(level)
		val ranks = FilterProcess.filterRankComp(rank)
		val vers = FilterProcess.filterVer(ver)
		val hotv = FilterProcess.filterHot(hot)
		val rivals = FilterProcess.filterRival(rival)
		val orderval = FilterProcess.filterOrderComp(order)
		
		val winLoseData = rivalService.getWinLose(currentUser, rivalUser, gtype)
		var comparison = ArrayList<Map<String, String>>()
		comparison.addAll(rivalService.getComparisonAll(currentUser, rivalUser, levels,
			ranks, vers, hotv, orderval, rivals, gtype))
		val sendList = Const.getPagedList(comparison, page, 30)
		val pages = Const.getListPages(comparison, 30)
		
		try {
			node.put("id", id)
			node.put("lv", level)
			node.put("rank", rank)
			node.put("ver", ver)
			node.put("hot", hot)
			node.put("rival", rival)
			node.put("page", page)
			node.put("pages", pages)
			node.put("order", order)
			node.put("gtype", gtype)
			node.put("rivalUser", mapper.writeValueAsString(rivalUser))
			node.put("currentUser", mapper.writeValueAsString(currentUser))
			node.put("winLose", mapper.writeValueAsString(winLoseData))
			node.put("comparison", mapper.writeValueAsString(sendList))
		} catch(e:JsonProcessingException) {
			e.printStackTrace();
		}
		
		return node.toString()
	}
}