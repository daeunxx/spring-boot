package org.example.config.autoconfig;

import org.example.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertyConfig {

  @Bean
  public ServerProperty serverProperty(Environment environment) {
    return Binder.get(environment).bind("", ServerProperty.class).get();
  }
}
