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

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.UserIdSource
import org.springframework.social.config.annotation.EnableSocial
import org.springframework.social.config.annotation.SocialConfigurerAdapter
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.google.api.Google
import org.springframework.social.google.connect.GoogleConnectionFactory
import org.springframework.social.oauth2.OAuth2Parameters
import org.springframework.social.security.AuthenticationNameUserIdSource
import com.prunusnira.gitadorainfo.data.SecretConst

@Configuration
@EnableSocial
class CustomSocialSetting: SocialConfigurerAdapter() {
	val clientId = SecretConst.clientkey
	val clientSecret = SecretConst.clientsec
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	fun google(repository:ConnectionRepository): Google? {
		val connection = repository.findPrimaryConnection(Google::class.java)
		if(connection != null) {
			return connection.api
		}
		else {
			return null
		}
	}
	
	@Bean
	fun gcFactory(): GoogleConnectionFactory {
		return GoogleConnectionFactory(clientId, clientSecret)
	}
	
	@Bean
	fun oauth2Params(): OAuth2Parameters {
		val param = OAuth2Parameters()
		param.scope = "https://www.googleapis.com/auth/plus.login"
		param.redirectUri = "https://gitadora.info/oauth"
		return param
	}
	
	override fun getUserIdSource(): UserIdSource {
		return AuthenticationNameUserIdSource()
	}
}