package com.prunusnira.gitadorainfo.service

import com.prunusnira.gitadorainfo.mapper.NoticeMapper
import com.prunusnira.gitadorainfo.model.Notice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class NoticeService {
    @Autowired
    lateinit var mapper: NoticeMapper

    fun getTopNotice(): List<Notice> {
        return mapper.getTopNotice()
    }

    fun getNotice(page: Int): List<Notice> {
        return mapper.getNotice(page)
    }
}