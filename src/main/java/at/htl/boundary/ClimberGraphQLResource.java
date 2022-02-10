package at.htl.boundary;

import at.htl.control.ClimberService;
import at.htl.entity.Climber;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class ClimberGraphQLResource {
    @Inject
    ClimberService climberService;

    @Query("getAllClimbers")
    @Description("Get all climbers")
    public List<Climber> getAllClimbers(){
        return climberService.getAllClimbers();
    }

    @Query("getClimberById")
    @Description("Get a Climber By Id")
    public Climber getClimberById(@Name("climberId") Long id) {
        return climberService.getClimberById(id);
    }
}
