package at.htl.control;

import at.htl.entity.Climber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClimberService {
    @Inject
    ClimberRepository climberRepository;

    public List<Climber> getAllClimbers(){
        return climberRepository.findAll().list();
    }

    public Climber getClimberById(Long id){
        return climberRepository.findById(id);
    }
}
