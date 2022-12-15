package com.prunusnira.gitadorainfo.mapper

import com.prunusnira.gitadorainfo.model.LvDiff
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BonusMapper {
    fun getLvDiffGF(): List<LvDiff>
    fun getLvDiffDM(): List<LvDiff>
}