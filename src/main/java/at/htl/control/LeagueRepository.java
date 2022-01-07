package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class LeagueRepository implements PanacheRepository<League> {
    @Transactional
    public League save(League league) {
        return getEntityManager().merge(league);
    }
}
