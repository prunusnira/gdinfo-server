package com.prunusnira.gitadorainfo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class NoticeController {
    @RequestMapping(value=["/topnotice"], produces=["text/plain;charset=UTF-8"])
    @ResponseBody
    fun getTopNotice(): String {
        return ""
    }

    @RequestMapping(value=["/notice/{page}"], produces=["text/plain;charset=UTF-8"])
    @ResponseBody
    fun getNotice(@PathVariable("page") page: Int): String {
        return ""
    }
}