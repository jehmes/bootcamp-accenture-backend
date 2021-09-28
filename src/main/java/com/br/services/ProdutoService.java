package com.br.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.br.models.Produto;
import com.br.repositorys.ProdutoRepository;

@Service
@Qualifier("myImplementation")
public class ProdutoService {
	

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProducts() {
		List<Produto> products = new ArrayList<Produto>();
		produtoRepository.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	public Produto getProdutoById(int id) {
		return produtoRepository.findById(id).get();
	}
	
	public Produto saveOrUpdate(Produto product) {
		float preco = product.getPreco();	
		product.setPrecoTotal(preco);
		
		return produtoRepository.save(product);
	}
	
	public void delete(int id) {
		produtoRepository.deleteById(id);
	}
	
	
}
