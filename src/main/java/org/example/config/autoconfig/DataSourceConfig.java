package org.example.config.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Driver;
import javax.sql.DataSource;
import org.example.config.ConditionalMyOnClass;
import org.example.config.EnableMyConfigProperties;
import org.example.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigProperties(MyDataSourceProperties.class)
public class DataSourceConfig {

  @Bean
  @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
  @ConditionalOnMissingBean
  DataSource hikariDataSource(MyDataSourceProperties properties) {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setDriverClassName(properties.getDriverClassName());
    dataSource.setJdbcUrl(properties.getUrl());
    dataSource.setUsername(properties.getUsername());
    dataSource.setPassword(properties.getPassword());
    return dataSource;
  }

  @Bean
  @ConditionalOnMissingBean
  DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
    dataSource.setUrl(properties.getUrl());
    dataSource.setUsername(properties.getUsername());
    dataSource.setPassword(properties.getPassword());
    return dataSource;
  }
}
