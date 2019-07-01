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
package com.prunusnira.gitadorainfo.service

import com.prunusnira.gitadorainfo.data.Const
import com.prunusnira.gitadorainfo.mapper.ProfileMapper
import com.prunusnira.gitadorainfo.mapper.SkillMapper
import com.prunusnira.gitadorainfo.model.MostPlayedMusic
import com.prunusnira.gitadorainfo.model.MostPlayedPattern
import com.prunusnira.gitadorainfo.model.Pattern
import com.prunusnira.gitadorainfo.model.Skill
import com.prunusnira.gitadorainfo.model.SkillTable
import com.prunusnira.gitadorainfo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.json.simple.JSONObject
import org.json.simple.JSONArray
import java.util.Date
import java.text.SimpleDateFormat
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.FileReader
import java.io.BufferedReader

@Service
@Transactional
class SkillService {
	@Autowired
	lateinit var skillMapper: SkillMapper
	
	@Autowired
	lateinit var profileMapper: ProfileMapper
	
	fun addResult(skill: ArrayList<Skill>) {
		skillMapper.addResult(skill)
	}
	
	fun addResultOne(skill: Skill) {
		skillMapper.addResultOne(skill)
	}
	
	fun getSkill(userid: Int, musicid: Int, ptcode: Int): Skill {
		return skillMapper.getSkillOnePattern(userid, musicid, ptcode)
	}
	
	fun getSkill(userid: Int, musicid: Int): Map<String, Skill> {
		val skill = HashMap<String, Skill>()
		val list = skillMapper.getSkill(userid, musicid)
		for(i in 0..list.size-1) {
			skill.put("s"+list[i].patterncode.toString(), list[i])
		}
		return skill
	}
	
	fun getSkill(userid: Int,
				 gtype: String,
				 page: Int,
				 levels: ArrayList<Int>,
				 ranks: ArrayList<String>,
				 vers: ArrayList<Int>,
				 hot: String,
				 order: String): List<SkillTable> {
		return skillMapper.getSkillAll(userid, gtype, page, levels, ranks,
			vers, hot, order)
	}
	
	fun getSkillTop(version: Int, userid: Int, gtype: String): List<SkillTable> {
		return skillMapper.getSkillTop(version, userid, gtype)
	}
	
	fun getSkillTarget(version: Int, userid: Int, type: String, gtype: String): List<SkillTable> {
		return skillMapper.getSkillTarget(version, userid, type, gtype)
	}
	
	fun getSkillPattern(mid: Int, patterncode: Int, ver: Int): List<Pattern> {
		return skillMapper.getSkillPattern(mid, patterncode, ver)
	}
	
	fun getSkillPatternSelf(mid: Int, patterncode: Int, userid: Int): Pattern {
		return skillMapper.getSkillPatternSelf(mid, patterncode, userid)
	}
	
	fun getPlayCountGF(userid: Int): Int {
		var cnt = skillMapper.getPlayCountGF(userid)
		if(cnt == null) return 0
		else return cnt
	}
	
	fun getPlayCountDM(userid: Int): Int {
		var cnt = skillMapper.getPlayCountDM(userid)
		if(cnt == null) return 0
		else return cnt
	}
	
	fun getPatternCount(type: Int, uid: Int): Map<String, ArrayList<Int>> {
		val table = HashMap<String, ArrayList<Int>>()
		
		for(i in 0..6) {
			var rank:String = ""
			when(i) {
				0 -> rank = "EXC"
				1 -> rank = "SS"
				2 -> rank = "S"
				3 -> rank = "A"
				4 -> rank = "B"
				5 -> rank = "C"
				6 -> rank = "F"
			}
			
			val row = ArrayList<Int>()
			var key = 0
			for(j in 0..17) {
				when(j) {
					0 -> key = 100
					1 -> key = 150
					2 -> key = 200
					3 -> key = 250
					4 -> key = 300
					5 -> key = 350
					6 -> key = 400
					7 -> key = 450
					8 -> key = 500
					9 -> key = 550
					10 -> key = 600
					11 -> key = 650
					12 -> key = 700
					13 -> key = 750
					14 -> key = 800
					15 -> key = 850
					16 -> key = 900
					17 -> key = 950
				}
				if(type == 0)
					row.add(skillMapper.getPatternCountGF(uid, rank, key))
				else
					row.add(skillMapper.getPatternCountDM(uid, rank, key))
			}
			table.put(rank, row)
		}
		return table
	}
	
