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
package com.prunusnira.gitadorainfo.tool

import com.prunusnira.gitadorainfo.model.User
import com.prunusnira.gitadorainfo.service.UserService
import org.slf4j.Logger
import javax.servlet.http.HttpServletRequest

class IPLogger {
	companion object {
		fun writeLog(req: HttpServletRequest,
					 logger: Logger,
					 userService :UserService,
					 pagename: String) {
			var ip = req.getHeader("X-FORWARDED-FOR")
			if(ip == null) ip = req.remoteAddr
			
			val session = req.session
			val token = session.getAttribute("token") as String?
			var self: User? = null
			if(token != null)
				self = userService.getUserByToken(token)
			if(self == null) logger.info(pagename + "-" + ip)
			else logger.info(pagename + "-" + ip + "-" + self.id)
		}
		
		fun writeLog(req: HttpServletRequest,
					 logger: Logger,
					 p :User?,
					 pagename: String) {
			var ip = req.getHeader("X-FORWARDED-FOR")
			if(ip == null) ip = req.remoteAddr
			
			if(p == null) logger.info(pagename + "-" + ip)
			else logger.info(pagename + "-" + ip + "-" + p.id)
		}
	}
}