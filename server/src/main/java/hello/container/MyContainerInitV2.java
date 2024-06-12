package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {

  @Override
  public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
    System.out.println("MyContainerInitV2.onStartup");
    System.out.println("set = " + set);
    System.out.println("servletContext = " + servletContext);

    //class hello.container.AppInitV1Servlet
    //AppInit 구현 클래스 모두 가져옴
    for (Class<?> appInitClass : set) {
      try {
        AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
        appInit.onStartUp(servletContext);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
