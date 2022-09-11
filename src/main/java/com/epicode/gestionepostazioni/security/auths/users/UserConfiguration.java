package com.epicode.gestionepostazioni.security.auths.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
	@Bean("user1")
	public User newUser() {
		return new User("username", "password", "fullname", "email");
	}
	
}
