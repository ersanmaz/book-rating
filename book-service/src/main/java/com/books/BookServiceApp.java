package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BookServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApp.class, args);
    }

}
