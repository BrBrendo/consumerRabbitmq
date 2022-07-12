package com.si.integrator.request;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.Document;

import com.mongodb.client.result.UpdateResult;
import com.si.integrator.model.EvtInfoContri;
import com.si.integrator.model.Reinf;



public class Request extends ResponseEntityExceptionHandler{
	
	 private static String resposta;
	 @Autowired
		private static MongoTemplate mongoTemplate;
		@Autowired
	    public void setMongoTemplate(MongoTemplate mongoTemplate) {
	        Request.mongoTemplate = mongoTemplate;
	    }
	public static ResponseEntity<String> postXml(String xmlString,String id)  {

		
		try {
	 RestTemplate restTemplate =  new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_XML);
	    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

	    final ResponseEntity<String> response = restTemplate.postForEntity("https://pre-reinf.receita.economia.gov.br/recepcao/lotes", request, String.class);
	    System.out.println(response);
	  ///salva resposta
	    saveResposta(response.getBody(),id);
	    return response; 
   
		}
    
		
		catch (RestClientException e) {
    		String message = e.getMessage();
    		if(message.contains("422")) {
    		resposta = "Lote não foi recebido pois possui inconsistências";
    			
    		}
    		//495 ou 496
    		if(message.contains("49")) {
    			resposta ="sem certificado";
   	 	
 			
    		}
			if(message.contains("415")) {
				resposta = "media type não é 'application/xml', ou o conteúdo do body informado não é um Xml";
		
			}
			if(message.contains("500")) {
				resposta = " Erro interno na EFD-REINF. No body é retornado um xml contendo um identificador do erro para acionamento";
		
			}
			///salva resposta de erro na tabela
			saveResposta(resposta,id);
    	  	throw e;
    								}

	}
	
	private static  void saveResposta(String resposta,String id){
	    Query query = new Query();
   	    query.addCriteria(Criteria.where("evtInfoContri.id").is(id));
   	  	Update update = new Update();
   	  	update.set("evtInfoContri.resposta", resposta);
		mongoTemplate.updateFirst(query, update, EvtInfoContri.class);
	}
	    
}
