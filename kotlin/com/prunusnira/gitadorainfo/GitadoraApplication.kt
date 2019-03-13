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
package com.prunusnira.gitadorainfo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import kotlin.jvm.JvmStatic

@SpringBootApplication
@MapperScan("com.prunusnira.gitadorainfo.mapper")
class GitadoraApplication: SpringBootServletInitializer() {
	companion object {
		@JvmStatic
		fun main(args:Array<String>) {
			SpringApplication.run(GitadoraApplication::class.java, *args)
		}
	}
	
	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(GitadoraApplication::class.java)
	}
}