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

@Alias("skill")
data class Skill(var userid: Int,
			var musicid: Int,
			var version: Int,
			var patterncode: Int, // 1: gbsc, 12: dmas (g-b-d)
			var playtime: Int,
			var cleartime: Int,
			var rank: String,
			var rate: Int,
			 var ratehv: Int,
			var ratenx: Int,
			var rateex: Int,
			var ratemx: Int,
			var ratetbre: Int,
			var ratetb: Int,
			var score: Int,
			var combo: Int,
			var checkfc: String,
			var meter: String,
			var level: Int) {
	constructor(userid: Int, musicid: Int, version: Int, patterncode: Int, rank: String, rate: Int)
			: this(userid, musicid, version, patterncode, 0, 0, rank, rate,
				0, 0, 0, 0, 0, 0, 0, 0, "", "", 0)
	
	constructor(userid: Int, musicid: Int, version: Int, patterncode: Int,
				rank: String, rate: Int, score: Int, combo: Int, checkfc: String)
			: this(userid, musicid, version, patterncode, 0, 0, rank, rate,
				0, 0, 0, 0, 0, 0, score, combo, checkfc, "", 0)
	
	constructor(userid: Int, musicid: Int, version: Int, patterncode: Int,
				playtime: Int, cleartime: Int, rank: String, rate: Int,
				score: Int, combo: Int, checkfc: String, meter: String)
			: this(userid, musicid, version, patterncode,
					playtime, cleartime, rank, rate, 0, 0, 0, 0, 0, 0, score, combo,
					checkfc, meter, 0)
	
	constructor(userid: Int, musicid: Int, version: Int, patterncode: Int,
				playtime: Int, cleartime: Int, rank: String, rate: Int, ratehv: Int,
				ratenx: Int, rateex: Int, ratemx: Int, ratetbre: Int, ratetb: Int,
				score: Int, combo: Int, checkfc: String, meter: String)
			: this(userid, musicid, version, patterncode,
					playtime, cleartime, rank, rate, ratehv, ratenx, rateex, ratemx, ratetbre, ratetb,
					score, combo, checkfc, meter, 0)
}