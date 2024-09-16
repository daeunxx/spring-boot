package org.example.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;

public class ServerProperty {

  @Value("${contextPath:}")
  private String contextPath;

  @Value("${port:8080}")
  private int port;

  public String getContextPath() {
    return contextPath;
  }

  public int getPort() {
    return port;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
