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

import com.prunusnira.gitadorainfo.mapper.ProfileMapper
import com.prunusnira.gitadorainfo.model.CountRank
import com.prunusnira.gitadorainfo.model.RecentUser
import com.prunusnira.gitadorainfo.model.Rival
import com.prunusnira.gitadorainfo.model.SkillRecord
import com.prunusnira.gitadorainfo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Collections
import java.text.ParseException

@Service
@Transactional
class UserService {
	@Autowired
	lateinit var profileMapper: ProfileMapper
	
	fun addNewUser(token: String) {
		val user = User(token)
		profileMapper.addUser(user)
	}
	
	fun updateUser(user: User) {
		profileMapper.updateProfile(user)
	}
	
	fun updateOldSkill(userid: Int, gf: Double, dm: Double, gver: String) {
		profileMapper.updateOldSkill(userid, gf, dm, gver)
	}
	
	fun updateOpenCount(open: String, userid: Int) {
		profileMapper.updateOpenCount(open, userid)
	}
	
	fun updateComment(comment: String, userid: Int) {
		profileMapper.updateComment(comment, userid)
	}
	
	fun updatePlayCount(gf: Int, dm: Int, userid: Int) {
		profileMapper.updatePlayCount(gf, dm, userid)
	}
	
	fun getUserByToken(token: String): User {
		return profileMapper.getUserByToken(token)
	}
	
	fun getUserById(id: Int): User {
		return profileMapper.getUserById(id)
	}
	
	fun getAllUser(): List<User> {
		return profileMapper.getAllUser()
	}
	
	fun getUserSearch(stype: String, value: String): ArrayList<User> {
		val list = ArrayList<User>()
		when(stype) {
			"name" -> list.addAll(profileMapper.getUserSearchName(value))
			"gskill" -> list.addAll(profileMapper.getUserSearchGSkill(value.toDouble()))
			"dskill" -> list.addAll(profileMapper.getUserSearchDSkill(value.toDouble()))
		}
		return list
	}
	
	fun getPlayCountAll(): List<CountRank> {
		return profileMapper.getPlayCountAll()
	}
	
	fun getRecentUserList(): List<RecentUser> {
		val recentUser = profileMapper.getRecentUserList()
		for(i in 0..recentUser.size-1) {
			try {
				recentUser[i].uptimelong = recentUser[i].updatetime.time
			} catch(e:ParseException) {
				e.printStackTrace()
			}
		}
		return recentUser
	}
	
	fun addRival(myid: Int, id: Int, gtype: String) {
		profileMapper.addRival(myid, id, gtype)
	}
	
	fun getOneRival(myid: Int, id: Int, gtype: String): Rival {
		return profileMapper.getOneRival(myid, id, gtype)
	}
	
	fun getRival(myid: Int, gtype: String): List<RecentUser> {
		return profileMapper.getRivalList(myid, gtype)
	}
	
	fun delRival(myid: Int, id: Int, gtype: String) {
		profileMapper.delRival(myid, id, gtype)
	}
	
	fun reset(id: Int) {
		profileMapper.resetProfile(id)
	}
	
	fun updateSkillRecord(id: Int, gskill: Double, dskill: Double) {
		// Load file
		val dir = File("/data/userdata/")
		val recfile = File("/data/userdata/"+id+".dat")
		val content = ArrayList<SkillRecord>()
		dir.mkdirs()
		if(recfile.exists()) {
			try {
				val fr = FileReader(recfile)
				val br = BufferedReader(fr)
				var s:String?
				var eof = false
				while(!eof) {
					s = br.readLine()
					if(s != null) {
						val data = s.split("_")
						val record = SkillRecord(data[0], data[1], data[2])
						content.add(record)
					}
					else {
						eof = true
					}
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
			try {
				recfile.createNewFile()
			} catch(e: IOException) {
				e.printStackTrace()
			}
		}
		// Add content
		val df = SimpleDateFormat("yyyyMMdd")
		val d = Date()
		val time = df.format(d)
		if(content.size > 0) {
			if(content[content.size-1].date == time) {
				content.removeAt(content.size-1)
			}
			else if(content.size == 50) {
				content.removeAt(0)
			}
		}
		
		val record = SkillRecord(time, gskill.toString(), dskill.toString())
		content.add(record)
		// Save file
		try {
			val fw = FileWriter(recfile)
			val bw = BufferedWriter(fw)
			for(i in 0..content.size-1) {
				val c = content[i]
				bw.write(c.date+"_"+c.gskill+"_"+c.dskill)
				if(i != content.size-1) bw.write("\n")
			}
			bw.close()
			fw.close()
		} catch(e: IOException) {
			e.printStackTrace()
		}
	}
	
	fun getSkillRecord(userid: Int): ArrayList<SkillRecord> {
		val dir = File("/data/userdata/")
		val recfile = File("/data/userdata/"+userid+".dat")
		val content = ArrayList<SkillRecord>()
		dir.mkdirs()
		if(recfile.exists()) {
			try {
				val fr = FileReader(recfile)
				val br = BufferedReader(fr)
				var s:String?
				var eof = false
				while(!eof) {
					s = br.readLine()
					if(s != null) {
						val data = s.split("_")
						val record = SkillRecord(data[0], data[1], data[2])
						content.add(record)
					}
					else {
						eof = true
					}
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
			try {
				recfile.createNewFile()
			} catch(e: IOException) {
				e.printStackTrace()
			}
		}
		return content
	}
	
	fun getTowerTitle(userid: Int): String {
		return profileMapper.getTowerTitle(userid)
	}
	
	fun setTowerTitle(userid: Int, title: String) {
		profileMapper.setTowerTitle(userid, title)
	}
	
	fun skillRanking(gtype: String): List<User> {
		var userList = getAllUser()
		
		Collections.sort(userList, object: Comparator<User> {
			override fun compare(o1: User, o2: User): Int {
				if(gtype != "all") {
					var s1:Double = 0.0
					var s2:Double = 0.0
					if(gtype == "dm") {
						s1 = o1.dskill
						s2 = o2.dskill
					}
					else if(gtype == "gf") {
						s1 = o1.gskill
						s2 = o2.gskill
					}
					return s1.compareTo(s2)
				}
				else {
					val s1g = o1.gskill
					val s1d = o1.dskill
					val s2g = o2.gskill
					val s2d = o2.dskill
					return (s1g+s1d).compareTo(s2g+s2d)
				}
			}
		});
		Collections.reverse(userList)
		
		return userList
	}
}