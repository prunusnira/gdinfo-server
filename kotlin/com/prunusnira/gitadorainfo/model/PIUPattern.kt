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

@Alias("piuPattern")
class PIUPattern(var ptid: Int,
				 var musicid: Int,
				 var title_en: String,
				 var title_ko: String,
				 var artist: String,
				 var type: Int,
				 var lv: Int,
				 var difftype: Int,
				 // 서열표 내 위치 (0: 이하, 1: 하, 2: 중, 3: 상, 4: 이상, 5: ?)
				 var steptype: Int,
				 // 스텝 형태 (0: 보통, 1: 하프, 2: 퍼포)
				 var removed: Int) {
}