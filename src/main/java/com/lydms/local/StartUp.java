package com.lydms.local;

import com.lydms.local.web.AddEnglishController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StartUp {

    public static void main(String[] args) {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(StartUp.class);
        ApplicationContext applicationContext = builder.headless(false).run(args);
        AddEnglishController swing = applicationContext.getBean(AddEnglishController.class);
        swing.setVisible(true);
    }
}
