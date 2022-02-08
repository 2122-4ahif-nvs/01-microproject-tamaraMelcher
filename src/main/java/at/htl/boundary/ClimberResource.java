package at.htl.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import at.htl.control.ClimberRepository;
import at.htl.control.LeagueRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("climber")
public class ClimberResource {

    @Inject
    ClimberRepository climberRepository;
    @Inject
    LeagueRepository leagueRepository;
    @Inject
    RouteRepository routeRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance climbers(List<Climber> climbers);
        public static native TemplateInstance addClimber(List<League> leagues);
    }

    @Path("allClimbers")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllClimbers() {
        return Templates.climbers(climberRepository.findAll().list());
    }


    @Path("addClimber")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance addNewCLimber() {
        return Templates.addClimber(leagueRepository.findAll().list());
    }


}