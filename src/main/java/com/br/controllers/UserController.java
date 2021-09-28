package com.br.controllers;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.br.models.Deposito;
import com.br.models.User;
import com.br.services.DepositoService;
import com.br.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableWebMvc
@ControllerAdvice
public class UserController {

	@Qualifier("myImplementation")
	@Autowired
	UserService userService;
	
	@Autowired
	DepositoService depositoService;

	@RequestMapping(value = "/user", method=RequestMethod.GET)
	private List<User>getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/user/{id}", method=RequestMethod.GET)
	private ResponseEntity<User> getUser(@PathVariable("id") int id) {
		 Optional<User> usuario = Optional.ofNullable(userService.getUserById(id));
	        if(usuario.isPresent())
	            return new ResponseEntity<User>(usuario.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	private void deleteUser(@PathVariable("id") int id) {
		User user = new User();
		user = userService.getUserById(id);
		user.setDeposito(null);
		
		userService.delete(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	   public User Post( @RequestBody User user) {
		Deposito deposito = depositoService.getDepositoById(user.getDeposito().getId());
		
		user.setDeposito(deposito);
		
	        return userService.saveOrUpdate(user);
	   }

	
	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST) 
	private  ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User newUser) {
		Optional<User> oldUser = Optional.ofNullable(userService.getUserById(id));
        if(oldUser.isPresent()){
//        	int guardarPontos = (newUser.getPontos());
        	
//        	userService.delete(id);
        	
//        	newUser.setPontos(guardarPontos);
            userService.saveOrUpdate(newUser);
            return new ResponseEntity<User>(newUser, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/user/discount/{id}", method = RequestMethod.POST) 
	private  ResponseEntity<User> discountScore(@PathVariable(value = "id") int id,  @RequestBody float score) {
		Optional<User> user = Optional.ofNullable(userService.getUserById(id));
					
        if(user.isPresent()){
        	
        	User userScore = new User();
        	userScore = userService.getUserById(id);
        	
//        	int guardarPontos = (newUser.getPontos());
        	
//        	userService.delete(id);
        	
//        	newUser.setPontos(guardarPontos);
            userService.saveScore(userScore, score);
            return new ResponseEntity<User>(userScore, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
