package org.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  HelloRepository helloRepository;

  @Test
  void findHelloFailed() {
    Assertions.assertThat(helloRepository.findHello("dauen")).isNull();
  }

  @Test
  void increaseCount() {
    helloRepository.increaseCount("daeun");
    Assertions.assertThat(helloRepository.countOf("daeun")).isEqualTo(1);

    helloRepository.increaseCount("daeun");
    Assertions.assertThat(helloRepository.countOf("daeun")).isEqualTo(2);
  }
}
