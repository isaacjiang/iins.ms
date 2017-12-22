package com.iins;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import com.iins.services.*;

public class MircoServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppConfiguration.class);
        context.getBean(CacheService.class).initialization();  //First to be initialized.
        context.getBean(MongoDBService.class).connect();//Second to be initialized.
        context.getBean(ScheduleService.class).start();
    }

    @SpringBootApplication
    @EnableScheduling
    @EnableAsync
    public static class AppConfiguration {
        @Bean
        CacheService dataCache() {
            return new CacheService();
        }
        @Bean
        MongoDBService mongoDBService() {
            return new MongoDBService();
        }
        @Bean
        ScheduleService scheduleService() {
            return new ScheduleService();
        }
        @Bean
        TaskScheduler taskScheduler() {
            return new ConcurrentTaskScheduler();
        }
    }


}
