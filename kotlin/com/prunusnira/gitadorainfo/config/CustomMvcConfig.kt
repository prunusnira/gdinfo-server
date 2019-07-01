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

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CustomMvcConfig:WebMvcConfigurer, WebMvcRegistrations {
	override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
		registry
        	.addResourceHandler("/**")
        	.addResourceLocations("classpath:/static/", "classpath:/template/");
        registry
        	.addResourceHandler("/resources/**")
        	.addResourceLocations("/resources");
        registry
	    	.addResourceHandler("/img/music/**")
	    	.addResourceLocations("file:///data/img/music/"); // for real server
    		//.addResourceLocations("file:///F:/programming/web/gdinfo/img/music/"); // for local test
        registry
	    	.addResourceHandler("/board/**")
	    	.addResourceLocations("file:///data/img/board/"); // for real server
			//.addResourceLocations("file:///F:/programming/web/gdinfo/img/board/"); // for local test
        registry
    		.addResourceHandler("/img/piumusic/**")
	    	.addResourceLocations("file:///data/img/piumusic/"); // for real server
			//.addResourceLocations("file:///F:/programming/web/gdinfo/img/piumusic/"); // for local test
		registry
			.addResourceHandler("/file/snapshot/**")
			.addResourceLocations("file:///data/snapshot/"); // for real server
			// .addResourceLocations("file:///F:/programming/web/gdinfo/data/snapshot/"); // for local test
	}
	
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowedHeaders("X-Requested-With", "Content-Type", "Origin", "Accept")
			.allowCredentials(true)
			.maxAge(3600);
	}
}