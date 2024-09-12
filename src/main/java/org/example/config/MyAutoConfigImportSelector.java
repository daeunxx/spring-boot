package org.example.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {
        "org.example.config.autoconfig.DispatcherServletConfig",
        "org.example.config.autoconfig.TomcatWebServerConfig"
    };
  }
}
