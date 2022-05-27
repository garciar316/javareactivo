package com.example.javareactivo;

import com.example.javareactivo.operadores.OperadoresCondicionales;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavareactivoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavareactivoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OperadoresCondicionales app = new OperadoresCondicionales();
        app.defaultIfEmpty();
    }
}
