package com.prunusnira.gitadorainfo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.prunusnira.gitadorainfo.service.BonusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BonusController {
    @Autowired
    lateinit var bonusService: BonusService

    @RequestMapping("/lvdiff/{type}")
    @ResponseBody
    fun lvdiff(@PathVariable("type") type: String): String {
        val mapper = ObjectMapper()
        val node = mapper.createObjectNode()

        val data = bonusService.getLevelDiff(type)
        node.putPOJO("lvdiff", data)
        return node.toString()
    }
}