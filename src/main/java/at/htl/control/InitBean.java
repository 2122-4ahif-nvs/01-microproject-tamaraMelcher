package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.Difficulty;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    ClimberRepository climberRepository;

    @Inject
    LeagueRepository leagueRepository;

    @Inject
    RouteRepository routeRepository;

    @Transactional
    void init(@Observes StartupEvent event){
        League l1 = new League(Difficulty.Hard, "First League");
        League l2 = new League(Difficulty.Medium, "Second League");
        League l3 = new League(Difficulty.Easy, "Third League");
        leagueRepository.persist(l1);
        leagueRepository.persist(l2);
        leagueRepository.persist(l3);
        climberRepository.persist(new Climber("Jakob", "Unterberger", 21, l1));
        climberRepository.persist(new Climber("Tamara", "Melcher", 18, l1));
        climberRepository.persist(new Climber("Elena", "Heckmann", 12, l3));
        climberRepository.persist(new Climber("Jan", "Melcher", 16, l2));
        routeRepository.persist(new Route("The blue monkey","Blue", Difficulty.Hard, true));
        routeRepository.persist(new Route("The orange fish","Orange", Difficulty.Hard, true));
        routeRepository.persist(new Route("Red sun","Red", Difficulty.Easy, true));
        routeRepository.persist(new Route("Greenland","Green", Difficulty.Medium, true));
        routeRepository.persist(new Route("Violence","Violet", Difficulty.Easy, true));
        routeRepository.persist(new Route("Blue-wale","Blue", Difficulty.Hard, true));
        routeRepository.persist(new Route("Dagobert Duck","Yellow", Difficulty.Easy, true));
        routeRepository.persist(new Route("The pink Flamingo","Pink", Difficulty.Medium, true));
    }
}
