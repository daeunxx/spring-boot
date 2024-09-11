package org.example.helloboot;

import java.util.Objects;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  //@RequestMapping(value = "/hello", method = RequestMethod.GET)
  @GetMapping("/hello")
  public String hello(String name) {
    if (Strings.isBlank(name)) {
      throw new IllegalArgumentException();
    }
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
