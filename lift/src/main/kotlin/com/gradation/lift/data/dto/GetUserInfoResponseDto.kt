package com.gradation.lift.data.dto

import kotlinx.coroutines.flow.Flow
import org.joda.time.DateTime

data class GetUserInfoResponseDto(
    val name : String,
    val nickName: String,
    val phoneNumber:String,
    val email:String,
    val birthday: DateTime
)
