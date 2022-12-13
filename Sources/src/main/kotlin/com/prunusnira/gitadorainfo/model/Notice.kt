package com.prunusnira.gitadorainfo.model

import org.apache.ibatis.type.Alias

@Alias("Notice")
class Notice(
        var id: Int,
        var nameK: String,
        var nameE: String,
        var nameJ: String,
        var date: String,
        var contentK: String,
        var contentE: String,
        var contentJ: String,
) {}