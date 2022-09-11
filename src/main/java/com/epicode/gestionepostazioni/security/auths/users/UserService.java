package com.epicode.gestionepostazioni.security.auths.users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired UserRepository userRepository;
	
	public List<UserResponse> getAllUsersBasicInformations() {
		return userRepository.findAll()
				.stream()
				.map( user ->  UserResponse
								.builder()
								.userName(  user.getUsername()  )
								.role( user.getRoles().stream().findFirst().get().getRoleName().name() )
								.build()   
				).collect(Collectors.toList());
	}
	
	public UserResponse getUserBasicInformations(String userName) {
		User user = userRepository.findByUsername(userName).get();
		
		
		
		return UserResponse
		.builder()
		.userName(userName)
		.role( user.getRoles().stream().findFirst().get().getRoleName().name()).build();
		
	}
	
	public User createUser(User u) {
		return userRepository.save(u);	
	}
	
	public User readUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	public void deleteUser(Long u) {
		userRepository.deleteById(u);
	}
	
}
