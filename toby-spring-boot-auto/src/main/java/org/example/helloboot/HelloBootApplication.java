package org.example.helloboot;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HelloBootApplication {

  private final JdbcTemplate jdbcTemplate;

  public HelloBootApplication(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @PostConstruct
  void init() {
    jdbcTemplate.execute(
        "create table if not exists hello(name varchar(50) primary key, count int)");
  }

  @Bean
  ApplicationRunner run(ConditionEvaluationReport report) {
    return args -> {
      report.getConditionAndOutcomesBySource().entrySet().stream()
          .filter(condition -> condition.getValue().isFullMatch())
          .forEach(condition -> {
            System.out.println(condition.getKey());
            condition.getValue().forEach(c -> System.out.println("\t" + c.getOutcome()));
            System.out.println();
          });
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloBootApplication.class, args);
  }
}
