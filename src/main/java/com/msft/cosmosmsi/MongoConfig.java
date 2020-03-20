package com.msft.cosmosmsi;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring-data-mongodb-uri}")
    private String vaultMongoUri;
    
    @Value("${spring.data.mongodb.database}")
    private String mongoDBName;

    @Override
    public MongoClient mongoClient() {
        //System.out.println(" =========== Mongo URI:" + mymongoUri);
		return MongoClients.create(vaultMongoUri);
    }

    @Override
    protected String getDatabaseName() {
        return mongoDBName;
    }

}