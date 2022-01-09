package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.entity.Climber;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("climbing")
public class ClimbingManagementResource {
    @Inject
    ClimberRepository climberRepository;

    @Inject
    Logger LOG;
    @Path("allClimbers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray printAllClimbers() {
        List<Climber> climbers = climberRepository.getAllClimbers();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Climber c : climbers){
            builder.add(Json.createObjectBuilder()
                    .add("id", c.)
                    .add("question", s.question)
            );
        }
        return builder.build();
    }

}