package com.br.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.br.models.LoginUser;
import com.br.models.User;
import com.br.services.LoginUserService;
import com.br.services.UserService;

@CrossOrigin
@RestController
@EnableWebMvc
@ControllerAdvice
public class LoginUserController {

	@Qualifier("myImplementation")
	@Autowired
	LoginUserService loginService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	private ResponseEntity<User> getLogin(@RequestBody @Valid LoginUser login) {
//		Login loginTeste = new Login();
		
		User user = new User();

		user = userService.getByCpfSenha(login.getLogin(), login.getSenha());
		
		
		if (!user.equals(null)) {

			
//			loginTeste.setId(user.getId());
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
}
