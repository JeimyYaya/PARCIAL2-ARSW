package edu.arsw.game;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"edu.eci.arsw.game"})
public class App {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(App.class, args);
    }
}