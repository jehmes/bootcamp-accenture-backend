package com.br.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.br.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
