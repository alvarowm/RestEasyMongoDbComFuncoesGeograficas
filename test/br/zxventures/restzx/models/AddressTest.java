package br.zxventures.restzx.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {
	
	private final int NUMERO_DE_CAMPOS = 2; 
	
	@Test
	public void checarMudancaNoModelTest() {
		assertEquals(Address.class.getDeclaredFields().length,NUMERO_DE_CAMPOS);
	}
	

}
