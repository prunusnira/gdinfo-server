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
package com.prunusnira.gitadorainfo.model

import org.apache.ibatis.type.Alias

@Alias("clearTable")
data class ClearTable(var totalPatternCountGF: ArrayList<Int>,
				 var totalPatternCountDM: ArrayList<Int>,
				 var patternCountGF: Map<String, ArrayList<Int>>,
				 var patternCountDM: Map<String, ArrayList<Int>>) {
	constructor(): this(ArrayList<Int>(), ArrayList<Int>(),
		HashMap<String, ArrayList<Int>>(), HashMap<String, ArrayList<Int>>())
}