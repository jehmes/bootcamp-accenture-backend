package com.br.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.models.User;
import com.br.repositorys.UserRepository;


@Service
@Qualifier("myImplementation")
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public User getByCpfSenha(String cpf, String senha) {
		return userRepository.findByCpfSenha(cpf, senha);
	}
	
	public User saveOrUpdate(User user) {
		return userRepository.save(user);
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	public User saveScore(User user, float score) {
		float oldScore = user.getPontos();
		float newScore = oldScore - score;
    	
    	user.setPontos(newScore);
		return userRepository.save(user);
	}
	
}
