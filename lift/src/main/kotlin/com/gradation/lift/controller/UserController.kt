package com.gradation.lift.controller

import com.gradation.lift.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(description = "Patient API")
@RequestMapping("/api/patient")
@RestController
class UserController(userService: UserService) {
    
    
}

