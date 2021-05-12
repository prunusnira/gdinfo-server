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

import com.prunusnira.gitadorainfo.model.CountRank
import com.prunusnira.gitadorainfo.model.RecentUser
import com.prunusnira.gitadorainfo.model.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface ProfileMapper {
	fun addUser(@Param("user") user: User)
	
	fun updateProfile(@Param("user") user: User)
	
	fun updateOldSkill(@Param("id") id: Int,
					   @Param("gf") gf: Double,
					   @Param("dm") dm: Double,
					   @Param("gver") gver: String)
	
	fun updateOpenCount(@Param("open") open: String,
						@Param("userid") userid: Int)
	
	fun updateComment(@Param("comment") comment: String,
					  @Param("userid") userid: Int)
	
	fun updatePlayCount(@Param("type") type: String,
						@Param("count") count: Int,
						@Param("userid") userid: Int)

	fun updatePlayCountDM(@Param("count") count: Int,
						@Param("userid") userid: Int)
	
	fun updateManualSkill(@Param("userid") userid: Int,
						  @Param("gtype") gtype: String,
						  @Param("skill") skill: Double)
	
	fun getUserById(@Param("id") userid: Int): User
	
	fun getUserByToken(@Param("token") token: String): User
	
	fun getUserSearchName(@Param("value") value: String): List<User>
	
	fun getUserSearchGSkill(@Param("value") value: Double): List<User>
	
	fun getUserSearchDSkill(@Param("value") value: Double): List<User>
	
	fun getPlayCountAll(): List<CountRank>
	
	fun getRecentUserList(): List<RecentUser>
	
	fun resetProfile(@Param("id") id: Int)
	
	fun getTowerTitle(@Param("userid") userid: Int): String
	
	fun setTowerTitle(@Param("userid") userid: Int,
					  @Param("title") title: String)
	
	fun getSkillRanking(@Param("gtype") gtype: String,
						@Param("page") page: Int): List<User>
}