package com.gradation.lift.controller

import com.gradation.lift.data.dto.GetUserInfoRequestDto
import com.gradation.lift.data.dto.GetUserInfoResponseDto
import com.gradation.lift.data.model.Result
import com.gradation.lift.data.model.ResultCode
import com.gradation.lift.data.model.Status
import com.gradation.lift.data.model.resultCodeMapper
import com.gradation.lift.data.model.statusMapper
import com.gradation.lift.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(description = "Patient API")
@RequestMapping("/user")
@RestController
class UserController(private val userService: UserService) {


    @GetMapping("/info")
    suspend fun getPatientInfo(getUserInfoRequestDto: GetUserInfoRequestDto): Result<GetUserInfoResponseDto> {
        userService.getUserInfo(getUserInfoRequestDto)?.let {
            return Result(
                statusMapper(Status.SUCCESS),
                resultCodeMapper(ResultCode.OK),
                "회원의 정보를 불러옵니다.",
                it
            )
        }
        return Result(statusMapper(Status.FAIL), resultCodeMapper(ResultCode.BAD_REQUEST), "유저의 정보가 존재하지 않습니다.", null)
        
    }
}

