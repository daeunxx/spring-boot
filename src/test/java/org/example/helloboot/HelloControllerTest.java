package org.example.helloboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

  @Test
  void helloController() {
    HelloController helloController = new HelloController(name -> name);
    String result = helloController.hello("Test");
    assertThat(result).isEqualTo("Test");
  }

  @Test
  void failsHelloController() {
    HelloController helloController = new HelloController(name -> name);
    assertThatThrownBy(() -> helloController.hello(null)).isInstanceOf(
        IllegalArgumentException.class);
    assertThatThrownBy(() -> helloController.hello(" ")).isInstanceOf(
        IllegalArgumentException.class);
  }
}