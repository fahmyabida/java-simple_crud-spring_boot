package com.example.sk_uiiPersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //automatically get populated whenever create or update createdAt and updatedAt fields with @CreatedDate and @LastModifiedDate annotations an entity 
public class SkUiiPersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkUiiPersonalApplication.class, args);
	}
}
