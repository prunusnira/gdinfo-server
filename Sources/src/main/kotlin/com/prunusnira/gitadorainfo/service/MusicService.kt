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

import com.prunusnira.gitadorainfo.mapper.MusicMapper
import com.prunusnira.gitadorainfo.model.Music
import com.prunusnira.gitadorainfo.model.NotPlayed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MusicService {
	@Autowired
	lateinit var musicMapper: MusicMapper
	
	fun getMusicInfo(name: String): List<Music> {
		return musicMapper.getMusicInfo(name)
	}
	
	fun getMusicInfo(mid: Int): Music {
		return musicMapper.getMusicInfoInt(mid)
	}
	
	fun getMusicInfoAll(): Map<String, ArrayList<Music>> {
		val minfo = ArrayList<Music>()
		val list = musicMapper.getMusicInfoAll()
		for(d: Music in list) minfo.add(d)
		
		val info = HashMap<String, ArrayList<Music>>()
		for(m: Music in minfo) {
			if(!info.containsKey(m.name)) {
				val value = ArrayList<Music>()
				value.add(m)
				info.put(m.name, value)
			}
			else {
				val value = info[m.name]
				value!!.add(m)
				info.put(m.name, value)
			}
		}
		return info
	}
	
	fun getMusicInfoAllList(vers: ArrayList<Int>,
							hot: String,
							order: String): List<Music> {
		return musicMapper.getMusicInfoAllList(vers, hot, order)
	}
	
	fun getMusicInfoAllListAllSong(hot: String,
								   order: String): List<Music> {
		return musicMapper.getMusicInfoAllListAllSong(hot, order)
	}
	
	fun getMusicSearch(value: String): List<Music> {
		return musicMapper.getMusicSearch(value)
	}
	
	fun getTotalPatternCountGF(): ArrayList<Int> {
		val count = ArrayList<Int>()
		var key = 0
		for(i in 0..17) {
			when(i) {
				0 -> key = 100
				1 -> key = 150
				2 -> key = 200
				3 -> key = 250
				4 -> key = 300
				5 -> key = 350
				6 -> key = 400
				7 -> key = 450
				8 -> key = 500
				9 -> key = 550
				10 -> key = 600
				11 -> key = 650
				12 -> key = 700
				13 -> key = 750
				14 -> key = 800
				15 -> key = 850
				16 -> key = 900
				17 -> key = 950
			}
			count.add(musicMapper.getTotalPatternCountGF(key))
		}
		return count
	}
	
	fun getTotalPatternCountDM(): ArrayList<Int> {
		val count = ArrayList<Int>()
		var key = 0
		for(i in 0..17) {
			when(i) {
				0 -> key = 100
				1 -> key = 150
				2 -> key = 200
				3 -> key = 250
				4 -> key = 300
				5 -> key = 350
				6 -> key = 400
				7 -> key = 450
				8 -> key = 500
				9 -> key = 550
				10 -> key = 600
				11 -> key = 650
				12 -> key = 700
				13 -> key = 750
				14 -> key = 800
				15 -> key = 850
				16 -> key = 900
				17 -> key = 950
			}
			count.add(musicMapper.getTotalPatternCountDM(key))
		}
		return count
	}
	
	fun getNotPlayed(gtype: String,
					 id: Int,
					 vertype: Int,
					 version: ArrayList<Int>,
					 order: String,
					 levels: ArrayList<Int>,
					 hot: String): List<NotPlayed> {
		return musicMapper.getNotPlayed(gtype, id, vertype, version, order, levels, hot)
	}
	
	fun addNewMusicUpdater(name: String, currentver: Int) {
		musicMapper.addNewMusicUpdater(name, currentver)
	}
	
	fun updateMusicUpdater(name: String,
						   lvtable: Map<String, Int>,
						   gtype: String) {
		if(gtype == "gf")
			musicMapper.updateMusicUpdaterGF(name, lvtable)
		else
			musicMapper.updateMusicUpdaterDM(name, lvtable)
	}
}