	fun getMybestPattern(userid: Int, type: Int): List<MostPlayedPattern> {
		val list = ArrayList<MostPlayedPattern>()
		when(type) {
			0 -> list.addAll(skillMapper.getMybestPattern(userid))
			1 -> list.addAll(skillMapper.getMybestPatternG(userid))
			2 -> list.addAll(skillMapper.getMybestPatternD(userid))
		}
		return list
	}
	
	fun getMybestMusic(userid: Int): List<MostPlayedMusic> {
		return skillMapper.getMybestMusic(userid)
	}
	
	fun updateTotalSkill(userid: Int, pattern: Int) {
		lateinit var hot: List<SkillTable>
		lateinit var other: List<SkillTable>
		
		if(pattern < 9) {
			hot = getSkillTarget(Const.INFOVER.CURRENT.value, userid, "h", "gf")
			other = getSkillTarget(Const.INFOVER.CURRENT.value, userid, "o", "gf")
		}
		else {
			hot = getSkillTarget(Const.INFOVER.CURRENT.value, userid, "h", "dm")
			other = getSkillTarget(Const.INFOVER.CURRENT.value, userid, "o", "dm")
		}
		
		var hskill = 0
		var oskill = 0
		
		for(i in 0..hot.size-1) {
			hskill += hot[i].level.toInt()*hot[i].rate*20/10000
		}
		for(i in 0..other.size-1) {
			oskill += other[i].level.toInt()*other[i].rate*20/10000
		}
		
		if(pattern < 9)
			profileMapper.updateManualSkill(userid, "gf", (hskill+oskill).toDouble())
		else
			profileMapper.updateManualSkill(userid, "dm", (hskill+oskill).toDouble())
	}
	
	fun addResultOld(skill: ArrayList<Skill>, gver: String) {
		skillMapper.addResultOld(skill, gver)
	}
	
	fun getEXCData(gtype: String, hot: String): List<SkillTable> {
		return skillMapper.getEXCData(gtype, hot)
	}
	
	fun reset(id: Int) {
		skillMapper.resetSkill(id)
	}
	
	fun getSkillTablePtype(ptype: Int, user: User, gtype: String, cpage: Int,
						   levels: ArrayList<Int>, ranks: ArrayList<String>,
						   vers: ArrayList<Int>, hotv: String, order: String)
	: Map<Int, ArrayList<SkillTable>> {
		val skillMap = HashMap<Int, ArrayList<SkillTable>>()
		val all = ArrayList<SkillTable>()
		val hot = ArrayList<SkillTable>()
		val other = ArrayList<SkillTable>()
		
		when(ptype) {
			0 -> all.addAll(getSkill(user.id, gtype, cpage, levels,
					ranks, vers, hotv, order))
			1 -> all.addAll(getSkillTarget(Const.INFOVER.CURRENT.value,
					user.id, hotv, gtype))
			2 -> {
				hot.addAll(getSkillTarget(Const.INFOVER.CURRENT.value,
					user.id, "h", gtype))
				other.addAll(getSkillTarget(Const.INFOVER.CURRENT.value,
					user.id, "o", gtype))
			}
			3 -> all.addAll(getSkillTop(Const.INFOVER.TBRE.value,
					user.id, gtype))
			4 -> all.addAll(getSkillTop(Const.INFOVER.TB.value,
					user.id, gtype))
			5 -> {
				hot.addAll(getSkillTarget(Const.INFOVER.TBRE.value,
					user.id, "h", gtype))
				other.addAll(getSkillTarget(Const.INFOVER.TBRE.value,
					user.id, "o", gtype))
			}
			6 -> {
				hot.addAll(getSkillTarget(Const.INFOVER.TB.value,
					user.id, "h", gtype))
				other.addAll(getSkillTarget(Const.INFOVER.TB.value,
					user.id, "o", gtype))
			}
			7 -> all.addAll(getSkillTop(Const.INFOVER.MX.value,
					user.id, gtype))
			8 -> {
				hot.addAll(getSkillTarget(Const.INFOVER.MX.value,
					user.id, "h", gtype))
				other.addAll(getSkillTarget(Const.INFOVER.MX.value,
					user.id, "o", gtype))
			}
		}
		skillMap.put(0, all)
		skillMap.put(1, hot)
		skillMap.put(2, other)
		
		return skillMap
	}
	
