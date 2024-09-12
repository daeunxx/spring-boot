package org.example.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void simpleHelloService() {
    SimpleHelloService helloService = new SimpleHelloService();
    String result = helloService.sayHello("Test");
    assertThat(result).isEqualTo("Hello Test");
  }

  @Test
  void helloDecorator() {
    HelloDecorator helloDecorator = new HelloDecorator(name -> name);
    String result = helloDecorator.sayHello("Test");
    assertThat(result).isEqualTo("*Test*");
  }
}