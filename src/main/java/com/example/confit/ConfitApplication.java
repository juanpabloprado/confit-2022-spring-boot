package com.example.confit;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfitApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfitApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(UserService userService) {
    return args -> {
      List.of("Sheldon", "Leonard", "Raj", "Howard")
          .forEach(name -> userService.saveUser(new User(name)));

      userService.listAll().forEach(System.out::println);

    };

  }

}
