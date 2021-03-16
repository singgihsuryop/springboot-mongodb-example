package com.singgihsuryop.springboot.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration{

    @Value("${mongo.db.database}")
    private String DB_NAME;

    @Value("${mongo.db.hostname}")
    private String HOST;

    @Value("${mongo.db.portno}")
    private Integer PORT;
    
    @Override
    protected String getDatabaseName() {
	return DB_NAME;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
	return new MongoClient(HOST, PORT);
    }

}
