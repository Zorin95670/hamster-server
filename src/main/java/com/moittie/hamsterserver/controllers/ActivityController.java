package com.moittie.hamsterserver.controllers;

import com.moittie.hamsterserver.controllers.helpers.ControllerHelper;
import com.moittie.hamsterserver.controllers.models.QueryFilter;
import com.moittie.hamsterserver.models.ActivityRecord;
import com.moittie.hamsterserver.models.TagRecord;
import com.moittie.hamsterserver.persistence.models.Activity;
import com.moittie.hamsterserver.persistence.models.Tag;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.services.ActivityService;
import com.moittie.hamsterserver.services.ActivityTagViewService;
import com.moittie.hamsterserver.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Path("/activities")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class ActivityController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @GET
    public final Response find(final @HeaderParam("Authorization") String authorization,
                               final @Context UriInfo uriInfo,
                               final @BeanParam @Valid QueryFilter queryFilter) {
        Map<String, String> filters = ControllerHelper.getFilters(uriInfo);
        User user = userService.getUserFromToken(authorization);

        filters.put("userId", user.getId().toString());

        return Response.ok(activityService.find(filters, queryFilter.getPagination())).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public final Response update(final @HeaderParam("Authorization") String authorization,
                                 @PathParam("id") @Valid @NotNull final String id,
                                 final @Valid ActivityRecord record) {
        User user = userService.getUserFromToken(authorization);
        activityService.update(user, id, record);

        return Response.noContent().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public final Response update(final @HeaderParam("Authorization") String authorization,
                                 @PathParam("id") @Valid @NotNull final String id) {
        User user = userService.getUserFromToken(authorization);
        activityService.delete(user, id);

        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public final Response add(final @HeaderParam("Authorization") String authorization,
                              final @Valid ActivityRecord record) {
        User user = userService.getUserFromToken(authorization);
        Activity activity = activityService.add(user, record);

        return Response.status(Response.Status.CREATED).entity(activity).build();
    }

    // TODO: GET one activity by id
    // TODO: GET count activities
    // TODO: POST create activity
    // TODO: UPDATE update all activity fields
    // TODO: PATCH update some activity fields
    // TODO: DELETE delete activity
}
