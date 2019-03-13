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

import com.prunusnira.gitadorainfo.mapper.RivalMapper
import com.prunusnira.gitadorainfo.model.Comparison
import com.prunusnira.gitadorainfo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RivalService {
	@Autowired
	lateinit var rivalMapper: RivalMapper
	
	fun getWinLose(currentUser: User,
				   rivalUser: User,
				   gtype: String): Comparison {
		return rivalMapper.getWinLoseData(currentUser.id, rivalUser.id, gtype)
	}
	
	fun getComparison(currentUser: User,
					  rivalUser: User): List<Map<String, String>> {
		return rivalMapper.getComparison(currentUser.id, rivalUser.id)
	}
	
	fun getComparisonAll(currentUser: User,
						 rivalUser: User,
						 levels: ArrayList<Int>,
						 ranks: ArrayList<String>,
						 vers: ArrayList<Int>,
						 hot: String,
						 order: String,
						 rivals: ArrayList<String>,
						 gtype: String): List<Map<String, String>> {
		return rivalMapper.getComparisonAll(currentUser.id, rivalUser.id,
			levels, ranks, vers, hot, order, rivals, gtype)
	}
}