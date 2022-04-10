package com.ges_school.scolaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.ges_school.scolaire.ClassesRepository.java")
 @ComponentScan(basePackages = {"com.ges_school.scolaire.*" })
 @EntityScan("com.ges_school.scolaire.Classes.java")

@SpringBootApplication
public class ScolaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScolaireApplication.class, args);
	}

}
