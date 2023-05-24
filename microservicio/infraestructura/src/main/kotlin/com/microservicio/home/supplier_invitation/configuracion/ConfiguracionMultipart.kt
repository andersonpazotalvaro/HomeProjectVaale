package com.microservicio.home.supplier_invitation.configuracion

import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.unit.DataSize
import org.springframework.web.multipart.commons.CommonsMultipartResolver
import javax.servlet.MultipartConfigElement
@Configuration
open class ConfiguracionMultipart {
    @Bean(name = ["multipartResolver"])
    open fun getResolver(): CommonsMultipartResolver {
        val resolver = CommonsMultipartResolver()
        resolver.setMaxUploadSize(35242880) // 0.5MB
        return resolver
    }

    @Bean
    open fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        factory.setMaxFileSize(DataSize.ofMegabytes(200L))
        factory.setMaxRequestSize(DataSize.ofMegabytes(200L))
        return factory.createMultipartConfig()
    }
}