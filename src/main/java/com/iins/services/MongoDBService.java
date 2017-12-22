package com.iins.services;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;


public class MongoDBService {

    private MongoClient client;
    private com.mongodb.async.client.MongoClient client_ansy;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    @Autowired
    private ApplicationContext applicationContext;

    public MongoDBService() {
    }

    public MongoDBService connect() {
        String host = applicationContext.getBean(CacheService.class).Configuration.get("MongoDbHost");
        int port = Integer.valueOf(applicationContext.getBean(CacheService.class).Configuration.get("MongoDbPort"));
        client = new MongoClient(host, port);
        return this;
    }

    public MongoDBService database(String dbname) {
        if (this.client == null) this.connect();
        database = client.getDatabase(dbname);
        return this;
    }

    public MongoDBService collection(String collectionName) {
        if (database == null) {
            database("nvrt");
        }
        collection = database.getCollection(collectionName);
//        System.out.println("Insert data:" + collectionName);
        return this;
    }


    public void insertOne(JSONObject jsonObject) {
        collection.insertOne(Document.parse(jsonObject.toString()));

    }

    public void insertMany(String collectionName, List<Document> documents) {
        collection.insertMany(documents);
    }


    public void dropCollection(String collectionName){
        this.database.getCollection(collectionName).drop();
    }


    @Override
    protected void finalize() throws Throwable {
        this.client_ansy.close();
        super.finalize();
    }
}
