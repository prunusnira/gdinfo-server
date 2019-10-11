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

import com.prunusnira.gitadorainfo.model.Tower
import com.prunusnira.gitadorainfo.model.TowerClearStatus
import com.prunusnira.gitadorainfo.model.TowerFloorStatus
import com.prunusnira.gitadorainfo.model.TowerManage
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface TowerMapper {
	fun getTowerData(@Param("tower") tower: String): List<Tower>
	
	fun getTowerList(): List<String>
	
	fun getTowerInfo(@Param("name") name: String): TowerManage
	
	fun removeFloorStatus(@Param("uid") id: Int)
	
	fun removeTowerStatus(@Param("uid") id: Int)
	
	fun updateFloorStatus(@Param("uid") id: Int,
						  @Param("tower") tower: String,
						  @Param("floor") floor: Int,
						  @Param("mid") mid: Int,
						  @Param("ptcode") ptcode: Int,
						  @Param("clear") clear: String)
	
	fun updateTowerStatus(@Param("uid") id: Int,
						  @Param("tower") tower: String,
						  @Param("floor") floor: Int,
						  @Param("clear") clear: String)
	
	fun selectFloorStatus(@Param("uid") uid: Int): List<TowerFloorStatus>
	
	fun selectTowerStatus(@Param("uid") uid: Int): List<TowerClearStatus>
}