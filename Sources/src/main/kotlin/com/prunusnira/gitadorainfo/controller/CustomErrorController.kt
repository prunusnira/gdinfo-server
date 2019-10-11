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

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@Controller
class CustomErrorController: ErrorController {
	@RequestMapping(value=["/error"])
	fun error(req: HttpServletRequest): String {
		val stat = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString()
		
		if(stat.equals(HttpStatus.NOT_FOUND.toString(), ignoreCase=true)) {
			return "error/404"
		}
		else if(stat.equals(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ignoreCase=true)) {
			return "error/500"
		}
		
		return ""
	}
	
	override fun getErrorPath(): String {
		return "/error"
	}
}