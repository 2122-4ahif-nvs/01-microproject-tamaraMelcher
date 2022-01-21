package at.htl.boundary;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

public class ClimberAPI {

    @GET
    @RolesAllowed("customer")
    @Produces(MediaType.TEXT_PLAIN)
    public String customer(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }
}
