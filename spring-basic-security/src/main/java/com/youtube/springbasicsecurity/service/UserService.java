package com.youtube.springbasicsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.youtube.springbasicsecurity.entity.User;
import com.youtube.springbasicsecurity.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	public User findByUsernameOrEmail(String username, String password) {
		return userRepository.findByUsernameOrEmail(username, password).get();
	}
}
