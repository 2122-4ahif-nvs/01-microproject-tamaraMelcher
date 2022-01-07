package at.htl.control;

import at.htl.entity.Climber;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClimberRepository implements PanacheRepository<Climber> {
    @Transactional
    public Climber save(Climber climber) {
        return getEntityManager().merge(climber);
    }
}
