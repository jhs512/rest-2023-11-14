package com.ll.rest20231114;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Rest20231114Application {

    public static void main(String[] args) {
        SpringApplication.run(Rest20231114Application.class, args);
    }

}
