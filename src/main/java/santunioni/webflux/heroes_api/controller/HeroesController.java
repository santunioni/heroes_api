package santunioni.webflux.heroes_api.controller;

import santunioni.webflux.heroes_api.model.Hero;
import santunioni.webflux.heroes_api.repository.HeroesRepository;
import santunioni.webflux.heroes_api.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static santunioni.webflux.heroes_api.config.APIConstants.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {

    HeroesService heroesService;

    HeroesRepository heroesRepository;

    //  private static final org.slf4j.Logger log =
    //    org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Hero> getAllItems() {
        log.info("requesting the list off all heroes");
        return heroesService.findAll();

    }


    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Hero>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Hero> createHero(@RequestBody Hero hero) {
        log.info("A new Hero was Created");
        return heroesService.save(hero);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIDHero(@PathVariable String id) {
        heroesService.deleteByID(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
