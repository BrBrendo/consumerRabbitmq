package com.si.integrator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.si.integrator.model.Reinf;

public interface Repository extends MongoRepository<Reinf, String> {

	
}
