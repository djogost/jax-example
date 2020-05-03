package org.vehicle.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/")
public class DemoResource {

    @Context
    private UriInfo uriInfo;

    @Context
    private ServletContext servletContext;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String usefulAnnotations() {
        return "Hello Jas-rs";
    }

    @GET
    @Path("/demo")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String contextDemo(@HeaderParam("header") String header) throws NotFoundException {

        if(header == null) {
            throw new NotFoundException();
        }
        return "The value of custom header value is : "+header;
    }
}
