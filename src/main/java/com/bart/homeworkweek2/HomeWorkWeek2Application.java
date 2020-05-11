package com.bart.homeworkweek2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HomeWorkWeek2Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkWeek2Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        System.out.println("#######################");
        System.out.println("# WELCOME TO THE SHOP #");
        System.out.println("#######################");
    }
}
