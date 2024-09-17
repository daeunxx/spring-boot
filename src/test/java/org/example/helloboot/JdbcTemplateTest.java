package org.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class JdbcTemplateTest {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  void insertAndQuery() {
    jdbcTemplate.update("insert into hello values(?, ?)", "daeun", 1);
    jdbcTemplate.update("insert into hello values(?, ?)", "spring", 2);

    Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
    Assertions.assertThat(count).isEqualTo(2);
  }

  @Test
  void checkRollback() {
    jdbcTemplate.update("insert into hello values(?, ?)", "daeun", 1);
    jdbcTemplate.update("insert into hello values(?, ?)", "spring", 2);

    Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
    Assertions.assertThat(count).isEqualTo(2);
  }
}
