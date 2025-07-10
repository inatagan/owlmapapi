package io.inatagan.owlmap_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.inatagan.owlmap_api.entity.User;
import io.inatagan.owlmap_api.service.UserService;

@SpringBootApplication
public class OwlmapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwlmapApiApplication.class, args);

		// @Autowired
		// private UserService userService
		// for (int i = 0; i < 100; i++) {
		// 	userService.save(
		// 			User.builder()
		// 					.name("Jane Doe 00" + i)
		// 					.email("jDoe@mail.com" + i)
		// 					.password("securePassword123")
		// 					.build());
		// }
		
	}

}
