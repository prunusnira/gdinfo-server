package com.prunusnira.gitadorainfo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.prunusnira.gitadorainfo.service.NoticeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class NoticeController {
    @Autowired
    lateinit var noticeService: NoticeService

    @RequestMapping(value=["/notice/{page}"], produces=["text/plain;charset=UTF-8"])
    @ResponseBody
    fun getNotice(@PathVariable("page") page: Int): String {
        val mapper = ObjectMapper()
        val node = mapper.createObjectNode()
        if(page > 0) {
            val data = noticeService.getNotice((page - 1) * 10)
            node.putPOJO("notice", mapper.writeValueAsString(data))
        }
        else {
            val data = noticeService.getTopNotice()
            node.putPOJO("notice", mapper.writeValueAsString(data))
        }
        return node.toString()
    }
}