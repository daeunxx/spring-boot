package hello.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TrafficController {

  private List<String> list = new ArrayList<>();

  @Autowired
  DataSource dataSource;

  @GetMapping("/cpu")
  public String cpu() {
    log.info("cpu");
    long value = 0;
    for (long i = 0; i < 1000000000000L; i++) {
      value++;
    }
    return "ok value " + value;
  }

  @GetMapping("/jvm")
  public String jvm() {
    log.info("jvm");
    for (int i = 0; i < 1000000; i++) {
      list.add("hello jvm " + i);
    }
    return "ok";
  }

  @GetMapping("/jdbc")
  public String jdbc() throws SQLException {
    log.info("jdbc");
    Connection connection = dataSource.getConnection();
    log.info("connection info={}", connection);
    //connection.close(); //커넥션을 닫는 코드 입력X -> 커넥션풀이 쌓임
    return "ok";
  }

  @GetMapping("/error-log")
  public String errorLog() {
    log.error("error log");
    return "error";
  }
}
