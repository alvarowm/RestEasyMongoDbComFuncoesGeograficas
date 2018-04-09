package br.zxventures.restzx.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PDVTest {
	
	private final int NUMERO_DE_CAMPOS = 6;
	
	@Test
	public void checarMudancaNoModelTest() {
		assertEquals(PDV.class.getDeclaredFields().length,NUMERO_DE_CAMPOS);
	}

}
