package com.iins.system.services;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class ScheduleService {


    public void start() {

    }

    @Scheduled(initialDelay = 500, fixedDelay = 20000)
    public void ScheduleServicce() {

        System.out.println("Schedule works ... " + new Date());
    }



}
