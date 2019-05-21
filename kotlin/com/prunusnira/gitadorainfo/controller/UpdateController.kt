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
	
	@Value("classpath:/templates/crawler.html")
	lateinit var resource: Resource
	
	@Value("classpath:/templates/crawlerTest.html")
	lateinit var resourceTest: Resource
	
	val logger = LoggerFactory.getLogger(javaClass)
	
	@RequestMapping("/$/update")
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
		IPLogger.writeLog(req, logger, userService, "Update "+logAdd)
		return code//"crawler"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateProfile")
	@ResponseBody
	fun uploadProfile(req: HttpServletRequest,
					  @RequestBody json: String): String {
		val parser = JSONParser()
		var jsonobj = (parser.parse(json) as JSONObject)["profile"] as JSONObject
		
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
			return "501"
		}
		
		val prof = User(title, name, userToken, gskill, dskill,
				gskillall, dskillall, gclearlv, dclearlv, gclearnum, dclearnum,
				gfclv, dfclv, gfcnum, dfcnum, gexclv, dexclv, gexcnum, dexcnum)
		userService.updateUser(prof)
		userService.updateSkillRecord(userid, gskill, dskill)
		IPLogger.writeLog(req, logger, userService, "Profile update")
		return "200"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateBoard/{id}")
	@ResponseBody
	@Throws(IOException::class)
	fun uploadBoard(req: HttpServletRequest,
					@PathVariable("id") id: Int,
					@RequestBody imgStr: String): String {
		val imageByte = Base64.getDecoder().decode(imgStr)
		val bis = ByteArrayInputStream(imageByte)
		val img = ImageIO.read(bis)
		bis.close()
		
		val outputFile = File("/data/img/board/"+id+".png")
		outputFile.mkdirs()
		if(outputFile.exists()) {
			outputFile.delete()
			outputFile.createNewFile()
		}
		else {
			outputFile.createNewFile()
		}
		
		ImageIO.write(img, "png", outputFile)
		IPLogger.writeLog(req, logger, userService, "Board update")
		return "200"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateSkill")
	@ResponseBody
	fun updateSkill(req: HttpServletRequest,
					@RequestBody json: String): String {
		lateinit var gtype: String
		lateinit var list:JSONArray
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		val parsed = parser.parse(json) as JSONObject
		val crawlToken = parsed["crawlToken"] as String
		val objG = (parsed["music"] as JSONObject)["gf"] as JSONArray
		val objD = (parsed["music"] as JSONObject)["dm"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		if(objG.size > objD.size) {
			gtype = "gf"
			list = objG
		}
		else {
			gtype = "dm"
			list = objD
		}
		
		val uploadList = ArrayList<Skill>()
		
		IPLogger.writeLog(req,  logger, userService, "Upload pattenrs: " + list.size)
		
		for(i in 0..list.size-1) {
			val jsonMusic = list[i] as JSONObject
			val name = jsonMusic["name"] as String
			var music = musicList[name] as List<Music>?
			var newmusic = false
			println(name)

			if(music == null) {
				// Add new music to DB
				if(name != "") musicService.addNewMusicUpdater(name)
				println("NEW MUSIC ADDED ".plus(name))
				newmusic = true
			}
			else if(music.size > 1) {
				// nothing to do now
				println("SAME NAME, More than 2")
			}
			else {
				println("MUSIC ALREADY EXIST")
			}

			val lvmap = getLevelMap(jsonMusic) as HashMap<String, Int>
			
			if(gtype == "gf") {
				if(lvmap["gbsc"] == null) lvmap["gbsc"] = 0
				if(lvmap["gadv"] == null) lvmap["gadv"] = 0
				if(lvmap["gext"] == null) lvmap["gext"] = 0
				if(lvmap["gmas"] == null) lvmap["gmas"] = 0
				if(lvmap["bbsc"] == null) lvmap["bbsc"] = 0
				if(lvmap["badv"] == null) lvmap["badv"] = 0
				if(lvmap["bext"] == null) lvmap["bext"] = 0
				if(lvmap["bmas"] == null) lvmap["bmas"] = 0
			}
			else if(gtype == "dm") {
				if(lvmap["dbsc"] == null) lvmap["dbsc"] = 0
				if(lvmap["dadv"] == null) lvmap["dadv"] = 0
				if(lvmap["dext"] == null) lvmap["dext"] = 0
				if(lvmap["dmas"] == null) lvmap["dmas"] = 0
			}
			
			if(newmusic) {
				println("LEVEL MAP UPDATE")
				println(lvmap.toString())
			}
			
			musicService.updateMusicUpdater(name, lvmap, gtype)

			if(newmusic) {
				println("LEVEL DB UPDATE")
			}

			music = musicService.getMusicInfo(name)
			val mdata  = music[0]

			if(newmusic) {
				println("MUSIC INFO")
				println(mdata.toString())
			}

			val pattern = jsonMusic["data"] as JSONArray
			
			for(j in 0..pattern.size-1) {
				val jsonPattern = pattern[j] as JSONObject
				val patterncode = Math.toIntExact(jsonPattern["patterncode"] as Long)
				val playtime = (jsonPattern["playcount"] as String).toInt()
				val cleartime = (jsonPattern["clearcount"] as String).toInt()
				var rank = jsonPattern["rank"] as String
				var rateStr = jsonPattern["rate"] as String
				if(rateStr == "-") rateStr = "0"
				else if(rateStr == "NO") {
					rateStr = "0"
					rank = "F"
				}
				else if(rateStr == "MAX" || rateStr == "100" || rateStr == "100.00") {
					rateStr = "10000"
					rank = "EXC"
				}
				else {
					rateStr = rateStr.replace("%", "")
				}
				val rate = rateStr.replace(".", "").toInt()
				val score = (jsonPattern["score"] as String).toInt()
				val combo = (jsonPattern["combo"] as String).toInt()
				
				var checkfc = "N"
				val meter = jsonPattern["meter"] as String
				if(meter.length == 64 && !meter.contains("0")) {
					checkfc = "Y"
				}
				
				val skill = Skill(profile.id, mdata.id, mdata.version,
					patterncode, playtime, cleartime, rank, rate, score, combo,
					checkfc, meter)
				uploadList.add(skill)
				if(uploadList.size == 50) {
					skillService.addResult(uploadList)
					uploadList.clear()
					IPLogger.writeLog(req,  logger, userService, "Uploaded 50")
				}
			}
		}
		
		if(uploadList.size != 0) {
			skillService.addResult(uploadList)
			IPLogger.writeLog(req,  logger, userService, "Uploaded "+uploadList.size)
		}
		IPLogger.writeLog(req,  logger, userService, "Skill upload complete-"+profile.id)
		
		val gfc = skillService.getPlayCountGF(profile.id)
		val dfc = skillService.getPlayCountDM(profile.id)
		userService.updatePlayCount(gfc, dfc, profile.id)
		IPLogger.writeLog(req,  logger, userService, "Play count updated-"+profile.id)
		return "200"
	}
	
	@CrossOrigin("https://p.eagate.573.jp")
	@RequestMapping("/$/updateTarget")
	@ResponseBody
	fun updateSimpleSkill(req: HttpServletRequest,
						  @RequestBody json: String): String {
		lateinit var list: JSONArray
		lateinit var gtype: String
		val musicList = musicService.getMusicInfoAll()
		val parser = JSONParser()
		val parsed = parser.parse(json) as JSONObject
		val crawlToken = parsed["crawlToken"] as String
		val objG = (parsed["music"] as JSONObject)["gf"] as JSONArray
		val objD = (parsed["music"] as JSONObject)["dm"] as JSONArray
		
		val userToken = updateService.getUserTokenByCrawlToken(crawlToken)
		val profile = userService.getUserByToken(userToken)
		
		if(StringUtils.isEmpty(userToken)) {
			return "501"
		}
		
		if(objG.size > objD.size) {
			list = objG
			gtype = "gf"
		}
		else {
			list = objD
			gtype = "dm"
		}
		
		val uploadList = ArrayList<Skill>()
		for(i in 0..list.size-1) {
			println("====================")
			val jsonMusic = list[i] as JSONObject
			val name = jsonMusic["name"] as String
			var music = musicList[name] as List<Music>?
			var newmusic = false
			println(name)

			if(music == null) {
				println("NEW MUSIC FOUND")
				if(name != "") musicService.addNewMusicUpdater(name)
				println("NEW MUSIC ADDED ".plus(name))
				newmusic = true
			}
			else if(music.size > 1) {
				// nothing to do
				println("SAME NAME, More than 2")
			}
			else {
				println("MUSIC ALREADY EXIST")
			}
			
			var lvmap = getLevelMapFromSimple(jsonMusic) as HashMap<String, Int>
			
			if(newmusic) {
				if(gtype == "gf") {
					if(lvmap.get("gbsc") == null) lvmap["gbsc"] = 0
					if(lvmap.get("gadv") == null) lvmap["gadv"] = 0
					if(lvmap.get("gext") == null) lvmap["gext"] = 0
					if(lvmap.get("gmas") == null) lvmap["gmas"] = 0
					if(lvmap.get("bbsc") == null) lvmap["bbsc"] = 0
					if(lvmap.get("badv") == null) lvmap["badv"] = 0
					if(lvmap.get("bext") == null) lvmap["bext"] = 0
					if(lvmap.get("bmas") == null) lvmap["bmas"] = 0
				}
				else {
					if(lvmap.get("dbsc") == null) lvmap["dbsc"] = 0
					if(lvmap.get("dadv") == null) lvmap["dadv"] = 0
					if(lvmap.get("dext") == null) lvmap["dext"] = 0
					if(lvmap.get("dmas") == null) lvmap["dmas"] = 0
				}
			}
			else {
				lvmap = getLevelExist(name) as HashMap<String, Int>
			}
			
			if(newmusic) {
				println("LEVEL MAP UPDATE")
				println(lvmap.toString())
			}
			
			musicService.updateMusicUpdater(name, lvmap, gtype)
			
			if(newmusic) {
				println("LEVEL DB UPDATE")
			}
			
			music = musicService.getMusicInfo(name)
			val mdata = music[0]
			
			if(newmusic) {
				println("MUSIC INFO")
				println(mdata.toString())
			}
			
			val ptcode = Const.getPtcodeFromString(jsonMusic["type"] as String
					+ jsonMusic["diff"] as String)
			val playtime = 1
			val cleartime = 1
			var rank = ""
			var rateStr = jsonMusic["rate"] as String
			if(rateStr == "-") {
				rateStr = "0"
				rank = "E"
			}
			else if(rateStr == "NO") {
				rateStr = "0"
				rank = "F"
			}
			else if(rateStr == "MAX" || rateStr == "100" || rateStr == "100.00") {
				rateStr = "10000"
				rank = "EXC"
			}
			else {
				rateStr = rateStr.replace("%", "")
			}
			
			val rate = rateStr.replace(".", "").toInt()
			if(rate < 6300) rank = "C"
			else if(rate < 7300) rank = "B"
			else if(rate < 8000) rank = "A"
			else if(rate < 9500) rank = "S"
			else if(rate < 10000) rank = "SS"
			
			val score = 0
			val combo = 0
			val checkfc = "N"
			val meter = ""
			
			val skill = Skill(profile.id, mdata.id,
				mdata.version, ptcode, playtime, cleartime, rank, rate,
				score, combo, checkfc, meter)
			uploadList.add(skill)
			if(uploadList.size == 50) {
				skillService.addResult(uploadList)
				uploadList.clear()
				IPLogger.writeLog(req,  logger, userService, "Uploaded 50")
			}
		}
		if(uploadList.size != 0) {
			skillService.addResult(uploadList)
			IPLogger.writeLog(req,  logger, userService, "Uploaded "+uploadList.size)
		}
		IPLogger.writeLog(req,  logger, userService, "Simple skill upload complete")
		return "200"
	}
	
	fun getLevelMap(json: JSONObject): Map<String, Int> {
		val lvmap = HashMap<String, Int>()
		val arr = json["data"] as JSONArray
		
		for(i in 0..arr.size-1) {
			val pat = arr[i] as JSONObject
			val ptcode = Math.toIntExact(pat["patterncode"] as Long)
			val lva = (pat["level"] as String).split(".")
			val lv = (lva[0]+lva[1]).toInt()
			val pt = Const.getPtstringFromCode(ptcode)
			lvmap[pt] = lv
		}
		return lvmap
	}
	
	fun getLevelMapFromSimple(json: JSONObject): Map<String, Int> {
		val lvmap = HashMap<String, Int>()
		val ptype = (json["type"] as String)+(json["diff"] as String)
		val lv = (json["level"] as String).toInt()
		lvmap[ptype] = lv
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
}