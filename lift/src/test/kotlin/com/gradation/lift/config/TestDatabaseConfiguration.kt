package com.gradation.lift.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import java.time.Duration

@Configuration
class TestDatabaseConfiguration(
) : AbstractR2dbcConfiguration() {

    @Value("\${spring.r2dbc.url}")
    lateinit var url: String

    @Value("\${spring.r2dbc.username}")
    lateinit var user: String

    @Value("\${spring.r2dbc.password}")
    lateinit var password: String

    @Bean
    override fun connectionFactory(): ConnectionFactory = ConnectionFactories.get(
        builder()
            .option(DRIVER, "mysql")
            .option(HOST, parse(url).getValue(HOST) as String)
            .option(USER, user)
            .option(PORT, parse(url).getValue(PORT) as Int)  // optional, default 3306
            .option(PASSWORD, password) // optional, default null, null means has no password
            .option(
                DATABASE,
                parse(url).getValue(DATABASE) as String
            ) // optional, default null, null means not specifying the database
            .option(CONNECT_TIMEOUT, Duration.ofSeconds(10)) // optional, default null, null means no timeout
            .build()
    )
}