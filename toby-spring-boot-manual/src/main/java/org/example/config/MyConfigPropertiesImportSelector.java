package org.example.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MyConfigPropertiesImportSelector implements DeferredImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    MultiValueMap<String, Object> attributes = importingClassMetadata.getAllAnnotationAttributes(
        EnableMyConfigProperties.class.getName());
    Class propertyClass = (Class) attributes.getFirst("value");
    return new String[] {propertyClass.getName()};
  }
}
