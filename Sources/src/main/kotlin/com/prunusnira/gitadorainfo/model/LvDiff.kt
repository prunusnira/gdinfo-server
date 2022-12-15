package com.prunusnira.gitadorainfo.model

import org.apache.ibatis.type.Alias

@Alias("lvdiff")
class LvDiff(
    var mid: Int,
    var title: String,
    var ptcode: Long,
    var lv: Int,
    var lvold: Int,
) {}