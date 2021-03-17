package santunioni.webflux.heroes_api.service;

import santunioni.webflux.heroes_api.model.Hero;
import santunioni.webflux.heroes_api.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

  private final HeroesRepository heroesRepository;

  public HeroesService(HeroesRepository heroesRepository) {
    this.heroesRepository = heroesRepository;
  }

  public Flux<Hero> findAll(){
    return Flux.fromIterable(this.heroesRepository.findAll());
  }

  public  Mono<Hero> findById(String id){
    return  Mono.justOrEmpty(this.heroesRepository.findById(id));
  }

  public Mono<Hero> save(Hero hero){
    return  Mono.justOrEmpty(this.heroesRepository.save(hero));
  }

  public Mono<Boolean> deleteByID(String id) {
    heroesRepository.deleteById(id);
    return Mono.just(true);

  }

}

