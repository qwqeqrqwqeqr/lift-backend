package com.gradation.lift.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import java.time.Duration

@Configuration
class DatabaseConfiguration(
) : AbstractR2dbcConfiguration() {

    @Value("\${spring.r2dbc.url}")
    lateinit var url: String

    @Value("\${spring.r2dbc.username}")
    lateinit var user: String

    @Value("\${spring.r2dbc.password}")
    lateinit var password: String

    @Bean
    override fun connectionFactory(): ConnectionFactory = ConnectionFactories.get(
        ConnectionFactoryOptions.builder()
            .option(ConnectionFactoryOptions.DRIVER, "mysql")
            .option(
                ConnectionFactoryOptions.HOST, ConnectionFactoryOptions.parse(url)
                    .getValue(ConnectionFactoryOptions.HOST) as String
            )
            .option(ConnectionFactoryOptions.USER, user)
            .option(
                ConnectionFactoryOptions.PORT, ConnectionFactoryOptions.parse(url)
                    .getValue(ConnectionFactoryOptions.PORT) as Int
            )  // optional, default 3306
            .option(ConnectionFactoryOptions.PASSWORD, password) // optional, default null, null means has no password
            .option(
                ConnectionFactoryOptions.DATABASE,
                ConnectionFactoryOptions.parse(url).getValue(ConnectionFactoryOptions.DATABASE) as String
            ) // optional, default null, null means not specifying the database
            .option(
                ConnectionFactoryOptions.CONNECT_TIMEOUT,
                Duration.ofSeconds(10)
            ) // optional, default null, null means no timeout
            .build()
    )
}