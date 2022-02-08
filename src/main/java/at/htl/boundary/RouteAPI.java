package at.htl.boundary;

import at.htl.control.ClimberRepository;
import at.htl.control.RouteRepository;
import at.htl.entity.Climber;
import at.htl.entity.Route;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("api/route")
public class RouteAPI {
    @Inject
    ClimberRepository climberRepository;
    @Inject
    RouteRepository routeRepository;
    @Inject
    RouteResource routeResource;

    @Path("chooseRoute")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Transactional
    public Response chooseRoute(@Context UriInfo uriInfo
            , @FormParam("climber") Long climberId
            , @FormParam("route") Long routeId){
        Climber climber = climberRepository.findById(climberId);
        Route route = routeRepository.findById(routeId);
        if(route.isFree){
            route.isFree = false;
            routeRepository.updateRoute(route);
        }else {
            String message = "Route is being used";
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(routeResource.routeIsNotFree(message))
                    .type(MediaType.TEXT_HTML_TYPE)
                    .build();
        }
        return Response.status(301)
                .location(URI.create("/"))
                .build();
    }
}
