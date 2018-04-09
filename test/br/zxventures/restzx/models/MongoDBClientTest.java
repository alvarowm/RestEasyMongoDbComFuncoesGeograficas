package br.zxventures.restzx.models;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.zxventures.restzx.mongoclient.MongoDBClient;

public class MongoDBClientTest {
	
	@Test
	public void testChecarSeInstanciaEstaCorreta() {
		assertFalse(MongoDBClient.getInstance() == null);
	}
	
	@Test
	public void testChecarAtributosDaInstancia() {
		MongoDBClient client = MongoDBClient.getInstance();
		assertFalse(client.getDataBase() == null);
	}

}
