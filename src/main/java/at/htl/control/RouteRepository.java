package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.Route;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RouteRepository implements PanacheRepository<Route> {
    @Transactional
    public Route save(Route route) {
        return getEntityManager().merge(route);
    }
}