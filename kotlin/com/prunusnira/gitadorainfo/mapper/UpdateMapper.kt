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
package com.prunusnira.gitadorainfo.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UpdateMapper {
	fun getUserTokenByCrawlToken(@Param("crawlToken") crawlToken: String): String
	
	fun getCrawlTokenByUserToken(@Param("token") userToken: String): String?
	
	fun insertCrawlToken(@Param("token") token: String,
						 @Param("crawlToken") crawlToken: String)
}