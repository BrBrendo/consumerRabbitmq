package com.si.integrator.model;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import org.springframework.data.annotation.Id;



@Data
@Document
public class Reinf {
	 @Id
     private String id;

	 private  EvtInfoContri evtInfoContri;
 
     
     public Reinf(String id, EvtInfoContri evtInfoContri) {
         this.id = id;
         this.setEvtInfoContri(evtInfoContri);
     }


	public EvtInfoContri getEvtInfoContri() {
		return evtInfoContri;
	}


	public void setEvtInfoContri(EvtInfoContri evtInfoContri) {
		this.evtInfoContri = evtInfoContri;
	}
}
