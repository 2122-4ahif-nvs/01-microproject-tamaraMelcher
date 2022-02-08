package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("route")
public class RouteResource {

    @Inject
    RouteRepository routeRepository;
    @Inject
    ClimberRepository climberRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance routes(List<Route> routes);
        public static native TemplateInstance chooseRoute(List<Climber> climbers, List<Route> routes);
        public static native TemplateInstance routeIsNotFree(String message);
    }

    @Path("allRoutes")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllRoutes() {
        return Templates.routes(routeRepository.findAll().list());
    }

    @Path("error")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance routeIsNotFree(String message) {
        return Templates.routeIsNotFree(message);
    }

    @Path("chooseRoute")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance chooseRoute() {
        return Templates.chooseRoute(climberRepository.findAll().list(), routeRepository.findAll().list());
    }

}
