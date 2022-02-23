package me.arthur.clientservice.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Component
// @ConfigurationProperties("should-do")
public class ShouldDoServiceProperty {
  private String host;
  private String port;

  public ShouldDoServiceProperty(String host, String port) {
    this.host = host;
    this.port = port;
  }

  public String getHost() {
    return this.host;
  }

  public String getPort() {
    return this.port;
  }
}
