package org.example.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

  public static void main(String[] args) {

    GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
    applicationContext.registerBean(HelloController.class);
    applicationContext.registerBean(SimpleHelloService.class);
    applicationContext.refresh();

    ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    WebServer webServer = serverFactory.getWebServer(servletContext ->
        servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext))
            .addMapping("/*"));
    webServer.start();
  }
}
