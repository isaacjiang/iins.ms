package com.iins;


import com.iins.system.services.CacheService;
import com.iins.system.services.ScheduleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import com.iins.system.services.*;

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
    public static class AppConfiguration {
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

    }


}
