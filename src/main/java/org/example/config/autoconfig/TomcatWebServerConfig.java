package org.example.config.autoconfig;

import org.example.config.ConditionalMyOnClass;
import org.example.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

  @Bean("tomcatWebServerFactory")
  @ConditionalOnMissingBean
  public ServletWebServerFactory servletWebServerFactory(Environment environment) {
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    serverFactory.setContextPath(environment.getProperty("contextPath"));
    return serverFactory;
  }
}
