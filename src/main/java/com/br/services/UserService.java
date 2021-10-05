package com.br.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.customException.CustomException;
import com.br.models.User;
import com.br.repositorys.UserRepository;
import com.br.message.*;


@Service
@Qualifier("myImplementation")
public class UserService {

	Message message;
	
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
	
	public User update(User user) throws CustomException {
		Optional<User> userExist = Optional.empty();
		User newUserCpf = new User();
		
		userExist = userRepository.findById(user.getId());
		
		newUserCpf = userRepository.findByCpf(user.getCpf());
		
		
		if (userExist.get().getCpf().equals(user.getCpf()) || newUserCpf == null) {
			return userRepository.save(user);
			
		} else {
			throw new CustomException(Message.USUARIO_EXISTENTE.getMessage());
		}
	}
	
	public User save(User user) throws CustomException {
		User userExist = new User();
		userExist = userRepository.findByCpf(user.getCpf());
		if (userExist == null) {
			return userRepository.save(user);
			
		} else {
			throw new CustomException(Message.USUARIO_EXISTENTE.getMessage());
		}
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
