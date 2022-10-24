package com.gradation.lift.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class BaseController {

    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    suspend fun test():String{
        return "init"
    }
}