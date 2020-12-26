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
import java.sql.Timestamp

@Alias("recentUser")
data class RecentUser(var id: Int,
					var titletower: String,
					var name: String,
					var gskill: Double,
					var dskill: Double,
					var updatetime: Timestamp,
					var uptimelong: Long,
					var opencount: String) {
	constructor(id: Int, titletower: String, name: String,
				gskill: Double, dskill: Double, updatetime: Timestamp, opencount: String)
	: this(id, titletower, name, gskill, dskill, updatetime, 0, opencount)
}