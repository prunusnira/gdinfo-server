/*****************************************************
 * GITADORA Info Server
 * Developed by Jeong Woo Lee a.k.a toycube-pf
 * (c) Nira & toycube-pf 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 *****************************************************/
package com.prunusnira.gitadorainfo.controller

import com.prunusnira.gitadorainfo.model.Music
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.MusicService
import com.prunusnira.gitadorainfo.service.SkillService
import com.prunusnira.gitadorainfo.service.UpdateService
import com.prunusnira.gitadorainfo.service.UserService
import com.prunusnira.gitadorainfo.tool.IPLogger
import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.StringUtils
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.InputStreamReader
import javax.servlet.http.HttpServletRequest

@Controller
class UpdateOldController {
	@Autowired
	lateinit var userService: UserService
	
	@Autowired
	lateinit var musicService: MusicService
	
	@Autowired
	lateinit var skillService: SkillService
	
	@Autowired
	lateinit var updateService: UpdateService
	
	@Value("classpath:/templates/crawlerold.html")
	lateinit var resource: Resource
	
	val logger = LoggerFactory.getLogger(javaClass)
	
	@RequestMapping(value=["/$/updateOld"],
		produces=["text/plain;charset=UTF-8"])
	@ResponseBody
	fun showUpdater(req: HttpServletRequest,
					model: Model): String {
		val session = req.session
		val token = session.getAttribute("token")
		
		lateinit var logAdd: String
		var user: User? = null
		var crawlToken: String? = ""
		var code = ""
		
		if(token != null) {
			user = userService.getUserByToken(token as String)
			crawlToken = updateService.getCrawlTokenByUserToken(token)
			
			if(crawlToken == null) {
				val id = String.format("%06d", user.id)
				crawlToken = id + RandomStringUtils.randomAlphanumeric(58)
				
				updateService.addCrawlToken(token, crawlToken)
				logAdd = "New token"
			}
			else {
				updateService.addCrawlToken(token, crawlToken)
				logAdd = "Token extended"
			}
			
			code = code.plus("var crawlToken = '").plus(crawlToken).plus("';\n")
						.plus("var userid = ").plus(user.id.toString()).plus(";\n")
						.plus("var username = '").plus(user.name).plus("';\n")
						.plus("var token = '").plus(token).plus("';\n")
		}
		else {
			logAdd = "No User Logined"
			
			code = code.plus("var crawlToken = '';\n")
						.plus("var userid = 0;\n")
						.plus("var username = '';\n")
						.plus("var token = '';\n")
		}
		
		// 스크립트 내용 만들기 -> 파일 불러오기로 대체
		val ins = resource.inputStream
		val isr = InputStreamReader(ins)
		val lines = isr.readLines()
		for(i in 0..lines.size-1) {
			code = code.plus(lines[i]).plus("\n")
		}
		
		if(user != null) model.addAttribute("user", user)
		if(crawlToken != null) model.addAttribute("crawlToken", crawlToken)
		IPLogger.writeLog(req, logger, userService, "Update(Old) "+logAdd)
		return code//"crawlerold"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateProfileOld/{gver}")
	@ResponseBody
	fun uploadProfile(req: HttpServletRequest,
					  @RequestBody json: String,
					  @PathVariable("gver") gver: String): String {
		val parser = JSONParser()
		var jsonobj = (parser.parse(json) as JSONObject)["profile"] as JSONObject
		
		/*try {
			jsonobj = (parser.parse(json) as JSONObject)["profile"] as JSONObject
		} catch(e: ParseException) {
			e.printStackTrace()
			return "500"
		}*/
		
		val gskill = (jsonobj["gskill"] as String).toDouble()
		val dskill = (jsonobj["dskill"] as String).toDouble()
		val crawlToken = jsonobj["crawlToken"] as String
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val userid = userService.getUserByToken(userToken).id
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		userService.updateOldSkill(userid, gskill, dskill, gver)
		IPLogger.writeLog(req, logger, userService, "Profile(Old) update")
		return "200"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateSkillOld/{gver}")
	@ResponseBody
	fun updateSkill(req: HttpServletRequest,
					@RequestBody json: String,
					@PathVariable("gver") gver: String): String {
		lateinit var list: JSONArray
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		
		val crawlToken = (parser.parse(json) as JSONObject)["crawlToken"] as String
		val objG = ((parser.parse(json) as JSONObject)["music"] as JSONObject)["gf"] as JSONArray
		val objD = ((parser.parse(json) as JSONObject)["music"] as JSONObject)["dm"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		if(objG.size > objD.size) {
			list = objG
		}
		else {
			list = objD
		}
		
		val uploadList = ArrayList<Skill>()
		
		IPLogger.writeLog(req,  logger, userService, "Upload pattenrs: " + list.size)
		
		for(i in 0..list.size-1) {
			val jsonMusic = list[i] as JSONObject
			val name = jsonMusic["name"] as String
			var music = musicList[name] as List<Music>
			
			if(music.size == 0) {
				IPLogger.writeLog(req,  logger, userService, "Music no match: " + name)
				continue
			}
			
			val mdata  = music[0]
			val pattern = jsonMusic["data"] as JSONArray
			
			for(j in 0..pattern.size-1) {
				val jsonPattern = pattern[j] as JSONObject
				val patterncode = Math.toIntExact(jsonPattern["patterncode"] as Long)
				var rateStr = jsonPattern["rate"] as String
				if(rateStr == "-") rateStr = "0"
				else if(rateStr == "NO") {
					rateStr = "0"
				}
				else if(rateStr == "MAX" || rateStr == "100" || rateStr == "100.00") {
					rateStr = "10000"
				}
				else {
					rateStr = rateStr.replace("%", "")
				}
				val rate = rateStr.replace(".", "").toInt()
				
				val skill = Skill(profile.id, mdata.id, mdata.version, patterncode, rate)
				uploadList.add(skill)
				if(uploadList.size == 50) {
					skillService.addResultOld(uploadList, gver)
					uploadList.clear()
					IPLogger.writeLog(req,  logger, userService, "Uploaded(Old) 50")
				}
			}
		}
		
		if(uploadList.size != 0) {
			skillService.addResultOld(uploadList, gver)
			IPLogger.writeLog(req,  logger, userService, "Uploaded(Old) "+uploadList.size)
		}
		IPLogger.writeLog(req,  logger, userService, "Skill upload(Old) complete")
		return "200"
	}
}