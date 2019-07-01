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
				 var level: Int,
				 var checkfc: String,
				 var meter: String) {
	constructor(musicid: Int, mname: String, ishot: String,
				patterncode: Long, version: Int, level: Int)
		: this(musicid, mname, ishot, patterncode.toInt(), "EXC", 10000, 0 ,0 ,0,
		version, 1, 1, level, "Y",
		"1111111111111111111111111111111111111111111111111111111111111111")
	constructor(musicid: Int, mname: String, ishot: String,
				patterncode: Int, rank: String, rate: Int,
				ratemx: Int, ratetbre: Int, ratetb: Int,
				version: Int, combo: Int, playtime: Int,
				level: Long, checkfc: String, meter: String)
		: this(musicid, mname, ishot, patterncode, rank, rate,
			ratemx, ratetbre, ratetb, version, combo, playtime,
			level.toInt(), checkfc, meter)
}