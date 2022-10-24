package com.gradation.lift.repository

import com.gradation.lift.data.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository  : CoroutineCrudRepository<User,String>