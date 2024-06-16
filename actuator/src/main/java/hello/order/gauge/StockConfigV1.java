package hello.order.gauge;

import hello.order.OrderService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

public class StockConfigV1 {

  @Bean
  public MyStockMetric myStockMetric(OrderService orderService, MeterRegistry meterRegistry) {
    return new MyStockMetric(orderService, meterRegistry);
  }

  @Slf4j
  @AllArgsConstructor
  static class MyStockMetric {

    private OrderService orderService;
    private MeterRegistry meterRegistry;

    @PostConstruct
    public void init() {
      Gauge.builder("my.stock", orderService, service -> {
        log.info("stock gauge call");
        return service.getStock().get();
      }).register(meterRegistry);
    }
  }
}
