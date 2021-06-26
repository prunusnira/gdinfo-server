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

import com.prunusnira.gitadorainfo.data.Const
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
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.Base64
import javax.imageio.ImageIO
import javax.servlet.http.HttpServletRequest
import com.prunusnira.gitadorainfo.data.SecretConst
import kotlin.jvm.Throws
import org.springframework.web.bind.annotation.RequestParam

@Controller
class UpdateController {
	@Autowired
	lateinit var userService: UserService
	
	@Autowired
	lateinit var musicService: MusicService
	
	@Autowired
	lateinit var skillService: SkillService
	
	@Autowired
	lateinit var updateService: UpdateService
	
	@Value("classpath:/templates/crawlertest/index.html")
	lateinit var resource: Resource
	
	val logger = LoggerFactory.getLogger(javaClass)
	
	@RequestMapping(value=["/$/update"],
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
			
			code = code.plus("window.crawlToken = '").plus(crawlToken).plus("';\n")
						.plus("window.userid = ").plus(user.id.toString()).plus(";\n")
						.plus("window.username = '").plus(user.name).plus("';\n")
						.plus("window.token = '").plus(tokenval).plus("';\n")
		}
		else {
			logAdd = "No User Logined"
			
			code = code.plus("window.crawlToken = '';\n")
						.plus("window.userid = 0;\n")
						.plus("window.username = '';\n")
						.plus("window.token = '';\n")
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
		//IPLogger.writeLog(req, logger, userService, "Update "+logAdd)
		return code//"crawler"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateProfile")
	@ResponseBody
	fun uploadProfile(req: HttpServletRequest,
					  @RequestBody json: String): Int {
		val parser = JSONParser()
		var jsonobj = parser.parse(json) as JSONObject
		
		val title = jsonobj["title"] as String
		val name = jsonobj["name"] as String
		val gskill = (jsonobj["gskill"] as String).toDouble()
		val dskill = (jsonobj["dskill"] as String).toDouble()
		val gskillall = (jsonobj["gskillall"] as String).toDouble()
		val dskillall = (jsonobj["dskillall"] as String).toDouble()
		val gclearlv = (jsonobj["gclearlv"] as String).toDouble()
		val dclearlv = (jsonobj["dclearlv"] as String).toDouble()
		val gclearnum = (jsonobj["gclearnum"] as String).toInt()
		val dclearnum = (jsonobj["dclearnum"] as String).toInt()
		val gfclv = (jsonobj["gfclv"] as String).toDouble()
		val dfclv = (jsonobj["dfclv"] as String).toDouble()
		val gfcnum = (jsonobj["gfcnum"] as String).toInt()
		val dfcnum = (jsonobj["dfcnum"] as String).toInt()
		val gexclv = (jsonobj["gexclv"] as String).toDouble()
		val dexclv = (jsonobj["dexclv"] as String).toDouble()
		val gexcnum = (jsonobj["gexcnum"] as String).toInt()
		val dexcnum = (jsonobj["dexcnum"] as String).toInt()
		val crawlToken = jsonobj["crawlToken"] as String
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val userid = userService.getUserByToken(userToken).id
		
		if(StringUtils.isEmpty(userToken)) {
			return 501
		}
		
		val prof = User(title, name, userToken, gskill, dskill,
				gskillall, dskillall, gclearlv, dclearlv, gclearnum, dclearnum,
				gfclv, dfclv, gfcnum, dfcnum, gexclv, dexclv, gexcnum, dexcnum)
		userService.updateUser(prof)
		userService.updateSkillRecord(userid, gskill, dskill)
		//IPLogger.writeLog(req, logger, userService, "Profile update")
		return 200
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateBoard/{id}")
	@ResponseBody
	@Throws(IOException::class)
	fun uploadBoard(req: HttpServletRequest,
					@PathVariable("id") id: Int,
					@RequestBody imgStr: String): Int {
		val imageByte = Base64.getDecoder().decode(imgStr)
		val bis = ByteArrayInputStream(imageByte)
		val img = ImageIO.read(bis)
		bis.close()
		
		val outputFile = File(SecretConst.boardRealpathServer+id+".png")
		outputFile.mkdirs()
		if(outputFile.exists()) {
			outputFile.delete()
			outputFile.createNewFile()
		}
		else {
			outputFile.createNewFile()
		}
		
		ImageIO.write(img, "png", outputFile)
		//IPLogger.writeLog(req, logger, userService, "Board update")
		return 200
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateSkill")
	@ResponseBody
	fun updateSkill(req: HttpServletRequest,
					@RequestBody json: String): Int {
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		val parsed = parser.parse(json) as JSONObject
		val crawlToken = parsed["crawlToken"] as String
		val musicData = parsed["musicData"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return 501
		}
		
		val uploadList = ArrayList<Skill>()
		println("size: "+musicData.size)
		
		for(i in 0 until musicData.size) {
			val jsonMusic = musicData[i] as JSONObject
			val name = jsonMusic["musictitle"] as String
			val patternData = jsonMusic["data"] as JSONArray
			
			// 곡 정보 처리 (신곡인경우 신곡으로 데이터 추가)
			var music = musicList[name] as List<Music>?

			if(music == null) {
				if(name != "") musicService.addNewMusicUpdater(name, Const.currentVer)
			}
			else if(music.size > 1) {
				// nothing to do (SAME NAME, More than 2)
			}
			else {
				// music already exist
			}
			var lvmap = getLevelExist(name) as HashMap<String, Int>
			var newlvmap = getLevelMap(patternData) as HashMap<String, Int>
			
			if(newlvmap["gbsc"] == null) newlvmap["gbsc"] = 0
			if(newlvmap["gadv"] == null) newlvmap["gadv"] = 0
			if(newlvmap["gext"] == null) newlvmap["gext"] = 0
			if(newlvmap["gmas"] == null) newlvmap["gmas"] = 0
			if(newlvmap["bbsc"] == null) newlvmap["bbsc"] = 0
			if(newlvmap["badv"] == null) newlvmap["badv"] = 0
			if(newlvmap["bext"] == null) newlvmap["bext"] = 0
			if(newlvmap["bmas"] == null) newlvmap["bmas"] = 0
			if(newlvmap["dbsc"] == null) newlvmap["dbsc"] = 0
			if(newlvmap["dadv"] == null) newlvmap["dadv"] = 0
			if(newlvmap["dext"] == null) newlvmap["dext"] = 0
			if(newlvmap["dmas"] == null) newlvmap["dmas"] = 0
			
			if(newlvmap["gbsc"].greaterThan(0)) {
				lvmap["gbsc"] = newlvmap["gbsc"] as Int
			}
			if(newlvmap["gadv"].greaterThan(0)) {
				lvmap["gadv"] = newlvmap["gadv"] as Int
			}
			if(newlvmap["gext"].greaterThan(0)) {
				lvmap["gext"] = newlvmap["gext"] as Int
			}
			if(newlvmap["gmas"].greaterThan(0)) {
				lvmap["gmas"] = newlvmap["gmas"] as Int
			}
			if(newlvmap["bbsc"].greaterThan(0)) {
				lvmap["bbsc"] = newlvmap["bbsc"] as Int
			}
			if(newlvmap["badv"].greaterThan(0)) {
				lvmap["badv"] = newlvmap["badv"] as Int
			}
			if(newlvmap["bext"].greaterThan(0)) {
				lvmap["bext"] = newlvmap["bext"] as Int
			}
			if(newlvmap["bmas"].greaterThan(0)) {
				lvmap["bmas"] = newlvmap["bmas"] as Int
			}
			if(newlvmap["dbsc"].greaterThan(0)) {
				lvmap["dbsc"] = newlvmap["dbsc"] as Int
			}
			if(newlvmap["dadv"].greaterThan(0)) {
				lvmap["dadv"] = newlvmap["dadv"] as Int
			}
			if(newlvmap["dext"].greaterThan(0)) {
				lvmap["dext"] = newlvmap["dext"] as Int
			}
			if(newlvmap["dmas"].greaterThan(0)) {
				lvmap["dmas"] = newlvmap["dmas"] as Int
			}
			
			musicService.updateMusicUpdater(name, lvmap)
			
			music = musicService.getMusicInfo(name)
			val mdata = music[0]
			
			// 해당 곡의 각 패턴별 데이터 처리
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
				
				// 지정되지 않은 rank 판정
				if(rate < 6300) rank = "C"
				else if(rate < 7300) rank = "B"
				else if(rate < 8000) rank = "A"
				else if(rate < 9500) rank = "S"
				else if(rate < 10000) rank = "SS"
				
				val score = Math.toIntExact(pt["score"] as Long)
				val combo = Math.toIntExact(pt["combo"] as Long)
				
				val clearstat = pt["clearstat"] as String
				var checkfc = "N"
				if(clearstat == "FULL" || clearstat == "EXCELLENT") {
					checkfc = "Y"
				}
				
				val meter = pt["meter"] as String
			
				val skill = Skill(profile.id, mdata.id,
					mdata.version, ptcode, playtime, cleartime, rank, rate,
					score, combo, checkfc, meter)
				
				uploadList.add(skill)
				
				if(uploadList.size == 50) {
					skillService.addResult(uploadList)
					uploadList.clear()
					//IPLogger.writeLog(req,  logger, userService, "Uploaded 50")
				}
			}
		}
		if(uploadList.size != 0) {
			skillService.addResult(uploadList)
			//IPLogger.writeLog(req,  logger, userService, "Uploaded "+uploadList.size)
		}
		
		var gfc:Int = skillService.getPlayCountGF(profile.id)
		var dfc:Int = skillService.getPlayCountDM(profile.id)
		userService.updatePlayCount("gf", gfc, profile.id)
		userService.updatePlayCount("dm", dfc, profile.id)
		userService.updatePlayCount("all", gfc+dfc, profile.id)
		//IPLogger.writeLog(req,  logger, userService, "Play count updated-"+profile.id)
		return 200
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateTarget")
	@ResponseBody
	fun updateSimpleSkill(req: HttpServletRequest,
						  @RequestBody json: String): Int {
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		val parsed = parser.parse(json) as JSONObject
		val crawlToken = parsed["crawlToken"] as String
		val musicData = parsed["musicData"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return 501
		}
		
		val uploadList = ArrayList<Skill>()
		println("size: "+musicData.size)
		
		for(i in 0..musicData.size-1) {
			val jsonMusic = musicData[i] as JSONObject
			val name = jsonMusic["musictitle"] as String
			val patternData = jsonMusic["data"] as JSONArray
			
			// 곡 정보 처리 (신곡인경우 신곡으로 데이터 추가)
			var music = musicList[name] as List<Music>?

			if(music == null) {
				if(name != "") musicService.addNewMusicUpdater(name, Const.currentVer)
			}
			else if(music.size > 1) {
				// nothing to do (SAME NAME, More than 2)
			}
			else {
				// music already exist
			}
			
			var lvmap = getLevelExist(name) as HashMap<String, Int>
			var newlvmap = getLevelMap(patternData) as HashMap<String, Int>
			
			if(newlvmap["gbsc"] == null) newlvmap["gbsc"] = 0
			if(newlvmap["gadv"] == null) newlvmap["gadv"] = 0
			if(newlvmap["gext"] == null) newlvmap["gext"] = 0
			if(newlvmap["gmas"] == null) newlvmap["gmas"] = 0
			if(newlvmap["bbsc"] == null) newlvmap["bbsc"] = 0
			if(newlvmap["badv"] == null) newlvmap["badv"] = 0
			if(newlvmap["bext"] == null) newlvmap["bext"] = 0
			if(newlvmap["bmas"] == null) newlvmap["bmas"] = 0
			if(newlvmap["dbsc"] == null) newlvmap["dbsc"] = 0
			if(newlvmap["dadv"] == null) newlvmap["dadv"] = 0
			if(newlvmap["dext"] == null) newlvmap["dext"] = 0
			if(newlvmap["dmas"] == null) newlvmap["dmas"] = 0
			
			if(newlvmap["gbsc"].greaterThan(0)) {
				lvmap["gbsc"] = newlvmap["gbsc"] as Int
			}
			if(newlvmap["gadv"].greaterThan(0)) {
				lvmap["gadv"] = newlvmap["gadv"] as Int
			}
			if(newlvmap["gext"].greaterThan(0)) {
				lvmap["gext"] = newlvmap["gext"] as Int
			}
			if(newlvmap["gmas"].greaterThan(0)) {
				lvmap["gmas"] = newlvmap["gmas"] as Int
			}
			if(newlvmap["bbsc"].greaterThan(0)) {
				lvmap["bbsc"] = newlvmap["bbsc"] as Int
			}
			if(newlvmap["badv"].greaterThan(0)) {
				lvmap["badv"] = newlvmap["badv"] as Int
			}
			if(newlvmap["bext"].greaterThan(0)) {
				lvmap["bext"] = newlvmap["bext"] as Int
			}
			if(newlvmap["bmas"].greaterThan(0)) {
				lvmap["bmas"] = newlvmap["bmas"] as Int
			}
			if(newlvmap["dbsc"].greaterThan(0)) {
				lvmap["dbsc"] = newlvmap["dbsc"] as Int
			}
			if(newlvmap["dadv"].greaterThan(0)) {
				lvmap["dadv"] = newlvmap["dadv"] as Int
			}
			if(newlvmap["dext"].greaterThan(0)) {
				lvmap["dext"] = newlvmap["dext"] as Int
			}
			if(newlvmap["dmas"].greaterThan(0)) {
				lvmap["dmas"] = newlvmap["dmas"] as Int
			}
			
			musicService.updateMusicUpdater(name, lvmap)
			
			music = musicService.getMusicInfo(name)
			val mdata = music[0]
			
			// 해당 곡의 각 패턴별 데이터 처리
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
				
				// 지정되지 않은 rank 판정
				if(rate < 6300) rank = "C"
				else if(rate < 7300) rank = "B"
				else if(rate < 8000) rank = "A"
				else if(rate < 9500) rank = "S"
				else if(rate < 10000) rank = "SS"
				
				val score = Math.toIntExact(pt["score"] as Long)
				val combo = Math.toIntExact(pt["combo"] as Long)
				
				val clearstat = pt["clearstat"] as String
				var checkfc = "N"
				if(clearstat == "FULL" || clearstat == "EXCELLENT") {
					checkfc = "Y"
				}
				
				val meter = pt["meter"] as String
			
				val skill = Skill(profile.id, mdata.id,
					mdata.version, ptcode, playtime, cleartime, rank, rate,
					score, combo, checkfc, meter)
				
				uploadList.add(skill)
				
				if(uploadList.size == 50) {
					skillService.addResult(uploadList)
					uploadList.clear()
					//IPLogger.writeLog(req,  logger, userService, "Uploaded 50")
				}
			}
		}
		if(uploadList.size != 0) {
			skillService.addResult(uploadList)
			//IPLogger.writeLog(req,  logger, userService, "Uploaded "+uploadList.size)
		}
		//IPLogger.writeLog(req,  logger, userService, "Simple skill upload complete")
		return 200
	}
	
	fun getLevelMap(json: JSONArray): Map<String, Int> {
		val lvmap = HashMap<String, Int>()
		
		for(i in 0..json.size-1) {
			val pattern = json[i] as JSONObject
			val ptcode = Math.toIntExact(pattern["ptcode"] as Long)
			
			when (ptcode) {
				1 -> lvmap["gbsc"] = Math.toIntExact(pattern["level"] as Long)
				2 -> lvmap["gadv"] = Math.toIntExact(pattern["level"] as Long)
				3 -> lvmap["gext"] = Math.toIntExact(pattern["level"] as Long)
				4 -> lvmap["gmas"] = Math.toIntExact(pattern["level"] as Long)
				5 -> lvmap["bbsc"] = Math.toIntExact(pattern["level"] as Long)
				6 -> lvmap["badv"] = Math.toIntExact(pattern["level"] as Long)
				7 -> lvmap["bext"] = Math.toIntExact(pattern["level"] as Long)
				8 -> lvmap["bmas"] = Math.toIntExact(pattern["level"] as Long)
				9 -> lvmap["dbsc"] = Math.toIntExact(pattern["level"] as Long)
				10 -> lvmap["dadv"] = Math.toIntExact(pattern["level"] as Long)
				11 -> lvmap["dext"] = Math.toIntExact(pattern["level"] as Long)
				12 -> lvmap["dmas"] = Math.toIntExact(pattern["level"] as Long)
			}
		}
		return lvmap
	}
	
	fun getLevelExist(name: String): Map<String, Int> {
		val lvmap = HashMap<String, Int>()
		val info = musicService.getMusicInfo(name)
		val minfo = info[0]
		
		lvmap.put("gbsc", minfo.gbsc)
		lvmap.put("gadv", minfo.gadv)
		lvmap.put("gext", minfo.gext)
		lvmap.put("gmas", minfo.gmas)
		lvmap.put("bbsc", minfo.bbsc)
		lvmap.put("badv", minfo.badv)
		lvmap.put("bext", minfo.bext)
		lvmap.put("bmas", minfo.bmas)
		lvmap.put("dbsc", minfo.dbsc)
		lvmap.put("dadv", minfo.dadv)
		lvmap.put("dext", minfo.dext)
		lvmap.put("dmas", minfo.dmas)
		return lvmap
	}
	
	fun checkLvCorrect(json: JSONObject,
					   gtype: String,
					   lvmap: Map<String, Int>): Boolean {
		val arr = json["data"] as JSONArray
		
		for(i in 0..arr.size-1) {
			val pat = arr[i] as JSONObject
			val ptcode = Math.toIntExact(pat["patterncode"] as Long)
			val lva = (pat["level"] as String).split(".")
			val lv = (lva[0]+lva[1]).toInt()
			
			if(gtype == "gf") {
				when(ptcode) {
					1 -> if(lv != lvmap["gbsc"]) return false
					2 -> if(lv != lvmap["gadv"]) return false
					3 -> if(lv != lvmap["gext"]) return false
					4 -> if(lv != lvmap["gmas"]) return false
					5 -> if(lv != lvmap["bbsc"]) return false
					6 -> if(lv != lvmap["badv"]) return false
					7 -> if(lv != lvmap["bext"]) return false
					8 -> if(lv != lvmap["bmas"]) return false
				}
			}
			else if(gtype == "dm") {
				when(ptcode) {
					9 -> if(lv != lvmap["dbsc"]) return false
					10 -> if(lv != lvmap["dadv"]) return false
					11 -> if(lv != lvmap["dext"]) return false
					12 -> if(lv != lvmap["dmas"]) return false
				}
			}
		}
		return true
	}
	
	fun Int?.greaterThan(n: Int) = this != null && this > n
}