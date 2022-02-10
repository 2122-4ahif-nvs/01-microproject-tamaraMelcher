package at.htl.boundary;

import at.htl.RouteRequest;
import at.htl.RouteWithID;
import at.htl.control.ClimberRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.League;
import at.htl.entity.Route;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        public static native TemplateInstance allRoutes(List<Route> routes);
        public static native TemplateInstance chooseARoute(List<Climber> climbers, List<Route> routes);
        public static native TemplateInstance noRouteIsFree(String message);
    }

    @Path("allRoutes")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllRoutes() {
        return Templates.allRoutes(routeRepository.findAll().list());
    }

    @Path("error")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance routeIsNotFree(String message) {
        return Templates.noRouteIsFree(message);
    }

    @Path("chooseRoute")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance chooseRoute() {
        return Templates.chooseARoute(climberRepository.findAll().list(), routeRepository.findAll().list());
    }

    @GrpcClient
    RouteWithID routeWithID;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Uni<Route> getRoute(@PathParam("id") int id) {
        return routeWithID.getRoute(RouteRequest.newBuilder().setId(id).build())
                .onItem().transform(routeReply -> new Route(
                        routeReply.getName(),
                        routeReply.getColor()
                ));
    }
}
