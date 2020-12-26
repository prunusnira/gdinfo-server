package com.prunusnira.gitadorainfo.config

import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import javax.servlet.Filter
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CORSFilter: Filter {
	@Throws(ServletException::class)
	override fun init(filterConfig: FilterConfig) {

    }

	@Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest,
    		servletResponse: ServletResponse,
    		filterChain: FilterChain) {
        val response = servletResponse as HttpServletResponse
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept")
        response.setHeader("Access-Control-Expose-Headers", "Location")
        filterChain.doFilter(servletRequest, servletResponse)
    }

    override fun destroy() {

    }
}