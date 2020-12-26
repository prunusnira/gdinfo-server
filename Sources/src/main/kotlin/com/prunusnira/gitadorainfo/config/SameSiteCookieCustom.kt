package com.prunusnira.gitadorainfo.config

import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.apache.catalina.Context
import org.apache.tomcat.util.http.Rfc6265CookieProcessor
import org.springframework.stereotype.Component

@Component
class SameSiteCookieCustom: WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
	override fun customize(server: TomcatServletWebServerFactory) {
		server.getTomcatContextCustomizers()
			.add(object: TomcatContextCustomizer {
				override fun customize(context: Context) {
					val cookieProcessor = Rfc6265CookieProcessor()
		            cookieProcessor.setSameSiteCookies("None")
		            context.setCookieProcessor(cookieProcessor)
				}
			}
		);
	}
}