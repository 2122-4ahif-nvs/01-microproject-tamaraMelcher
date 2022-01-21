package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.control.LeagueRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("climbing")
public class TrainerAPI {
    @Inject
    ClimberRepository climberRepository;

    @Inject
    LeagueRepository leagueRepository;

    @Inject
    RouteRepository routeRepository;

    @Inject
    Logger LOG;

    @Path("allClimbers")
    @GET
    @RolesAllowed("trainer")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray printAllClimbers() {
        List<Climber> climbers = (List<Climber>) climberRepository.findAll();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Climber c : climbers){
            builder.add(Json.createObjectBuilder()
                    .add("id", c.id)
                    .add("lastName", c.lastName)
                    .add("firstName", c.firstName)
                    .add("age", c.age)
                    .add("league", c.league.nameOfLeague)
            );
        }
        return builder.build();
    }

    @POST
    @Path("{climberId}/deleteClimber")
    @RolesAllowed("trainer")
    @Transactional
    public Response deleteClimber(@PathParam("climberId") Long id){
        Climber climber = this.climberRepository.findById(id);
        if (climber == null){
            return Response.status(404).build();
        }
        this.climberRepository.deleteById(id);
        return Response.ok().build();
    }

    @Path("climber/{id}")
    @GET
    @RolesAllowed("trainer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response printClimberPerId(@PathParam("id") Long id) {
        Climber c = climberRepository.findById(id);
        if(c == null)
            return Response.noContent().build();

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("id", c.id);
        objectBuilder.add("lastName", c.lastName);
        objectBuilder.add("firstName", c.firstName);
        objectBuilder.add("age", c.age);
        objectBuilder.add("league", c.league.nameOfLeague);
        return Response.ok(objectBuilder.build()).build();
    }
}
