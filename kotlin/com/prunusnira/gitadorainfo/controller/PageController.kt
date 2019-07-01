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

import com.prunusnira.gitadorainfo.data.Const
import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.UserService
import com.prunusnira.gitadorainfo.tool.IPLogger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@Controller
class PageController {
	val logger = LoggerFactory.getLogger(javaClass)
	
	@Autowired
	lateinit var userService: UserService
	
	@RequestMapping(value=["", "/", "/index"])
	fun index(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Index Page")
		return "index"
	}
	
	@RequestMapping(value=["/about0"])
	fun aboutAuto(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "How to-Auto")
		return "about/about0"
	}
	
	@RequestMapping(value=["/about1"])
	fun aboutManual(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "How to-Manual")
		return "about/about1"
	}
	
	@RequestMapping(value=["/about2"])
	fun aboutFilter(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "How to-Filter")
		return "about/about2"
	}
	
	@RequestMapping(value=["/terms"])
	fun terms(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Terms and conditions")
		return "terms"
	}
	
	@RequestMapping(value=["/qna"])
	fun qna(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "QnA")
		return "qna"
	}
	
	@RequestMapping(value=["/rank/{gtype}/{page}"])
	fun skillRanking(req: HttpServletRequest,
					 model: Model,
					 @PathVariable("gtype") gtype: String,
					 @PathVariable("page") page: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("gtype", gtype)
		model.addAttribute("page", page)
		IPLogger.writeLog(req, logger, userService, "Skill Ranking")
		return "skill/rank"
	}
	
	@RequestMapping(value=["/profile"])
	fun myProfile(req: HttpServletRequest)
	: String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val profile = userService.getUserByToken(token as String)
			val uid = profile.id
			IPLogger.writeLog(req, logger, userService, "My Profile")
			return "redirect:/profile/"+uid
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/profile/{id}"])
	fun profile(req: HttpServletRequest,
				model: Model,
				@PathVariable("id") userid: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("id", userid)
		IPLogger.writeLog(req, logger, userService, "Profile "+userid)
		return "user/profile"
	}
	
	@RequestMapping("/profile/towerstatus/{id}")
	fun profileTowerStatus(req: HttpServletRequest,
						   model: Model,
						   @PathVariable("id") uid: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("uid", uid)
		IPLogger.writeLog(req, logger, userService, "Profile Tower Stat "+uid)
		return "user/towerstat"
	}
	
	@RequestMapping(value=["/mybest"])
	fun myMostPlayed(req: HttpServletRequest): String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val profile = userService.getUserByToken(token as String)
			val userid = profile.id
			IPLogger.writeLog(req, logger, userService, "My most played")
			return "redirect:/mybest/"+userid
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/mybest/{id}"])
	fun mostPlayed(req: HttpServletRequest,
				   model: Model,
				   @PathVariable("id") userid: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("id", userid)
		IPLogger.writeLog(req, logger, userService, "Most played")
		return "user/mybest"
	}
	
	@RequestMapping(value=["/notplayed"])
	fun myNotPlayed(req: HttpServletRequest): String {
		val session = req.session
		val token = session.getAttribute("token")
		
		if(token != null) {
			val id = userService.getUserByToken(token as String).id
			IPLogger.writeLog(req, logger, userService, "My not played")
			return "redirect:/notplayed/gf/"+id+"/0/1"
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/notplayed/{gtype}/{id}/{vertype}/{page}"])
	fun notPlayed(req: HttpServletRequest,
				  model: Model,
				  @PathVariable("gtype") gtype: String,
				  @PathVariable("id") userid: Int,
				  @PathVariable("vertype") vertype: Int,
				  @PathVariable("page") page: Int,
				  @RequestParam(value="order", required=false) order: String?,
				  @RequestParam(value="lv", required=false) lv: Int?,
				  @RequestParam(value="ver", required=false) ver: String?,
				  @RequestParam(value="hot", required=false) hot: String?)
	: String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("page", page)
		model.addAttribute("gtype", gtype)
		model.addAttribute("userid", userid)
		model.addAttribute("vertype", vertype)
		if(order != null) model.addAttribute("order", order)
		if(lv != null) model.addAttribute("lv", lv)
		if(ver != null) model.addAttribute("ver", ver)
		if(hot != null) model.addAttribute("hot", hot)
		IPLogger.writeLog(req, logger, userService, "Not played")
		return "user/notplayed"
	}
	
	@RequestMapping(value=["/myskill/{gtype}"])
	fun mySkill(req: HttpServletRequest,
				@PathVariable("gtype") gtype: String): String {
		val session = req.session
		val token = session.getAttribute("token") as String?
		if(token != null) {
			val self = userService.getUserByToken(token)
			val id = self.id
			IPLogger.writeLog(req, logger, userService, "My skill")
			return "redirect:/skill/2/"+id+"/"+gtype+"/1/1"
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/skill/{ptype}/{id}/{gtype}/{page}/{order}"])
	fun skill(req: HttpServletRequest,
			  model: Model,
			  @PathVariable("gtype") gtype: String,
			  @PathVariable("ptype") ptype: Int,
			  @PathVariable("order") order: String,
			  @PathVariable("page") page: Int,
			  @PathVariable("id") userid: Int,
			  @RequestParam(value="lv", required=false) level: Int?,
			  @RequestParam(value="rank", required=false) rank: Int?,
			  @RequestParam(value="ver", required=false) ver: String?,
			  @RequestParam(value="hot", required=false) hot: String?,
			  @RequestParam(value="rival", required=false) rival: Int?)
	: String {
		val session = req.session
		val token = session.getAttribute("token")
		var loginid = 0
		if(token != null) {
			model.addAttribute("token", token as String)
			loginid = userService.getUserByToken(token).id
		}
		model.addAttribute("id", userid)
		model.addAttribute("order", order)
		model.addAttribute("gtype", gtype)
		model.addAttribute("ptype", ptype)
		model.addAttribute("page", page)
		if(level != null) model.addAttribute("lv", level)
		if(rank != null) model.addAttribute("rank", rank)
		if(ver != null) model.addAttribute("ver", ver)
		if(hot != null) model.addAttribute("hot", hot)
		if(rival != null) model.addAttribute("rival", rival)

		// 동일 유저 유무 확인
		if(loginid == userid) model.addAttribute("self", true)
		IPLogger.writeLog(req, logger, userService, "Skill")
		return "skill/skill"
	}
	
	@RequestMapping(value=["/skillscr/{ptype}/{id}/{gtype}/{page}/{order}"])
	fun skillScreenshot(req: HttpServletRequest,
			  model: Model,
			  @PathVariable("gtype") gtype: String,
			  @PathVariable("ptype") ptype: Int,
			  @PathVariable("order") order: String,
			  @PathVariable("page") page: Int,
			  @PathVariable("id") userid: Int,
			  @RequestParam(value="lv", required=false) level: Int?,
			  @RequestParam(value="rank", required=false) rank: Int?,
			  @RequestParam(value="ver", required=false) ver: String?,
			  @RequestParam(value="hot", required=false) hot: String?,
			  @RequestParam(value="rival", required=false) rival: Int?)
	: String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("id", userid)
		model.addAttribute("order", order)
		model.addAttribute("gtype", gtype)
		model.addAttribute("ptype", ptype)
		model.addAttribute("page", page)
		if(level != null) model.addAttribute("lv", level)
		if(rank != null) model.addAttribute("rank", rank)
		if(ver != null) model.addAttribute("ver", ver)
		if(hot != null) model.addAttribute("hot", hot)
		if(rival != null) model.addAttribute("rival", rival)
		IPLogger.writeLog(req, logger, userService, "Skill Screenshot")
		return "skill/skillscr"
	}

	@RequestMapping(value=["/snapshot"])
	fun mySnapshotList(req: HttpServletRequest, model: Model): String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val profile = userService.getUserByToken(token as String)
			val uid = profile.id
			IPLogger.writeLog(req, logger, userService, "My Snapshot List"+uid)
			return "redirect:/skill/snapshot/list/"+uid
		}
		else return "error/500"
	}

	@RequestMapping(value=["/skill/snapshot/list/{uid}"])
	fun snapshotList(req: HttpServletRequest, model: Model,
				@PathVariable("uid") uid: Int): String {
		var movable = false
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val profile = userService.getUserByToken(token as String)
			val id = profile.id
			if(id == uid) {
				model.addAttribute("uid", uid)
				IPLogger.writeLog(req, logger, userService, "Snapshot List")
				movable = true
			}
		}
		if(movable) return "skill/snapshot"
		else return "error/500"
	}

	@RequestMapping(value=["/skill/snapshot/view/{ptype}/{uid}/{date}/{gtype}"])
	fun snapshotView(req: HttpServletRequest, model: Model,
				@PathVariable("ptype") ptype: String,
				@PathVariable("uid") uid: Int,
				@PathVariable("date") date: String,
				@PathVariable("gtype") gtype: String): String {
		model.addAttribute("uid", uid)
		model.addAttribute("date", date)
		model.addAttribute("gtype", gtype)
		IPLogger.writeLog(req, logger, userService, "Snapshot View")
		System.out.println(ptype)
		if(ptype.equals("nr")) return "skill/snapnr"
		else if(ptype.equals("sh")) return "skill/snapsh"
		else return "error/404"
	}
	
	@RequestMapping(value=["/register"])
	fun manualRegister(req: HttpServletRequest): String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val userid = userService.getUserByToken(token as String).id
			IPLogger.writeLog(req, logger, userService, "Manual register")
			return "redirect:/register/"+userid
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/register/{id}"])
	fun manualRegisterPg(req: HttpServletRequest,
						 model: Model,
						 @PathVariable("id") id: Int,
						 @RequestParam(value="mid", required=false) mid: Int?,
						 @RequestParam(value="ver", required=false) ver: Int?): String {
		val session = req.session
		val token = session.getAttribute("token") as String
		val user = userService.getUserByToken(token)
		if(id == user.id) {
			model.addAttribute("token", token)
			model.addAttribute("id", id)
			model.addAttribute("mid", mid)
			model.addAttribute("ver", ver)
			return "pattern/register"
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/music/{mid}/{id}"])
	fun music(req: HttpServletRequest,
			  model: Model,
			  @PathVariable("mid") musicid: Int,
			  @PathVariable("id") userid: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("mid", musicid)
		model.addAttribute("uid", userid)
		IPLogger.writeLog(req, logger, userService, "Music "+musicid+" " +userid)
		return "skill/music"
	}
	
	@RequestMapping(value=["/ptrank/{ver}/{order}/{page}"])
	fun patternList(req: HttpServletRequest,
					model: Model,
					@PathVariable("ver") ver: String,
					@PathVariable("order") order: String,
					@PathVariable("page") page: Int,
					@RequestParam(value="hot", required=false) hot: String?): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("ver", ver)
		model.addAttribute("order", order)
		model.addAttribute("page", page)
		if(hot != null) model.addAttribute("hot", hot)
		IPLogger.writeLog(req, logger, userService, "Pattern list")
		return "pattern/rank"
	}
	
	@RequestMapping(value=["/ptdetail/{mid}/{p}/{page}"])
	fun patternRanking(req: HttpServletRequest,
					   model: Model,
					   @PathVariable("mid") mid: Int,
					   @PathVariable("p") patterncode: Int,
					   @PathVariable("page") page: Int,
					   @RequestParam(value="ver", required=false) version: Int?): String {
		var ver = Const.currentVer
		if(version != null) ver = version
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("mid", mid)
		model.addAttribute("ptcode", patterncode)
		model.addAttribute("page", page)
		model.addAttribute("version", ver)
		IPLogger.writeLog(req, logger, userService, "Pattern detail")
		return "pattern/detail"
	}
	
	@RequestMapping(value=["/cntrank/{page}"])
	fun cntrank(req: HttpServletRequest,
				model: Model,
				@PathVariable("page") page: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("page", page)
		IPLogger.writeLog(req, logger, userService, "Count rank")
		return "etc/countrank"
	}
	
	@RequestMapping(value=["/noie"])
	fun noie(req: HttpServletRequest): String {
		IPLogger.writeLog(req, logger, userService, "Access from ie")
		return "noie"
	}
	
	@RequestMapping(value=["/cleartable"])
	fun myClearTable(req: HttpServletRequest): String {
		val id = userService.getUserByToken(req.session.getAttribute("token") as String).id
		IPLogger.writeLog(req, logger, userService, "My clear table")
		return "redirect:/cleartable/"+id
	}
	
	@RequestMapping(value=["/cleartable/{id}"])
	fun clearTable(req: HttpServletRequest, model: Model,
				   @PathVariable("id") uid: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("id", uid)
		IPLogger.writeLog(req, logger, userService, "Clear table")
		return "user/cleartable"
	}
	
	@RequestMapping(value=["/404"])
	fun error404(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Error 404")
		return "error/404"
	}
	
	@RequestMapping(value=["/500"])
	fun error500(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Error 500")
		return "error/500"
	}
	
	@RequestMapping(value=["/reset"], method=[RequestMethod.POST])
	fun reset(req: HttpServletRequest,
			  model: Model,
			  @RequestParam("id") uid: Int): String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val user = userService.getUserByToken(token as String)
			IPLogger.writeLog(req, logger, userService, "Reset")
			
			if(user.id == uid) {
				model.addAttribute("token", token)
				model.addAttribute("id", uid)
				return "user/reset"
			}
			else return "error/500"
		}
		else {
			return "error/500"
		}
	}
	
	@RequestMapping(value=["/rivallist"])
	fun rivallist(req: HttpServletRequest, model: Model): String {
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
		val id = userService.getUserByToken(token as String).id
			model.addAttribute("id", id)
			model.addAttribute("token", token)
			IPLogger.writeLog(req, logger, userService, "Rival list")
			return "user/rivallist"
		}
		else {
			return "error/500"
		}
	}
	
	@RequestMapping(value=["/rivalfail"])
	fun rivalfail(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("referer", req.getHeader("referer"))
		IPLogger.writeLog(req, logger, userService, "Rival add failed")
		return "user/rivalexist"
	}
	
	@RequestMapping(value=["/comparison/{id}/{gtype}/{page}"])
	fun comaparison(req: HttpServletRequest,
					model: Model,
					@PathVariable("id") id: Int,
					@PathVariable("gtype") gtype: String,
					@PathVariable("page") page: Int,
					@RequestParam(value="lv", required=false) level: Int?,
					@RequestParam(value="rank", required=false) rank: Int?,
					@RequestParam(value="ver", required=false) ver: String?,
					@RequestParam(value="hot", required=false) hot: String?,
					@RequestParam(value="rival", required=false) rival: Int?,
					@RequestParam(value="order", required=false) order: String?): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) {
			model.addAttribute("token", token as String)
			model.addAttribute("id", id)
			model.addAttribute("gtype", gtype)
			model.addAttribute("page", page)
			if(level != null) model.addAttribute("lv", level)
			if(rank != null) model.addAttribute("rank", rank)
			if(ver != null) model.addAttribute("ver", ver)
			if(hot != null) model.addAttribute("hot", hot)
			if(rival != null) model.addAttribute("rival", rival)
			if(order != null) model.addAttribute("order", order)
			IPLogger.writeLog(req, logger, userService, "Comparison")
			return "comparison"
		}
		else return "error/500"
	}
	
	@RequestMapping(value=["/exc/{gtype}"])
	fun exc(req: HttpServletRequest,
			model: Model,
			@PathVariable("gtype") gtype: String): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("id", 0)
		model.addAttribute("order", "")
		model.addAttribute("gtype", gtype)
		model.addAttribute("ptype", 1000)
		model.addAttribute("page", 0)
		model.addAttribute("lv", null)
		model.addAttribute("rank", null)
		model.addAttribute("ver", null)
		model.addAttribute("hot", null)
		model.addAttribute("rival", null)
		IPLogger.writeLog(req, logger, userService, "Excellent")
		return "skill/skill"
	}
	
	@RequestMapping(value=["/search/{stype}/{val}/{page}"])
	fun search(req: HttpServletRequest,
			   model: Model,
			   @PathVariable("stype") stype: String,
			   @PathVariable("val") value: String,
			   @PathVariable("page") page: Int): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		model.addAttribute("stype", stype)
		model.addAttribute("val", value)
		model.addAttribute("page", page)
		IPLogger.writeLog(req, logger, userService, "Search")
		return "search"
	}
	
	@RequestMapping(value=["/tower/index"])
	fun towerIndex(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Tower index")
		return "tower/toweridx"
	}
	
	@RequestMapping(value=["/tower/howto"])
	fun towerHowto(req: HttpServletRequest, model: Model): String {
		val s = req.session
		val token = s.getAttribute("token")
		if(token != null) model.addAttribute("token", token as String)
		IPLogger.writeLog(req, logger, userService, "Tower Howto")
		return "tower/towerhowto"
	}
	
	@RequestMapping(value=["/tower/stat/{tvalue}"])
	fun towerStatus(req: HttpServletRequest,
					model: Model,
					@PathVariable("tvalue") tower: String): String {
		IPLogger.writeLog(req, logger, userService, "Tower status")
		val session = req.session
		val token = session.getAttribute("token")
		if(token != null) {
			val uid = userService.getUserByToken(token as String).id
			model.addAttribute("token", token)
			model.addAttribute("tower", tower)
			model.addAttribute("uid", uid)
			return "tower/towerstat"
		}
		else return "error/500"
	}
}