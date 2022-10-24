package com.gradation.lift.repository

import com.gradation.lift.data.entity.User
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: R2dbcRepository<User,String> {
    
}