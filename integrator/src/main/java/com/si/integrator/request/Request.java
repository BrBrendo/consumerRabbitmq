package com.si.integrator.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;



public class Request {
	
	public static ResponseEntity<String> postXml(String xmlString) {
	 RestTemplate restTemplate =  new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

	    final ResponseEntity<String> response = restTemplate.postForEntity("https://reinf.receita.economia.gov.br/recepcao/lotes.svc?singleWsdl", request, String.class);
	    System.out.println(response);
		return response; 
	 }
	    
}
