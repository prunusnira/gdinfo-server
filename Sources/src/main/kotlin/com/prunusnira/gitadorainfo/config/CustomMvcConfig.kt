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
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import com.prunusnira.gitadorainfo.data.SecretConst

@Configuration
@EnableWebMvc
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
	    	.addResourceLocations(SecretConst.musicimgServer); // for real server
    		//.addResourceLocations(SecretConst.musicimgLocal); // for local test
        registry
	    	.addResourceHandler("/board/**")
	    	.addResourceLocations(SecretConst.boardServer); // for real server
			//.addResourceLocations(SecretConst.boardLocal); // for local test
		registry
			.addResourceHandler("/file/snapshot/**")
			.addResourceLocations(SecretConst.snapshotServer); // for real server
			// .addResourceLocations(SecretConst.snapshotLocal); // for local test
	}
	
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "OPTIONS")
			.allowedHeaders("*")
			/*.allowedHeaders("X-Requested-With", "Content-Type", "Origin", "Accept")
			.allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Accept", "X-Requested-With", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
            .exposedHeaders("Access-Control-Expose-Headers", "Authorization", "Cache-Control", "Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
			.allowCredentials(true)
			.maxAge(3600);*/
	}
}