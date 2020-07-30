package io.yaxche.orm;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.panache.common.Sort;

@Path("litcount")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class LitCountResource {

    @GET
    public List<LitCount> get() {
        return LitCount.listAll(Sort.by("geneName"));
    }

    @GET
    @Path("{id}")
    public LitCount getSingle(@PathParam Long id) {
        LitCount entity = LitCount.findById(id);
        if (entity == null) {
            throw new WebApplicationException("LitCount id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @GET
    @Path("/byName/{geneName}")
    public List<LitCount> getByGeneName(@PathParam String geneName) {
        List<LitCount> multi = LitCount.findbyGeneName( geneName );
        if (multi == null) {
            throw new WebApplicationException("LitCount with geneName " + geneName + " does not exist.", 404);
        }
        return multi;
    }
    
    @GET
    @Path("/byUniPID/{uniPID}")
    public List<LitCount> getByUniPID(@PathParam String uniPID) {
        List<LitCount> multi = LitCount.findbyUniPID( uniPID );
        if (multi == null) {
            throw new WebApplicationException("LitCount with uniPID " + uniPID + " does not exist.", 404);
        }
        return multi;
    }
    
    
    
    @POST
    @Transactional
    public Response create(LitCount litCount) {
        if (litCount.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        litCount.persist();
        return Response.ok(litCount).status(201).build();
    }

    /**
     * NOTE:  this is just a shell, will need to be completed.
     * @param id
     * @param litCount
     * @return 
     */
    @PUT
    @Path("{id}")
    @Transactional
    public LitCount update(@PathParam Long id, LitCount litCount) {
        if (litCount.geneName == null) {
            throw new WebApplicationException("LitCount geneName was not set on request.", 422);
        }

        LitCount entity = LitCount.findById(id);

        if (entity == null) {
            throw new WebApplicationException("LitCount with id of " + id + " does not exist.", 404);
        }

        entity.geneName = litCount.geneName;

        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam Long id) {
        LitCount entity = LitCount.findById(id);
        if (entity == null) {
            throw new WebApplicationException("LitCount with id of " + id + " does not exist.", 404);
        }
        entity.delete();
        return Response.status(204).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                    .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
                    .build();
        }

    }
}
