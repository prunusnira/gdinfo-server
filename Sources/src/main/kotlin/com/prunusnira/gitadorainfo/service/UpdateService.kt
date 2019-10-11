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
package com.prunusnira.gitadorainfo.service

import com.prunusnira.gitadorainfo.mapper.UpdateMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdateService {
	@Autowired
	lateinit var updateMapper: UpdateMapper
	
	fun getUserTokenByCrawlToken(crawlToken: String): String {
		return updateMapper.getUserTokenByCrawlToken(crawlToken)
	}
	
	fun getCrawlTokenByUserToken(userToken: String): String? {
		return updateMapper.getCrawlTokenByUserToken(userToken)
	}
	
	fun addCrawlToken(token: String, crawlToken: String) {
		updateMapper.insertCrawlToken(token, crawlToken)
	}
}