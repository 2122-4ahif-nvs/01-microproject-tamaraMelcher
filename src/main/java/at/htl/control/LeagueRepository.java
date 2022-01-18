package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LeagueRepository implements PanacheRepository<League> {
}
