package request;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class Request {
	
	public ResponseEntity<String> postXml() {
	 RestTemplate restTemplate =  new RestTemplate();
	 String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><AvailReq><hotelid>123</hotelid></AvailReq>";

	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

	    final ResponseEntity<String> response = restTemplate.postForEntity("https://reinf.receita.economia.gov.br/recepcao/lotes", request, String.class);
	    System.out.println(response);
		return response; 
	 }
	    
}
