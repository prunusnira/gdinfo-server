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

@Alias("music")
class Music(var id: Int,
			var name: String,
			var hurigana: String,
			var composer: String,
			var version: Int,
			var gbsc: Int,
			var gadv: Int,
			var gext: Int,
			var gmas: Int,
			var bbsc: Int,
			var badv: Int,
			var bext: Int,
			var bmas: Int,
			var dbsc: Int,
			var dadv: Int,
			var dext: Int,
			var dmas: Int,
			var hot: String,
			var removed: Int) {
}