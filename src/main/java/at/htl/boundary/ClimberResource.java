package at.htl.boundary;

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
import at.htl.control.ClimberService;
import at.htl.entity.Climber;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

import java.util.ArrayList;
import java.util.List;

@Path("hello")
public class ClimberResource {

    @Inject
    Template hello;

    @Inject
    ClimberService climberService;

    @Inject
    ClimberRepository climberRepository;

    @Inject
    Template climber;

    @CheckedTemplate
    static class Templates {
        static native TemplateInstance climbers(List<Climber> climbers);
        static native TemplateInstance climber(Climber climber);

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get(@QueryParam("name") String name) {
        return hello.data("name", name);
    }

    @Path("allClimbers")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Climber> climbers = climberService.getAllClimbers();
        return Templates.climbers(climbers);
    }

    /*@Path("climber")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") Long id) {
        Climber climber = climberRepository.getClimberPerId(id);
        return Templates.climber(climber);
    }*/
}