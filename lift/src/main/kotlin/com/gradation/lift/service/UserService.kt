package com.gradation.lift.service

import com.gradation.lift.data.dto.GetUserInfoRequestDto
import com.gradation.lift.data.dto.GetUserInfoResponseDto
import kotlinx.coroutines.flow.Flow

interface UserService {


    suspend fun getUserInfo(getUserInfoRequestDto: GetUserInfoRequestDto): GetUserInfoResponseDto?



}