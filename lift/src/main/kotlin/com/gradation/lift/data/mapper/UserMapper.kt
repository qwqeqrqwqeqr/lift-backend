package com.gradation.lift.data.mapper

import com.gradation.lift.data.dto.GetUserInfoResponseDto
import com.gradation.lift.data.entity.User

object UserMapper {

    fun User.getUserInfoMapper(): GetUserInfoResponseDto =
        GetUserInfoResponseDto(name = name, nickName = nick_name, phoneNumber = phone_number, email = email, birthday = birthday)



}