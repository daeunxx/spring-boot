package hello.order.v3;

import hello.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceV3 implements OrderService {

  private final MeterRegistry meterRegistry;
  private AtomicInteger stock = new AtomicInteger(100);

  @Override
  public void order() {
    Timer timer = Timer.builder("my.order")
        .tag("class", this.getClass().getName())
        .tag("method", "order")
        .description("order")
        .register(meterRegistry);

    timer.record(() -> {
      log.info("주문");
      stock.decrementAndGet();
      sleep(500);
    });
  }

  @Override
  public void cancel() {
    Timer timer = Timer.builder("my.order")
        .tag("class", this.getClass().getName())
        .tag("method", "cancel")
        .description("cancel")
        .register(meterRegistry);

    timer.record(() -> {
      log.info("취소");
      stock.incrementAndGet();
      sleep(200);
    });
  }

  @Override
  public AtomicInteger getStock() {
    return stock;
  }

  private static void sleep(int l) {
    try {
      Thread.sleep(l + new Random().nextInt(200));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
