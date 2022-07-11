package com.si.integrator.request;

import org.springframework.hateoas.mediatype.alps.Ext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




public class Request extends ResponseEntityExceptionHandler {
	


	public static ResponseEntity<String> postXml(String xmlString) {
	try {
		RestTemplate restTemplate =  new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);
	   ResponseEntity<String> response = restTemplate.postForEntity("https://pre-reinf.receita.economia.gov.br/recepcao/lotes", request, String.class);
	   return response; 
    }
    catch (RestClientException e) {
    		String message = e.getMessage();
    		if(message.contains("422")) {
    			 System.out.println("Lote não foi recebido pois possui inconsistências");
    			
    		}
    		//495 ou 496
    		if(message.contains("49")) {
   			 System.out.println("sem certificado");
 			
    		}
			if(message.contains("415")) {
			 System.out.println("media type não é 'application/xml', ou o conteúdo do body informado não é um Xml");
		
			}
			if(message.contains("500")) {
			 System.out.println(" Erro interno na EFD-REINF. No body é retornado um xml contendo um identificador do erro para acionamento");
		
			}
    	  	throw e;
    								}

	}
	
	
	 
	    
}
