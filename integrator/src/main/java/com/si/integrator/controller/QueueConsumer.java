package com.si.integrator.controller;
import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.si.integrator.convert.Convert;
import com.si.integrator.request.Request;


@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) throws IOException {
        System.out.println("Message " + fileBody);

	      String xml = Convert.jsonToXml(fileBody);
	      ResponseEntity<String> response = Request.postXml(xml);
    }

}
