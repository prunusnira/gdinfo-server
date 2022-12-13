package com.prunusnira.gitadorainfo.mapper

import com.prunusnira.gitadorainfo.model.Notice
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface NoticeMapper {
    fun getTopNotice(): List<Notice>

    fun getNotice(@Param("page") page: Int): List<Notice>
}