package com.br.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.br.models.Produto;
import com.br.services.ProdutoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableWebMvc
@ControllerAdvice
public class ProdutoController {
	
	@Qualifier("myImplementation")
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(value = "/product", method=RequestMethod.GET)
	private List<Produto>getProducts() {
		return produtoService.getAllProducts();
	}
	
	@RequestMapping(value = "/product/{id}", method=RequestMethod.GET)
	private ResponseEntity<Produto> getProduct(@PathVariable("id") int id) {
		 Optional<Produto> produto = Optional.ofNullable(produtoService.getProdutoById(id));
	        if(produto.isPresent())
	            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
	private void deleteProduct(@PathVariable("id") int id) {
		
		produtoService.delete(id);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	   public ResponseEntity<Produto> Post( @RequestBody @Valid Produto produto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	    produtoService.saveOrUpdate(produto);
	    return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	   }
	
	@RequestMapping(value = "/product/update/{id}", method = RequestMethod.POST) 
	private  ResponseEntity<Produto> updateProduct(@PathVariable(value = "id") int id, @RequestBody Produto newProduct) {
		Optional<Produto> oldProduct = Optional.ofNullable(produtoService.getProdutoById(id));
        if(oldProduct.isPresent()){

        	produtoService.saveOrUpdate(newProduct);
            return new ResponseEntity<Produto>(newProduct, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
