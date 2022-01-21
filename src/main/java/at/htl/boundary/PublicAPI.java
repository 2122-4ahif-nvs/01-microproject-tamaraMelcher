package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.control.LeagueRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import org.jboss.logging.Logger;

import javax.annotation.security.PermitAll;
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
public class PublicAPI {
    @Inject
    ClimberRepository climberRepository;

    @Inject
    LeagueRepository leagueRepository;

    @Inject
    RouteRepository routeRepository;

    @Inject
    Logger LOG;

    @Path("allLeagues")
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray printAllLeagues() {
        List<League> leagues = (List<League>) leagueRepository.findAll();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (League l : leagues){
            builder.add(Json.createObjectBuilder()
                    .add("id", l.id)
                    .add("nameOfLeague", l.nameOfLeague)
                    .add("difficulty", String.valueOf(l.difficulty))
            );
        }
        return builder.build();
    }

    @Path("league/{id}")
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response printLeagueWithAllClimbers(@PathParam("id") Long id) {
        League l = leagueRepository.findById(id);
        if(l == null)
            return Response.noContent().build();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("id", l.id);
        objectBuilder.add("nameOfLeague", l.nameOfLeague);
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Climber c : l.climbers){
            builder.add(Json.createObjectBuilder()
                    .add("id", c.id)
                    .add("lastName", c.lastName)
                    .add("firstName", c.firstName)
                    .add("age", c.age)
                    .add("league", c.league.nameOfLeague)
            );
        }
        objectBuilder.add("climbers", builder.build());
        return Response.ok(objectBuilder.build()).build();
    }

    @Path("allRoutes")
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray printAllRoutes() {
        List<Route> routes = (List<Route>) routeRepository.findAll();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Route r : routes){
            builder.add(Json.createObjectBuilder()
                    .add("id", r.id)
                    .add("difficulty", String.valueOf(r.difficulty))
                    .add("colour", r.color)
                    .add("status", r.isFree)
            );
        }
        return builder.build();
    }

    @Path("route/{id}")
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response printRoute(@PathParam("id") Long id) {
        Route r = routeRepository.findById(id);
        if(r == null)
            return Response.noContent().build();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("id", r.id);
        objectBuilder.add("difficulty", String.valueOf(r.difficulty));
        objectBuilder.add("colour", r.color);
        objectBuilder.add("status", r.isFree);
        return Response.ok(objectBuilder.build()).build();
    }
}