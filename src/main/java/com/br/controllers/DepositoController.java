package com.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.br.models.Deposito;
import com.br.services.DepositoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableWebMvc
@ControllerAdvice
public class DepositoController {

	
	@Qualifier("myImplementation")
	@Autowired
	DepositoService repositoService;
	
	@RequestMapping(value = "/deposito", method=RequestMethod.GET)
	private List<Deposito>getAllUsers() {
		return repositoService.getAllDepositos();
	}
}
