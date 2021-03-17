package santunioni.webflux.heroes_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroesApiApplication {

  public static void main(String[] args) {

    SpringApplication.run(HeroesApiApplication.class, args);
    System.out.println("super poderes com webflux");
  }

}

