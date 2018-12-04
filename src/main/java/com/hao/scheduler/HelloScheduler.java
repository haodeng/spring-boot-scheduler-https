package com.hao.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloScheduler {

    @Scheduled(fixedDelay = 100, initialDelay = 3000)
    public void run(){
        System.out.println("Hello");
    }
}