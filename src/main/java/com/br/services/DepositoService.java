package com.br.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.models.Deposito;
import com.br.models.User;
import com.br.repositorys.DepositoRepository;


@Service
@Qualifier("myImplementation")
public class DepositoService {

	@Autowired
	DepositoRepository depositoRepository;
	
	public List<Deposito> getAllDepositos() {
		List<Deposito> depositos = new ArrayList<Deposito>();
		depositoRepository.findAll().forEach(user -> depositos.add(user));
		return depositos;
	}
}
