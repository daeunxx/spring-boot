package hello.external;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OsEnv {

  public static void main(String[] args) {
    Map<String, String> envMap = System.getenv();
    for (String key : envMap.keySet()) {
      log.info("env {}={}", key, System.getenv(key));
    }

    //개발서버 DBURL=dev.db.com
    //운영서버 DBURL=prod.db.com
    //System.getenv("DBURL");
  }
}
