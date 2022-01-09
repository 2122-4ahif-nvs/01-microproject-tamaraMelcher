package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LeagueRepository implements PanacheRepository<League> {
    @Transactional
    public League save(League league) {
        return getEntityManager().merge(league);
    }

    public List<League> getAllLeagues() {
        return getEntityManager().createNamedQuery("League.getAllLeagues", League.class)
                .getResultList();
    }

    public League getLeaguePerId(Long id) {
        return getEntityManager().createNamedQuery("League.getLeaguePerId", League.class)
                .setParameter("ID", id)
                .getSingleResult();
    }
}
