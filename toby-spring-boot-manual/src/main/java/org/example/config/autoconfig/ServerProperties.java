package org.example.config.autoconfig;

import org.example.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

  private String contextPath;

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
