package com.pl.vkorol.search.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("base-service")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun customOpenAPI(
        @Value("\${application-description}") appDescription: String?, @Value(
            "\${application-version}"
        ) appVersion: String?
    ): OpenAPI {
        val contact = Contact()
        return OpenAPI()
            .info(
                Info()
                    .title("Microservice Base Service Application API")
                    .version(appVersion)
                    .description(appDescription)
                    .termsOfService("http://swagger.io/terms/")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(contact)
            )
    }

}
