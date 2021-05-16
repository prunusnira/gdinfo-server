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

@Alias("tower")
class Tower(var floor: Int,
			var musicid: Int,
			var mname: String,
			var ptcode: Int,
			var level: Int,
			var rate: Int,
			var fc: Boolean,
			var description: String) {
}