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

    @CheckedTemplate
    static class Templates {
        static native TemplateInstance climbers(List<Climber> climbers);
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
        List<Climber> climbers = climberService.getAllOrders();
        return Templates.climbers(climbers);
    }
}