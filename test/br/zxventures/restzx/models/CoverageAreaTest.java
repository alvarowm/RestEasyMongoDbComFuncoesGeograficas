package br.zxventures.restzx.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoverageAreaTest {
	
private final int NUMERO_DE_CAMPOS = 2; 
	
	@Test
	public void checarMudancaNoModelTest() {
		assertEquals(CoverageArea.class.getDeclaredFields().length,NUMERO_DE_CAMPOS);
	}

}
