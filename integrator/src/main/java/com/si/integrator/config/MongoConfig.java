package com.si.integrator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
	 @Value("${spring.data.mongodb.uri}")
	    private String connMongoUri;
	    @Bean
	    public MongoDatabaseFactory mongoDatabaseFactory(){
	        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(connMongoUri);
	        return mongoDatabaseFactory;
	    }
	    @Bean("mongoTemplate")
	    public MongoTemplate mongoTemplate(){
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory());
	        return mongoTemplate;
	    }
	}