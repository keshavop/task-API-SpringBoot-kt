package com.example.taskapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/health")
class HealthCheckController {
    @GetMapping("")
    fun getHealth():String{
        return "API is running fine"
    }
}