package com.runningman.paotui;

import com.runningman.paotui.webSocket.webSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PaotuiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaotuiApplication.class, args);
        ConfigurableApplicationContext configurableApplicationContext = run;
        webSocket.setApplicationContext(configurableApplicationContext);//解决WebSocket不能注入的问题
    }

}
