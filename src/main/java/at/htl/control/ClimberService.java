package at.htl.control;

import at.htl.entity.Climber;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ClimberService {
    private final ClimberRepository climberRepository;

    public ClimberService(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    public List<Climber> getAllClimbers() {
        List<Climber> climbers = (List<Climber>) this.climberRepository.findAll();
        return climbers;
    }
}