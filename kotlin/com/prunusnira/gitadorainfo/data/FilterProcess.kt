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
package com.prunusnira.gitadorainfo.data

class FilterProcess {
	companion object {
		fun filterLevel(level: Int?): ArrayList<Int> {
			val levels = ArrayList<Int>()
			if(level != null) {
				val levellist = filterBinaryProcess(level)
				for(l in levellist) {
					when(l) {
						1->levels.add(100)
						2->levels.add(150)
						3->levels.add(200)
						4->levels.add(250)
						5->levels.add(300)
						6->levels.add(350)
						7->levels.add(400)
						8->levels.add(450)
						9->levels.add(500)
						10->levels.add(550)
						11->levels.add(600)
						12->levels.add(650)
						13->levels.add(700)
						14->levels.add(750)
						15->levels.add(800)
						16->levels.add(850)
						17->levels.add(900)
						18->levels.add(950)
					}
				}
			}
			return levels
		}
		
		fun filterRank(rank: Int?): ArrayList<String> {
			val ranks = ArrayList<String>()
			val ranklist = filterBinaryProcess(rank)
			for(r in ranklist) {
				when(r) {
					1->ranks.add("F")
					2->ranks.add("E")
					3->ranks.add("D")
					4->ranks.add("C")
					5->ranks.add("B")
					6->ranks.add("A")
					7->ranks.add("S")
					8->ranks.add("SS")
					9->ranks.add("EXC")
				}
			}
			return ranks
		}
		
		fun filterRankComp(rank: Int?): ArrayList<String> {
			val ranks = ArrayList<String>()
			val ranklist = filterBinaryProcess(rank)
			for(r in ranklist) {
				when(r) {
					1->ranks.add("none")
					2->ranks.add("F")
					3->ranks.add("C")
					4->ranks.add("B")
					5->ranks.add("A")
					6->ranks.add("S")
					7->ranks.add("SS")
					8->ranks.add("EXC")
				}
			}
			return ranks
		}
		
		fun filterVer(version: String?): ArrayList<Int> {
			val vers = ArrayList<Int>()
			if(version != null && version != "") {
				for(i in 0..version.length/2-1) {
					vers.add(Integer.valueOf(version.substring(i*2, i*2+2)))
				}
			}
			if(vers.contains(0))
				vers.clear()
			
			return vers
		}
		
		fun filterHot(hot: String?): String {
			var hotv = ""
			if(hot != null) {
				if(hot.length != 1)
					hotv = ""
				else
					hotv = hot
			}
			return hotv
		}
		
		fun filterOrder(order: String?): String {
			if(order == null) return "lvdesc"
			else return order
		}
		
		fun filterOrderComp(order: String?): String {
			if(order == null) return "ratediffasc"
			else return order
		}
		
		fun filterRival(rival: Int?):ArrayList<String> {
			val rivals = ArrayList<String>()
			var rvchk = filterBinaryProcess(rival)
			for(r in rvchk) {
				when(r) {
					1->rivals.add("win")
					2->rivals.add("lose")
					3->rivals.add("draw")
				}
			}
			return rivals
		}
		
		fun filterBinaryProcess(data: Int?): ArrayList<Int> {
			if(data == null) return ArrayList<Int>()
			
			val list = ArrayList<Int>()
			var idx = 1
			var d = data!!
			while(d > 0) {
				if(d and 1 == 1) {
					list.add(idx)
				}
				d = d shr 1
				idx++
			}
			return list
		}
	}
}