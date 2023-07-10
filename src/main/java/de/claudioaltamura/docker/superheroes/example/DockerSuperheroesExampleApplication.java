package de.claudioaltamura.docker.superheroes.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DockerSuperheroesExampleApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello World from superheroes-v2!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerSuperheroesExampleApplication.class, args);
	}

}
