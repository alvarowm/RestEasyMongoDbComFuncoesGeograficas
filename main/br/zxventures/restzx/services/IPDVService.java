package br.zxventures.restzx.services;

public interface IPDVService {
	
	String QUERY_NEAR =  
			"	{ \"address\": \r\n" + 
			"		{ $nearSphere: \r\n" + 
			"			{ $geometry: \r\n" + 
			"				{ type: \"Point\", coordinates: [ %s,%s ] }\r\n" + 
			"			} \r\n" + 
			"		} \r\n" + 
			"	}\r\n";
	
	String QUERY_INTERSECTS = "{\r\n" + 
			"    \"coverageArea\": {\r\n" + 
			"        \"$geoIntersects\": {\r\n" + 
			"             \"$geometry\": {\r\n" + 
			"                 \"type\": \"Point\",\r\n" + 
			"             \"coordinates\": "
			+ "[\r\n %s,%s\r\n]\r\n" + 
			"             }\r\n" + 
			"         }\r\n" + 
			"    }\r\n" + 
			"}";	
	
	String PDV_CADASTRADO = "PDV j� cadastrado!";
	String PDV_INSERIDO = "PDV inserido com sucesso!";
	String PDV_NAO_ENCONTRADO = "N�o h� PDV v�lido!";
	String JSON_INVALIDO = "JSON Inv�lido!";
	String PDV_NAO_ESTA_PROXIMO = "N�o h� um PDV pr�ximo �s coordenadas informadas!";

}
