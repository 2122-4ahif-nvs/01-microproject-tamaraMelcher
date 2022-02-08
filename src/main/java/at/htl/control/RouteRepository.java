package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RouteRepository implements PanacheRepository<Route> {
    public void updateRoute(Route route) {
        getEntityManager().merge(route);
    }
}
