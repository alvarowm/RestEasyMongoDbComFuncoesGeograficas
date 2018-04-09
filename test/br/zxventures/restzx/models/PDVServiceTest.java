package br.zxventures.restzx.models;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class PDVServiceTest implements IPDVServiceTest{

	private static final String HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_46_57421_21_785741 = "http://localhost:8080/ZXVenturesDesafio/api/pdv/-46.57421,-21.785741";
	private static final String HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_POST = "http://localhost:8080/ZXVenturesDesafio/api/post";
	private static final String HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_1 = "http://localhost:8080/ZXVenturesDesafio/api/pdv/1";

	@Test
	public void testGetByIdOK() {
		HttpUriRequest request = new HttpGet(HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_1);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		} catch (Exception e) {
			assertFalse(true);
		} 
	}

	@Test
	public void testGetById() {
		HttpUriRequest request = new HttpGet( HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_1);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json_string = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json_string, GET_BY_ID_JSON);

		} catch (Exception e) {
			assertFalse(true);
		} 
	}

	@Test
	public void testPostPDVOK() {
		HttpUriRequest request = new HttpGet(HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_POST);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		} catch (Exception e) {
			assertFalse(true);
		} 
	}

	@Test
	public void testGetByLgnLat() {
		HttpUriRequest request = new HttpGet(HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_46_57421_21_785741);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json_string = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json_string, GET_BY_LGN_LAT_JSON);

		} catch (Exception e) {
			assertFalse(true);
		} 
	}

	@Test
	public void testGetByLgnLatOK() {
		HttpUriRequest request = new HttpGet(HTTP_LOCALHOST_8080_ZX_VENTURES_DESAFIO_API_PDV_46_57421_21_785741);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		} catch (Exception e) {
			assertFalse(true);
		} 
	}

}
