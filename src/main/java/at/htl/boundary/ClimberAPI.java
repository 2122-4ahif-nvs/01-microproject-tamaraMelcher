package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.control.LeagueRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("api/climber")
public class ClimberAPI {
    @Inject
    LeagueRepository leagueRepository;
    @Inject
    ClimberRepository climberRepository;
    @Inject
    RouteRepository routeRepository;

    @Path("add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Transactional
    public Response add(@Context UriInfo uriInfo
            , @FormParam("fname") String firstName
            , @FormParam("lname") String lastName
            , @FormParam("age") int age
            ,@FormParam("league") Long leagueId){
        League league = leagueRepository.findById(leagueId);
        Climber climber = new Climber(firstName, lastName, age, league);
        climberRepository.persist(climber);

        return Response.status(301)
                .location(URI.create("/"))
                .build();
    }
}
