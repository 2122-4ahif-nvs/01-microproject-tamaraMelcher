package at.htl.control;

import at.htl.entity.Climber;
import at.htl.entity.League;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ClimberRepository implements PanacheRepository<Climber> {
    @Transactional
    public Climber save(Climber climber) {
        return getEntityManager().merge(climber);
    }

    public List<Climber> getAllClimbers() {
        List<Climber> climbers = new LinkedList<>();
        try{
            climbers = getEntityManager().createNamedQuery("Climber.getAllClimbers", Climber.class)
                    .getResultList();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        return climbers;
    }

    public Climber getClimberPerId(Long id) {
        return getEntityManager().createNamedQuery("Climber.getClimberPerId", Climber.class)
                .setParameter("ID", id)
                .getSingleResult();
    }
}
