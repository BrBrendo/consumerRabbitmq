package com.si.integrator.request;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongodb.client.result.UpdateResult;
import com.si.integrator.model.EvtInfoContri;
import com.si.integrator.model.Reinf;



public class Request extends ResponseEntityExceptionHandler{
	 @Autowired
	static MongoTemplate mongoTemplate;
	 @Autowired
	static
	 MongoOperations  mongoOperations;
	 
	public static ResponseEntity<String> postXml(String xmlString,String id)  {

		
		try {
	 RestTemplate restTemplate =  new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

	    final ResponseEntity<String> response = restTemplate.postForEntity("https://pre-reinf.receita.economia.gov.br/recepcao/lotes", request, String.class);
	    System.out.println(response);
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
   	        
   	        Query query = new Query();
   	     	query.addCriteria(Criteria.where("id").is("11"));
   	  		Update update = new Update();
   	  		update.set("resposta", "sem certificado");
   	  		mongoTemplate.updateFirst(query, update, EvtInfoContri.class);
    		
 			
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

	private static Query query(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Criteria where(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	    
}
