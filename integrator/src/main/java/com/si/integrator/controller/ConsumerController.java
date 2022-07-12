package com.si.integrator.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.integrator.convert.Convert;
import com.si.integrator.request.Request;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
		
	
		@GetMapping
		public String hello() {
			return "olá,mundo";
			
		}
		
		@PostMapping(value = "/override", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
		public  ResponseEntity<String>post(@RequestBody String json) throws Exception {
	
		 
		    String xml = Convert.jsonToXml(json);
		    //recuperar ID
		  	JSONObject obj = new JSONObject(json);
			String id = obj.getJSONObject("evtInfoContri").getString("id");
			
		      ResponseEntity<String> response = Request.postXml(xml,id);
			return  response;
			
		}
}
