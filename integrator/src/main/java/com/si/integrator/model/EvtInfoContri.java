package com.si.integrator.model;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Reinf")
public class EvtInfoContri {
	 @Id
	private String id;

	 private String resposta;
     private Object ideEvento;
     private Object ideContri;
     private Object infoContri;
     
     
     public EvtInfoContri(String id,String resposta ,String ideEvento, String ideContri, String infoContri) {
         this.id = id;
         this.resposta = resposta;
         this.ideEvento = ideEvento;
         this.ideContri = ideContri;
         this.infoContri = infoContri;
     }
}
