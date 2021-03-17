package santunioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "santunioni")
public class HeroesApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(HeroesApiApplication.class, args);
  }
}
