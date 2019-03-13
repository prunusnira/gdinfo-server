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

class Const {
	enum class INFOVER(val value: Int) {
		CURRENT(0), TB(1), TBRE(2), MX(3), EXC(4)
	}
	
	companion object {
		fun getPtcodeFromString(pt: String): Int {
			var ptcode = 0
			
			when(pt) {
				"gbsc" -> ptcode = 1
				"gadv" -> ptcode = 2
				"gext" -> ptcode = 3
				"gmas" -> ptcode = 4
				"bbsc" -> ptcode = 5
				"badv" -> ptcode = 6
				"bext" -> ptcode = 7
				"bmas" -> ptcode = 8
				"dbsc" -> ptcode = 9
				"dadv" -> ptcode = 10
				"dext" -> ptcode = 11
				"dmas" -> ptcode = 12
			}
			
			return ptcode
		}
		
		fun getPtstringFromCode(pt: Int): String {
			var ptcode:String = ""
			
			when(pt) {
				1 -> ptcode = "gbsc"
				2 -> ptcode = "gadv"
				3 -> ptcode = "gext"
				4 -> ptcode = "gmas"
				5 -> ptcode = "bbsc"
				6 -> ptcode = "badv"
				7 -> ptcode = "bext"
				8 -> ptcode = "bmas"
				9 -> ptcode = "dbsc"
				10 -> ptcode = "dadv"
				11 -> ptcode = "dext"
				12 -> ptcode = "dmas"
			}
			
			return ptcode
		}
		
		fun <T> getPagedList(list: List<T>, page: Int, size: Int):ArrayList<T> {
			val send = ArrayList<T>()
			
			val lsize = list.size
			if(lsize <= size) {
				send.addAll(list)
			}
			else {
				if(page*size < lsize) {
					send.addAll(list.subList((page-1)*size, page*size))
				}
				else {
					send.addAll(list.subList((page-1)*size, lsize))
				}
			}
			
			return send
		}
		
		fun <T> getListPages(list:List<T>, size:Int): Int {
			if(list.size % size == 0)
				return list.size/size
			else
				return list.size/size + 1
		}
		
		val currentVer = 27
	}
}