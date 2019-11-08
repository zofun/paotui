package com.runningman.paotui;

import com.runningman.paotui.webSocket.webSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
=======
import org.springframework.context.ConfigurableApplicationContext;
>>>>>>> 209b3411e1f26113028628aa9663d9ce2841c1a1

@SpringBootApplication
@ComponentScan(basePackages="com.runningman.paotui")
public class PaotuiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaotuiApplication.class, args);
        ConfigurableApplicationContext configurableApplicationContext = run;
        webSocket.setApplicationContext(configurableApplicationContext);//解决WebSocket不能注入的问题
    }

}
