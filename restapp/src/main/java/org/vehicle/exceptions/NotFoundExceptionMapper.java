package org.vehicle.exceptions;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.vehicle.model.ErrorPayload;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException>{

	/*@Override
	public Response toResponse(NotFoundException exception) {
		ErrorPayload error = new ErrorPayload(404, "Element not found");
		
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}*/

	@Override
	public Response toResponse(EntityNotFoundException e) {
		ErrorPayload error = new ErrorPayload(404, "Element not found");
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}
}
