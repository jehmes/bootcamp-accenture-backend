package com.br.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

//	User findByCpfSenha(String cpf, String senha);
	@Query(value = "SELECT * FROM user WHERE cpf = ?1 AND senha = ?2", nativeQuery = true)
	  User findByCpfSenha(String cpf, String senha);
}
