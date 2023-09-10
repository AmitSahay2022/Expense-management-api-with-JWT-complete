package com.youtube.springbasicsecurity.config;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.youtube.springbasicsecurity.entity.User;
import com.youtube.springbasicsecurity.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameOrEmail(username, username).get();
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
}
