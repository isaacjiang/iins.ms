package com.iins.services;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleService {


    public void start() {

    }

    @Scheduled(initialDelay = 500, fixedDelay = 2000)
    public void snmpServicceSchedule() {

         System.out.println("Schedule works ... ");
    }



}
