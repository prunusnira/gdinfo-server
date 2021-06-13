/* GITADORA Info Server
 * Developed by Jeong Woo Lee a.k.a toycube-pf
 * (c) Nira & toycube-pf 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 */
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
import org.springframework.web.bind.annotation.RequestParam

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
					model: Model,
					@RequestParam(value="token", required=false) token: String?): String {
		val session = req.session
		var tokenval: String? = token
		
		lateinit var logAdd: String
		var user: User? = null
		var crawlToken: String? = ""
		var code = ""
		
		if(tokenval == null) {
			tokenval = session.getAttribute("token") as String?;
		}
		
		if(tokenval != null) {
			user = userService.getUserByToken(tokenval)
			crawlToken = updateService.getCrawlTokenByUserToken(tokenval)
			
			if(crawlToken == null) {
				val id = String.format("%06d", user.id)
				crawlToken = id + RandomStringUtils.randomAlphanumeric(58)
				
				updateService.addCrawlToken(tokenval, crawlToken)
				logAdd = "New token"
			}
			else {
				updateService.addCrawlToken(tokenval, crawlToken)
				logAdd = "Token extended"
			}
			
			code = code.plus("var crawlToken = '").plus(crawlToken).plus("';\n")
						.plus("var userid = ").plus(user.id.toString()).plus(";\n")
						.plus("var username = '").plus(user.name).plus("';\n")
						.plus("var token = '").plus(tokenval).plus("';\n")
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
		//IPLogger.writeLog(req, logger, userService, "Update(Old) "+logAdd)
		return code//"crawlerold"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateProfileOld/{gver}")
	@ResponseBody
	fun uploadProfile(req: HttpServletRequest,
					  @RequestBody json: String,
					  @PathVariable("gver") gver: String): String {
		val parser = JSONParser()
		var jsonobj = parser.parse(json) as JSONObject
		
		val gskill = (jsonobj["gskill"] as String).toDouble()
		val dskill = (jsonobj["dskill"] as String).toDouble()
		val crawlToken = jsonobj["crawlToken"] as String
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val userid = userService.getUserByToken(userToken).id
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		userService.updateOldSkill(userid, gskill, dskill, gver)
		//IPLogger.writeLog(req, logger, userService, "Profile(Old) update")
		return "200"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateSkillOld/{gver}")
	@ResponseBody
	fun updateSkill(req: HttpServletRequest,
					@RequestBody json: String,
					@PathVariable("gver") gver: String): String {
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		val parsed = parser.parse(json) as JSONObject
		val crawlToken = parsed["crawlToken"] as String
		val musicData = parsed["musicData"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		val uploadList = ArrayList<Skill>()
		for(i in 0 until musicData.size) {
			val jsonMusic = musicData[i] as JSONObject
			val name = jsonMusic["musictitle"] as String
			val patternData = jsonMusic["data"] as JSONArray
			
			// 곡 정보 처리, 구곡의 데이터 추가이므로 별도로 곡의 데이터를 넣을 필요는 없음
			var music = musicList[name] as List<Music>
			
			if(music.size == 0) {
				//IPLogger.writeLog(req,  logger, userService, "Music no match: " + name)
				continue
			}
			
			val mdata  = music[0]
			
			// 패턴별 순회
			for(j in 0 until patternData.size) {
				val pt = patternData[j] as JSONObject
				
				val ptcode = Math.toIntExact(pt["ptcode"] as Long)
				val playtime = Math.toIntExact(pt["playcount"] as Long)
				val cleartime = Math.toIntExact(pt["clearcount"] as Long)
				val rateStr = pt["rate"] as String
				var rank = ""
				var rate = 0
				
				// rateStr에서 rate 판정
				if(rateStr == "-") {
					rate = 0
					rank = "E"
				}
				else if(rateStr == "NO") {
					rate = 0
					rank = "F"
				}
				else if(rateStr == "MAX" || rateStr == "100" || rateStr == "100.00") {
					rate = 10000
					rank = "EXC"
				}
				else {
					rate = rateStr.replace("%", "").replace(".", "").toInt()
				}
				
				val skill = Skill(profile.id, mdata.id, mdata.version, ptcode, rank, rate)
				uploadList.add(skill)
				if(uploadList.size == 50) {
					skillService.addResultOld(uploadList, gver)
					uploadList.clear()
					//IPLogger.writeLog(req,  logger, userService, "Uploaded(Old) 50")
				}
			}
		}
		
		if(uploadList.size != 0) {
			skillService.addResultOld(uploadList, gver)
			//IPLogger.writeLog(req,  logger, userService, "Uploaded(Old) "+uploadList.size)
		}
		//IPLogger.writeLog(req,  logger, userService, "Skill upload(Old) complete")
		return "200"
	}
}