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

import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.social.google.api.Google
import org.springframework.social.google.api.impl.GoogleTemplate
import org.springframework.social.google.connect.GoogleConnectionFactory
import org.springframework.social.oauth2.GrantType
import org.springframework.social.oauth2.OAuth2Parameters
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@Controller
class LoginController {
	@Autowired
	lateinit var googleCon: GoogleConnectionFactory
	
	@Autowired
	lateinit var oauthParams: OAuth2Parameters
	
	@Autowired
	lateinit var userService: UserService
	
	@RequestMapping(value=["/login"])
	fun issueAuthUrl(req: HttpServletRequest,
					 model: Model): String {
		val session = req.session
		session.setAttribute("LoginReferer", req.getHeader("Referer"))
		val oauthOperations = googleCon.getOAuthOperations()
		val url = oauthOperations.buildAuthorizeUrl(
			GrantType.AUTHORIZATION_CODE, oauthParams)
		model.addAttribute("loginurl", url)
		model.addAttribute("referer", req.getHeader("Referer"))
		return "login"
	}
	
	@RequestMapping(value=["/oauth"])
	fun signIn(code: String) {
		val oauthOperations = googleCon.getOAuthOperations()
		val accessGrant = oauthOperations.exchangeForAccess(
			code, oauthParams.getRedirectUri(), null)
		var accessToken = accessGrant.getAccessToken()
		val expireTime = accessGrant.getExpireTime()
		if(expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken()
			// Access token expired
		}
		
		val connection = googleCon.createConnection(accessGrant)
		var google: Google?
		if(connection == null)
			google = GoogleTemplate(accessToken)
		else
			google = connection.api
		
		val plusOperations = google!!.plusOperations()
		val person = plusOperations.googleProfile
		person.emailAddresses
	}
	
	@CrossOrigin
	@RequestMapping(value=["/loginseq"], method=[RequestMethod.POST])
	fun loginSeq(req: HttpServletRequest,
				 model: Model,
				 @RequestParam("token") token: String): String {
		val session = req.session
		val user:User? = userService.getUserByToken(token)
		if(user == null) {
			// New User
			session.setAttribute("token", token)
			return "newuser"
		}
		else {
			if(user.pausetype == "None") {
				// Not paused
				if((session.getAttribute("token") != null
						&& session.getAttribute("token") != "")) {
					// session already exist
					return "redirect:"+session.getAttribute("LoginReferer")
				}
				else if((session.getAttribute("token") == null
						|| session.getAttribute("token") == "")) {
					// existing user, login now
					session.setAttribute("token", token)
					return "redirect:"+session.getAttribute("LoginReferer")
				}
				else {
					// new user
					session.setAttribute("token", token)
					return "newuser"
				}
			}
			else {
				model.addAttribute("type", user.pausetype)
				if(user.pausetype == "Temp") {
					val pausedate = user.pausedate!!.time
					val current = System.currentTimeMillis()
					if(pausedate > current) {
						model.addAttribute("date", user.pausedate)
						return "prohibit"
					}
					else {
						if((session.getAttribute("token") != null
								&& session.getAttribute("token") != "")) {
							return "redirect:"+session.getAttribute("LoginReferer")
						}
						else if((session.getAttribute("token") == null
								|| session.getAttribute("token") == "")) {
							session.setAttribute("token", token)
							return "redirect:"+session.getAttribute("LoginReferer")
						}
					}
				}
				else {
					return "prohibit"
				}
				return "prohibit"
			}
		}
	}
	
	@RequestMapping(value=["/newuser"])
	fun newUser(req: HttpServletRequest): String {
		val session = req.session
		val token = session.getAttribute("token") as String
		userService.addNewUser(token)
		session.setAttribute("token", token)
		return "redirect:/about0"
	}
	
	@RequestMapping("/dropuser")
	fun dropUser(req: HttpServletRequest): String {
		val session = req.getSession();
		session.setAttribute("token", "");
		return "redirect:/index";
	}
	
	@RequestMapping(value=["/logout"])
	fun logout(req: HttpServletRequest): String {
		val session = req.session
		session.setAttribute("token", null)
		return "redirect:/index";
	}
}