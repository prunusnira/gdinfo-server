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

import com.prunusnira.gitadorainfo.model.MostPlayedMusic
import com.prunusnira.gitadorainfo.model.MostPlayedPattern
import com.prunusnira.gitadorainfo.model.Pattern
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.SkillTable
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface SkillMapper {
	fun addResult(@Param("list") skill: ArrayList<Skill>)
	
	fun addResultOld(@Param("skill") skill: ArrayList<Skill>,
					 @Param("gver") gver: String)
	
	fun addResultOne(@Param("item") item: Skill)
	
	fun getSkillOnePattern(@Param("userid") userid: Int,
						   @Param("musicid") musicid: Int,
						   @Param("ptcode") ptcode: Int): Skill
	
	fun getSkill(@Param("userid") userid: Int,
				 @Param("musicid") musicid: Int): List<Skill>
	
	fun getSkillAll(@Param("userid") userid: Int,
					@Param("gtype") gtype: String,
					@Param("page") page: Int,
					@Param("levels") levels: ArrayList<Int>,
					@Param("ranks") ranks: ArrayList<String>,
					@Param("vers") vers: ArrayList<Int>,
					@Param("hot") hot: String,
					@Param("order") order: String): List<SkillTable>
	
	fun getSkillTop(@Param("version") version: Int,
					@Param("userid") userid: Int,
					@Param("gtype") gtype: String): List<SkillTable>
	
	fun getSkillTarget(@Param("version") version: Int,
					   @Param("userid") userid: Int,
					   @Param("type") type: String,
					   @Param("gtype") gtype: String): List<SkillTable>
	
	fun getSkillPattern(@Param("mid") mid: Int,
						@Param("p") patterncode: Int,
						@Param("version") ver: Int): List<Pattern>
	
	fun getSkillPatternSelf(@Param("mid") mid: Int,
							@Param("p") patterncode: Int,
							@Param("uid") userid: Int): Pattern
	
	fun getPlayCountGF(@Param("userid") userid: Int): Int
	
	fun getPlayCountDM(@Param("userid") userid: Int): Int
	
	fun getPatternCountGF(@Param("uid") uid: Int,
						  @Param("rank") rank: String,
						  @Param("level") level: Int): Int
	
	fun getPatternCountDM(@Param("uid") uid: Int,
						  @Param("rank") rank: String,
						  @Param("level") level: Int): Int
	
	fun getMybestPattern(@Param("userid") userid: Int): List<MostPlayedPattern>
	
	fun getMybestPatternG(@Param("userid") userid: Int): List<MostPlayedPattern>
	
	fun getMybestPatternD(@Param("userid") userid: Int): List<MostPlayedPattern>
	
	fun getMybestMusic(@Param("userid") userid: Int): List<MostPlayedMusic>
	
	fun getEXCData(@Param("gtype") gtype: String,
				   @Param("hot") hot: String): List<SkillTable>
	
	fun resetSkill(@Param("id") id: Int)
}