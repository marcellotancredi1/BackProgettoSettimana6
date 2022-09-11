package com.epicode.gestionepostazioni.security.auths.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
	 @Autowired UserService userService;
	 @Autowired UserConfiguration userConfiguration;
	 @Override
	public void run(ApplicationArguments args) throws Exception {
		userService.createUser(userConfiguration.newUser());
	}
	 
	

}
