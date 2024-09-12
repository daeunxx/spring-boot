package org.example.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {

}

class HelloServiceTest {

  @FastUnitTest
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