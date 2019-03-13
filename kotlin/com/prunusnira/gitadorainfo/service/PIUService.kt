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

import com.prunusnira.gitadorainfo.mapper.PIUMapper
import com.prunusnira.gitadorainfo.model.PIUPattern
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PIUService {
	@Autowired
	lateinit var piuMapper: PIUMapper
	
	fun getPatterns(type: String, level: Int): List<PIUPattern> {
		var typei = 0
		if(type == "s") typei = 0
		if(type == "d") typei = 1
		
		return piuMapper.getPatterns(typei, level);
	}
	
	fun getPatternsOver(type: String): List<PIUPattern> {
		val patterns = ArrayList<PIUPattern>()
		
		if(type == "s") {
			patterns.addAll(getPatterns("s", 24))
			patterns.addAll(getPatterns("s", 25))
			patterns.addAll(getPatterns("s", 26))
		}
		else if(type == "d") {
			patterns.addAll(getPatterns("d", 25))
			patterns.addAll(getPatterns("d", 26))
			patterns.addAll(getPatterns("d", 27))
			patterns.addAll(getPatterns("d", 28))
		}
		
		return patterns
	}
}