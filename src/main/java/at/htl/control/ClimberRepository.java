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

}
