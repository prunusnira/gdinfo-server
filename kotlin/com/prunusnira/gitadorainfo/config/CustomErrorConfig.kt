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

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.boot.web.server.ErrorPage
import org.springframework.http.HttpStatus

@Configuration
class CustomErrorConfig {
	@Bean
	fun webServerFactory():ConfigurableServletWebServerFactory {
		val factory:TomcatServletWebServerFactory = TomcatServletWebServerFactory()
		factory.addErrorPages(ErrorPage(HttpStatus.NOT_FOUND, "/404"))
		factory.addErrorPages(ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"))
		return factory
	}
}