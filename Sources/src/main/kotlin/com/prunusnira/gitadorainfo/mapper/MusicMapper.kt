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

import com.prunusnira.gitadorainfo.model.Music
import com.prunusnira.gitadorainfo.model.NotPlayed
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface MusicMapper {
	fun getMusicInfo(@Param("name") name: String): List<Music>
	
	fun getMusicInfoInt(@Param("mid") mid: Int): Music
	
	fun getMusicInfoAll(): List<Music>
	
	fun getMusicInfoAllList(@Param("vers") vers: ArrayList<Int>,
							@Param("hot") hot: String,
							@Param("order") order: String): List<Music>
	
	fun getMusicInfoAllListAllSong(@Param("hot") hot: String,
								   @Param("order") order: String): List<Music>
	
	fun getMusicSearch(@Param("value") value: String): List<Music>
	
	fun getTotalPatternCountGF(@Param("key") key: Int): Int
	
	fun getTotalPatternCountDM(@Param("key") key: Int): Int
	
	fun getNotPlayed(@Param("gtype") gtype: String,
					 @Param("id") id: Int,
					 @Param("vertype") vertype: Int,
					 @Param("vers") version: ArrayList<Int>,
					 @Param("order") order: String,
					 @Param("levels") levels: ArrayList<Int>,
					 @Param("hot") hot: String): List<NotPlayed>
	
	fun addNewMusicUpdater(@Param("name") name: String,
						   @Param("currentver") currentver: Int)
	
	fun updateMusicUpdaterGF(@Param("name") name: String,
							 @Param("lvtable") lvtable: Map<String, Int>)
	
	fun updateMusicUpdaterDM(@Param("name") name: String,
							 @Param("lvtable") lvtable: Map<String, Int>)
	
	fun updateMusicUpdater(@Param("name") name: String,
							 @Param("lvtable") lvtable: Map<String, Int>)
}