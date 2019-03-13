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

import com.prunusnira.gitadorainfo.model.Comparison
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface RivalMapper {
	fun getWinLoseData(@Param("currentUserId") currentUserId: Int,
					   @Param("rivalUserId") rivalUserId: Int,
					   @Param("gtype") gtype: String): Comparison
	
	fun getComparison(@Param("currentUserId") currentUserId: Int,
					  @Param("rivalUserId") rivalUserId: Int): List<Map<String, String>>
	
	fun getComparisonAll(@Param("currentUserId") currentUserId: Int,
						 @Param("rivalUserId") rivalUserId: Int,
						 @Param("levels") levels: ArrayList<Int>,
						 @Param("ranks") ranks: ArrayList<String>,
						 @Param("vers") vers: ArrayList<Int>,
						 @Param("hot") hot: String,
						 @Param("order") order: String,
						 @Param("rivals") rivals: ArrayList<String>,
						 @Param("gtype") gtype: String): List<Map<String, String>>
}