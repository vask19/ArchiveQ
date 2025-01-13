//package com.pl.vkorol.search.config
//
//import io.swagger.v3.oas.models.info.Info
//import org.springdoc.core.models.GroupedOpenApi
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class SwaggerConfig {
//
//    @Bean
//    fun publicApi(): GroupedOpenApi {
//        return GroupedOpenApi.builder()
//            .group("public")
//            .pathsToMatch("/api/**")
//            .build()
//    }
//
//    @Bean
//    fun openAPI(): io.swagger.v3.oas.models.OpenAPI {
//        return io.swagger.v3.oas.models.OpenAPI()
//            .info(
//                Info()
//                    .title("Document API")
//                    .description("API documentation for managing documents")
//                    .version("1.0.0")
//            )
//    }
//}
