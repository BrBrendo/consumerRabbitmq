package com.si.integrator.controller;


import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.si.integrator.convert.Convert;
import com.si.integrator.request.Request;


@Component
public class QueueConsumer {

	    public void receive(@Payload String fileBody) throws Exception {
	        System.out.println("Message " + fileBody);
	        

		      String xml = Convert.jsonToXml(fileBody);
		    //recuperar ID
		  	JSONObject obj = new JSONObject(fileBody);
			String id = obj.getJSONObject("evtInfoContri").getString("id");
		      Request.postXml(xml,id);
	    }
}
