package santunioni.webflux.heroes_api.repositories;

import santunioni.webflux.heroes_api.model.Hero;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface HeroesRepository extends CrudRepository<Hero, String>{

    Optional<Hero> findById(String id);

}
