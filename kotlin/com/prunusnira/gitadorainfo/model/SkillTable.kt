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

@Alias("skillTable")
class SkillTable(var musicid: Int,
				 var mname: String,
				 var ishot: String,
				 var patterncode: Int,
				 var rank: String,
				 var rate: Int,
				 var ratemx: Int,
				 var ratetbre: Int,
				 var ratetb: Int,
				 var version: Int,
				 var combo: Int,
				 var playtime: Int,
				 var level: Long,
				 var checkfc: String,
				 var meter: String) {
}