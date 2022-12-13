package com.prunusnira.gitadorainfo.model

import org.apache.ibatis.type.Alias
import java.sql.Timestamp

@Alias("notice")
class Notice(
        var id: Int,
        var titleK: String,
        var titleJ: String,
        var titleE: String,
        var contentK: String,
        var contentJ: String,
        var contentE: String,
        var time: Timestamp
) {}