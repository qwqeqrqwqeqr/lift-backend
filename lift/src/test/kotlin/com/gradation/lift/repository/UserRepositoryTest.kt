package com.gradation.lift.repository

import com.gradation.lift.config.TestDatabaseConfiguration
import io.kotest.core.spec.style.FunSpec
import jdk.internal.vm.vector.VectorSupport.test
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [UserRepository::class, TestDatabaseConfiguration::class])
class EmployeeRepositoryTest(userRepository: UserRepository) : FunSpec({

    extension(SpringExtension)

    test("직원을 저장할 수 있다.") {
        val employee = userRepository(name = "test")
        val saved = employeeRepo.save(employee)

        saved.name shouldBe employee.name
    }
})
