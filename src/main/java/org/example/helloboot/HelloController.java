package org.example.helloboot;

import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final HelloService helloService;
  private final ApplicationContext applicationContext;

  public HelloController(HelloService helloService, ApplicationContext applicationContext) {
    this.helloService = helloService;
    this.applicationContext = applicationContext;

    System.out.println("applicationContext = " + applicationContext);
  }

  //@RequestMapping(value = "/hello", method = RequestMethod.GET)
  @GetMapping("/hello")
  public String hello(String name) {
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
