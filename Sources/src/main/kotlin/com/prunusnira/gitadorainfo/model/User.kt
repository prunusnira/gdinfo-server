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

@Alias("user")
data class User(var id: Int,
		   var titletower: String,
		   var title: String,
		   var name: String,
		   var token: String,
		   var gskill: Double,
		   var dskill: Double,
		   var gskillnx: Double,
		   var dskillnx: Double,
		   var gskillex: Double,
		   var dskillex: Double,
		   var gskillmx: Double,
		   var dskillmx: Double,
		   var gskilltbre: Double,
		   var dskilltbre: Double,
		   var gskilltb: Double,
		   var dskilltb: Double,
		   var gskillall: Double,
		   var dskillall: Double,
		   var gclearlv: Double,
		   var dclearlv: Double,
		   var gclearnum: Int,
		   var dclearnum: Int,
		   var gfclv: Double,
		   var dfclv: Double,
		   var gfcnum: Int,
		   var dfcnum: Int,
		   var gexclv: Double,
		   var dexclv: Double,
		   var gexcnum: Int,
		   var dexcnum: Int,
		   var opencount: String,
		   var countall: Int,
		   var countgf: Int,
		   var countdm: Int,
		   var comment: String,
		   var updatetime: Timestamp,
		   var uptimelong: Long,
		   var pausetype: String,
		   var pausedate: Timestamp?) {
	
	constructor(token: String)
			: this(0, "", "", "", token, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0,
					0, 0, 0.0, 0.0, 0, 0, "", 0, 0, 0, "",
					Timestamp(0), 0, "", null)
	
	constructor(name: String, gskill: Double, dskill: Double)
			: this(0, "", "", name, "", gskill, dskill,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0,
					0, 0, 0.0, 0.0, 0, 0, "", 0, 0, 0, "",
					Timestamp(0), 0, "", null)
	
	constructor(title:String, name: String, token: String,
				gskill: Double, dskill: Double,
				gskillall: Double, dskillall: Double,
				gclearlv: Double, dclearlv: Double,
				gclearnum: Int, dclearnum: Int,
				gfclv: Double, dfclv: Double,
				gfcnum: Int, dfcnum: Int,
				gexclv: Double, dexclv: Double,
				gexcnum: Int, dexcnum: Int)
			: this(0, "", title, name, token, gskill, dskill,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					gskillall, dskillall, gclearlv, dclearlv,
					gclearnum, dclearnum, gfclv, dfclv,
					gfcnum, dfcnum, gexclv, dexclv, gexcnum, dexcnum,
					"", 0, 0, 0, "", Timestamp(0), 0, "", null)
}