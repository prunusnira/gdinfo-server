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
package com.prunusnira.gitadorainfo.config

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.ModelAndView
import kotlin.jvm.Throws

class LoginInterceptor:HandlerInterceptorAdapter() {
	private val logger = LoggerFactory.getLogger(javaClass)
	
	@Throws(Exception::class)
	override fun preHandle(req: HttpServletRequest,
						   res: HttpServletResponse,
						   handler: Any):Boolean {
		logger.info("Login Prehandle")
		
		val session = req.session
		
		if(session.getAttribute("token") == null
			|| session.getAttribute("token") == "") {
			res.sendRedirect("login")
			return false
		}
		else {
			return super.preHandle(req, res, handler)
		}
	}
	
	@Throws(Exception::class)
	override fun postHandle(req: HttpServletRequest,
							res: HttpServletResponse,
							handler: Any,
							model: ModelAndView) {
		logger.info("Login Posthandle")
		super.postHandle(req, res, handler, model)
	}
}