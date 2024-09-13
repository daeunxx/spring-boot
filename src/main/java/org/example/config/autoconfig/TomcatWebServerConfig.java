package org.example.config.autoconfig;

import org.example.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
public class TomcatWebServerConfig {

  @Bean
  public ServletWebServerFactory serverFactory() {
    return new TomcatServletWebServerFactory();
  }
}
