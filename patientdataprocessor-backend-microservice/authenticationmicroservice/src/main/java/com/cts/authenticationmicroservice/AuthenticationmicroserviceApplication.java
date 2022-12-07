package com.cts.authenticationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@OpenAPIDefinition(
		  info =@Info(
		    title = "Patient Data Processor API",
		    version = "${api.version}",
		    description = "Swagger UI For Patient Data Processor"
//		    contact = @Contact(
//		      name = "thunderbolts", email = "thunderbolts.com", url = "https://github"
//		    ),
//		    license = @License(
//		      name = "thunderbolts", url = "https://"
//		    ),
//		    termsOfService = "${tos.uri}",
//		    description = "${api.description}"
//		  ),
//		  servers = @Server(
//		    url = "${api.server.url}",
//		    description = "Production"
		  )
		)
@SecurityScheme(
		  name = "Bearer Authentication",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer"
		)
public class AuthenticationmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationmicroserviceApplication.class, args);
	}

}
