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

@Path("literaturerank")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class LiteratureRankResource {

    @GET
    public List<LiteratureRank> get() {
        return LiteratureRank.listAll(Sort.by("articleTitle"));
    }

    @GET
    @Path("{id}")
    public LiteratureRank getSingle(@PathParam Long id) {
        LiteratureRank entity = LiteratureRank.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Article with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(LiteratureRank litRank) {
        if (litRank.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        litRank.persist();
        return Response.ok(litRank).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public LiteratureRank update(@PathParam Long id, LiteratureRank litRank) {
        if (litRank.articleTitle == null) {
            throw new WebApplicationException("Literature articleTitle was not set on request.", 422);
        }

        LiteratureRank entity = LiteratureRank.findById(id);

        if (entity == null) {
            throw new WebApplicationException("LiteratureRank with id of " + id + " does not exist.", 404);
        }

        entity.articleTitle = litRank.articleTitle;

        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam Long id) {
        LiteratureRank entity = LiteratureRank.findById(id);
        if (entity == null) {
            throw new WebApplicationException("LiteratureRank with id of " + id + " does not exist.", 404);
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
