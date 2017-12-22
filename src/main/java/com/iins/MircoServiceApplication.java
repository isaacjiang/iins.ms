package com.iins;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import com.iins.services.*;

public class MircoServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppConfiguration.class);
        context.getBean(CacheService.class).initialization();  //First to be initialized.

        context.getBean(ScheduleService.class).start();
    }

    @SpringBootApplication
    @EnableScheduling
    @EnableAsync
    @EnableReactiveMongoRepositories
    public static class AppConfiguration extends AbstractReactiveMongoConfiguration {
        @Bean
        CacheService dataCache() {
            return new CacheService();
        }

        @Bean
        ScheduleService scheduleService() {
            return new ScheduleService();
        }

        @Bean
        TaskScheduler taskScheduler() {
            return new ConcurrentTaskScheduler();
        }

        @Override
        @Bean
        public MongoClient reactiveMongoClient() {
            return MongoClients.create();
        }

        @Override
        protected String getDatabaseName() {
            return "reactive";
        }

    }


}
