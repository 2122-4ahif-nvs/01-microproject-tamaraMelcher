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
    @Transactional
    public Route save(Route route) {
        return getEntityManager().merge(route);
    }

    public List<Route> getAllRoutes() {
        return getEntityManager().createNamedQuery("Route.getAllRoutes", Route.class)
                .getResultList();
    }

    public Route getRoutePerId(Long id) {
        return getEntityManager().createNamedQuery("Route.getRoutePerId", Route.class)
                .setParameter("ID", id)
                .getSingleResult();
    }
}
