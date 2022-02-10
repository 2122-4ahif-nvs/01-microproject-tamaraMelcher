package at.htl.boundary;

import at.htl.control.ClimberRepository;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("climber")
public class ClimberAPI {
    @Inject
    ClimberRepository climberRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClimbers() {
        if(!securityIdentity.hasRole("climber") && !securityIdentity.hasRole("admin")) {
            return Response.status(403).build();
        }
        return Response.ok(climberRepository.findAll().list()).build();
    }
}
