package com.moittie.hamsterserver.controllers;

import com.moittie.hamsterserver.controllers.helpers.ControllerHelper;
import com.moittie.hamsterserver.controllers.models.QueryFilter;
import com.moittie.hamsterserver.models.ActivityRecord;
import com.moittie.hamsterserver.models.TagRecord;
import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.TagView;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.services.TagService;
import com.moittie.hamsterserver.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Path("/tags")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @GET
    public final Response find(final @HeaderParam("Authorization") String authorization,
                               final @Context UriInfo uriInfo,
                               final @BeanParam @Valid QueryFilter queryFilter) {
        Map<String, String> filters = ControllerHelper.getFilters(uriInfo);
        User user = userService.getUserFromToken(authorization);

        filters.put("userId", user.getId().toString());

        if (filters.containsKey("withCount") && "true".equals(filters.get("withCount"))) {
            final Page<TagView> resources =
                    this.tagService.findWithCount(filters, queryFilter.getPagination());
            return Response.status(ControllerHelper.getStatus(resources)).entity(resources).build();
        }

        final Page<Tag> resources =
                this.tagService.find(filters, queryFilter.getPagination());
        return Response.status(ControllerHelper.getStatus(resources)).entity(resources).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public final Response update(final @HeaderParam("Authorization") String authorization,
                                 @PathParam("id") @Valid @NotNull final String id,
                                 final @Valid TagRecord record) {
        User user = userService.getUserFromToken(authorization);
        tagService.update(user, id, record);

        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public final Response add(final @HeaderParam("Authorization") String authorization,
                              final @Valid TagRecord record) {
        User user = userService.getUserFromToken(authorization);

        Tag tag = tagService.add(user, record);

        return Response.status(Response.Status.CREATED).entity(tag).build();
    }
}
