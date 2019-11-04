package com.runningman.paotui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.runningman.paotui")
public class PaotuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaotuiApplication.class, args);
    }

}
