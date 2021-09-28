package com.br.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.br.models.LoginAdm;

@Service
@CrossOrigin(origins = "http://localhost:4200")
@Qualifier("myImplementation")
public class LoginAdmService {

	
	public LoginAdm getLogin(String login, String senha) {
		String loginAdm = "adm";
		String senhaAdm = "123";
		
		LoginAdm adm = null;
		if(login.equals(loginAdm) && senha.equals(senhaAdm))
			adm = new LoginAdm(loginAdm, null);
			return  adm;
	}
}
