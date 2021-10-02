package com.br.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.br.models.LoginAdm;
import com.br.services.LoginAdmService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableWebMvc
@ControllerAdvice
public class LoginAdmController {

	@Autowired
	LoginAdmService loginAdmService;
	
	@RequestMapping(value = "/login-adm", method=RequestMethod.POST)
	private ResponseEntity<LoginAdm> getLogin(@RequestBody @Valid LoginAdm login) {
//		Login loginTeste = new Login();
		
		LoginAdm adm = new LoginAdm();

		adm = loginAdmService.getLogin(login.getEmail(), login.getSenha());
		
		
		if (!adm.equals(null)) {

			
//			loginTeste.setId(user.getId());
			
			return new ResponseEntity<LoginAdm>(login, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
