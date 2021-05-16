/* GITADORA Info Server
 * Developed by Tae Jun Kang a.k.a Prunus Nira
 * (c) Nira 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 */
package com.prunusnira.gitadorainfo.service

import com.prunusnira.gitadorainfo.mapper.TowerMapper
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.Tower
import com.prunusnira.gitadorainfo.model.TowerFloorStatus
import com.prunusnira.gitadorainfo.model.TowerClearStatus
import com.prunusnira.gitadorainfo.model.TowerManage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TowerService {
	@Autowired
	lateinit var towerMapper: TowerMapper
	
	fun getTowerInfo(towername: String): TowerManage {
		return towerMapper.getTowerInfo(towername)
	}
	
	fun getTowerData(towername: String): List<Tower> {
		return towerMapper.getTowerData(towername)
	}
	
	fun getTowerList(): List<String> {
		return towerMapper.getTowerList()
	}
	
	fun updateTowerProfile(id: Int, skillService: SkillService): Boolean {
		towerMapper.removeFloorStatus(id)
		towerMapper.removeTowerStatus(id)
		val towerList = getTowerList()
		for(s in towerList) {
			if(towerCheck(s)) {
				val info = getTowerInfo(s)
				val sizeAll = IntArray(info.levels)
				val sizeCl = IntArray(info.levels)
				val towerData = getTowerData(s)
				
				for(t in towerData) {
					val skill:Skill? = skillService.getSkill(id, t.musicid, t.ptcode)
					val clear = checkClear(t, skill)
					if(clear == true) {
						towerMapper.updateFloorStatus(id, s, t.floor, t.musicid, t.ptcode, "Y")
					}
					else {
						towerMapper.updateFloorStatus(id, s, t.floor, t.musicid, t.ptcode, "N")
					}
					if(clear == true) sizeCl[t.floor]++
					sizeAll[t.floor]++
				}
				
				for(i in 0..info.levels-1) {
					val all = sizeAll[i]
					val clear = sizeCl[i]
					if(clear >= all*0.7) towerMapper.updateTowerStatus(id, s, i, "Y")
					else towerMapper.updateTowerStatus(id, s, i, "N")
				}
			}
		}
		return true
	}
	
	fun checkClear(d: Tower, skill: Skill?): Boolean {
		var clear = true
		if(skill != null) {
			if(d.rate > 0 &&
				(
					(d.rate > skill.rate) &&
					(d.rate > skill.ratetb) &&
					(d.rate > skill.ratetbre) &&
					(d.rate > skill.ratemx) &&
					(d.rate > skill.rateex) &&
					(d.rate > skill.ratenx)
				)
			) {
				clear = false
			}
			if(d.fc == true) {
				if(skill.checkfc == "N") {
					clear = false
				}
			}
		}
		else clear = false
		return clear
	}
	
	fun towerCheck(s: String): Boolean {
		if(s == "towerSample" || s == "towerManage"
			|| s == "towerTest" || s == "towerStatusClear"
			|| s == "towerStatusFloor")
			return false
		else return true
	}
	
	fun selectFloorStatus(uid: Int): List<TowerFloorStatus> {
		return towerMapper.selectFloorStatus(uid)
	}
	
	fun selectTowerStatus(uid: Int): List<TowerClearStatus> {
		return towerMapper.selectTowerStatus(uid)
	}
}