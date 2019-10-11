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

@Alias("notPlayed")
class NotPlayed(var id: Int,
				var name: String,
				var hurigana: String,
				var ptcode: Int,
				var lv: Int,
				var version: Int,
				var hot: String) {
	constructor(id: Int, name: String, hurigana: String, ptcode: Long,
				lv: Int, version: Int, hot: String)
	: this(id, name, hurigana, ptcode.toInt(), lv, version, hot)
}