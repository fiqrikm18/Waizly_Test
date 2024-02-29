package com.fiqrikm18.implemetation_test_1;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@SecurityScheme(name = "Simple CRUD API", scheme = "jwt", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class ImplemetationTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(ImplemetationTest1Application.class, args);
	}

}
