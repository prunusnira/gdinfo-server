package com.prunusnira.gitadorainfo.service

import com.prunusnira.gitadorainfo.mapper.BonusMapper
import com.prunusnira.gitadorainfo.model.LvDiff
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BonusService {
    @Autowired
    lateinit var bonusMapper: BonusMapper

    fun getLevelDiff(type: String): List<LvDiff> {
        return if(type == "gf") {
            bonusMapper.getLvDiffGF()
        } else {
            bonusMapper.getLvDiffDM()
        }
    }
}