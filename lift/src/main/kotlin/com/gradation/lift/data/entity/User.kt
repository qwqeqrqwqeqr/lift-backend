package com.gradation.lift.data.entity

import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    @Id
    val id: String,
    val password: String,
    val name : String,
    val nick_name: String,
    val phone_number:String,
    val email:String,
    val birthday: DateTime,
    val authentication : String
)
