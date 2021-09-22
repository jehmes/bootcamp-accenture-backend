package com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.models.User;
import com.br.repositorys.UserRepository;

@Service
@Qualifier("myImplementation")
public class LoginUserService {

	@Autowired
	UserRepository userRepository;
	
//	public User getLogin(String login, String senha) {
//		return userRepository.findById(id).get();
//	}
}
