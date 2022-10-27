package com.gradation.lift.service

import com.gradation.lift.data.dto.GetUserInfoRequestDto
import com.gradation.lift.data.dto.GetUserInfoResponseDto
import com.gradation.lift.data.mapper.UserMapper.getUserInfoMapper
import com.gradation.lift.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {


    override suspend fun getUserInfo(getUserInfoRequestDto: GetUserInfoRequestDto): GetUserInfoResponseDto? {
        return userRepository.findById(getUserInfoRequestDto.id)?.getUserInfoMapper()
    }


}