	fun createSnapshot(uid:Int, gtype:String, uname: String) {
		val hot = getSkillTarget(Const.INFOVER.CURRENT.value, uid, "h", gtype)
		val oth = getSkillTarget(Const.INFOVER.CURRENT.value, uid, "o", gtype)
		
		val json = JSONObject()
		
		val jsonhot = JSONArray()
		val jsonoth = JSONArray()
		
		for(i in 0..hot.size-1) {
			val cur = hot[i]
			val newobj = JSONObject()
			newobj.put("mid", cur.musicid)
			newobj.put("mname", cur.mname)
			newobj.put("ptcode", cur.patterncode)
			newobj.put("version", cur.version)
			newobj.put("lv", cur.level)
			newobj.put("rate", cur.rate)
			newobj.put("skill", Math.floor((cur.rate*cur.level*20/10000).toDouble())/100)
			newobj.put("rank", cur.rank)
			newobj.put("fc", cur.checkfc)
			newobj.put("meter", cur.meter)
			jsonhot.add(newobj)
		}
		
		for(i in 0..oth.size-1) {
			val cur = oth[i]
			val newobj = JSONObject()
			newobj.put("mid", cur.musicid)
			newobj.put("mname", cur.mname)
			newobj.put("ptcode", cur.patterncode)
			newobj.put("version", cur.version)
			newobj.put("lv", cur.level)
			newobj.put("rate", cur.rate)
			newobj.put("skill", Math.floor((cur.rate*cur.level*20/10000).toDouble())/100)
			newobj.put("rank", cur.rank)
			newobj.put("fc", cur.checkfc)
			newobj.put("meter", cur.meter)
			jsonoth.add(newobj)
		}
		
		val date = Date()
		val df = SimpleDateFormat("yyyyMMdd")
		json.put("uid", uid)
		json.put("uname", uname)
		json.put("date", df.format(date))
		json.put("type", gtype)
		json.put("hot", jsonhot)
		json.put("oth", jsonoth)
		
		// 파일저장
		val path = File("/data/snapshot/"+uid+"/")
		val file = File("/data/snapshot/"+uid+"/"+df.format(date)+"_"+gtype+".json")
	//	val path = File("f:/programming/web/gdinfo/snapshot/"+uid+"/")
	//	val file = File("f:/programming/web/gdinfo/snapshot/"+uid+"/"+df.format(date)+"_"+gtype+".json")
		
		path.mkdirs()
		if(file.exists()) file.delete()
		file.createNewFile()
		try {
			val fw = FileWriter(file)
			val bw = BufferedWriter(fw)
			bw.write(json.toJSONString())
			bw.close()
			fw.close()
		} catch(e: FileNotFoundException) {
			e.printStackTrace()
		} catch(e: IOException) {
			e.printStackTrace()
		}
	}

	fun listSnapshot(uid: Int): ArrayList<String> {
		val path = File("/data/snapshot/"+uid+"/")
	//	val path = File("f:/programming/web/gdinfo/snapshot/"+uid+"/")
		val list = ArrayList<String>()

		if(path.isDirectory()) {
			list.addAll(path.list())
		}
		return list
	}

	fun loadSnapshot(uid: Int, date: String, gtype: String): String {
		val file = File("/data/snapshot/"+uid+"/"+date+"_"+gtype+".json")
	//	val file = File("f:/programming/web/gdinfo/snapshot/"+uid+"/"+date+"_"+gtype+".json")

		var jsonstr: String = ""
		if(file.exists()) {
			try {
				val fr = FileReader(file)
				val br = BufferedReader(fr)
				for(s in br.readLines()) {
					jsonstr += s + '\n'
				}
				br.close()
				fr.close()
			} catch(e: FileNotFoundException) {
				e.printStackTrace()
			} catch(e: IOException) {
				e.printStackTrace()
			}
		}
		else {
			jsonstr = ""
		}

		return jsonstr
	}
}