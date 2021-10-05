package com.example.demo;

import org.junit.jupiter.api.Test;
import junit.framework.Assert;

import com.br.models.Deposito;
import com.br.models.EnderecoUser;
import com.br.models.User;

@SuppressWarnings("deprecation")
class AppTest {
	// User Details
	public static final String EXPECTED_USER_NAME = "Alexandre";
	public static final String EXPECTED_CPF = "13667757590";
	public static final String EXPECTED_SENHA = "123456";
	public static final String EXPECTED_CONTATO = "81999999999";
	public static final String EXPECTED_EMAIL = "exemplo@exemplo.com";
	
	// Deposito Details
	public static final String EXPECTED_DEP_NAME = "Palha de Arroz";
	public static final String EXPECTED_DEP_URL = "www.palhadearroz.com";
	
	
	private User user;
    private Deposito deposito;
    
    public void setUp() throws Exception {
    	deposito = new Deposito();
    	deposito.setNome("Palha de Arroz");
    	deposito.setUrl("www.palhadearroz.com");
    	
    	
    	user = new User();
		user.setNome("Alexandre");
		user.setCpf("13667757590");
		user.setSenha("123456");
		user.setContato("81999999999");
		user.setEmail("exemplo@exemplo.com");
    }

	@Test
    public void testUserDetails() throws Exception {
		setUp();
        Assert.assertEquals(EXPECTED_USER_NAME, user.getNome());
        Assert.assertEquals(EXPECTED_CPF, user.getCpf());
        Assert.assertEquals(EXPECTED_SENHA, user.getSenha());
        Assert.assertEquals(EXPECTED_CONTATO, user.getContato());
        Assert.assertEquals(EXPECTED_EMAIL, user.getEmail());

    }
	@Test
	public void testDepostioDetails() throws Exception {
		setUp();
		Assert.assertEquals(EXPECTED_DEP_NAME, deposito.getNome());
		Assert.assertEquals(EXPECTED_DEP_URL, deposito.getUrl());
	}

}