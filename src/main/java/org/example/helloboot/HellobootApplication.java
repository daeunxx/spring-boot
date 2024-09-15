package org.example.helloboot;

import org.example.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

  /*
  @Bean
  ApplicationRunner applicationRunner(Environment environment) {
    return args -> {
      String name = environment.getProperty("my.name");
      System.out.println("my.name: " + name);
    };
  }
  */

  public static void main(String[] args) {
    SpringApplication.run(HellobootApplication.class, args);
  }
}
