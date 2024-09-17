package org.example.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

  @Test
  void configuration() {
    Assertions.assertThat(new Common()).isNotSameAs(new Common());

    MyConfig myConfig = new MyConfig();
    Bean1 bean1 = myConfig.bean1();
    Bean2 bean2 = myConfig.bean2();
    Assertions.assertThat(bean1.common).isNotSameAs(bean2.common);

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(MyConfig.class);
    applicationContext.refresh();

    Bean1 contextBean1 = applicationContext.getBean(Bean1.class);
    Bean2 contextBean2 = applicationContext.getBean(Bean2.class);
    Assertions.assertThat(contextBean1.common).isSameAs(contextBean2.common);
  }

  @Test
  void proxyCommon() {
    MyConfigProxy myConfigProxy = new MyConfigProxy();
    Bean1 bean1 = myConfigProxy.bean1();
    Bean2 bean2 = myConfigProxy.bean2();

    Assertions.assertThat(bean1.common).isSameAs(bean2.common);
  }

  static class MyConfigProxy extends MyConfig {

    private Common common;

    @Override
    Common common() {
      if (this.common == null) {
        this.common = super.common();
      }
      return this.common;
    }
  }

  //@Configuration(proxyBeanMethods = false)
  @Configuration
  static class MyConfig {

    @Bean
    Common common() {
      return new Common();
    }

    @Bean
    Bean1 bean1() {
      return new Bean1(common());
    }

    @Bean
    Bean2 bean2() {
      return new Bean2(common());
    }
  }

  static class Bean1 {

    private final Common common;

    Bean1(Common common) {
      this.common = common;
    }
  }

  static class Bean2 {

    private final Common common;

    Bean2(Common common) {
      this.common = common;
    }
  }

  static class Common {

  }
}
