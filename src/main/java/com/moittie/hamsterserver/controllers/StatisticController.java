package com.moittie.hamsterserver.controllers;

import com.moittie.hamsterserver.controllers.helpers.ControllerHelper;
import com.moittie.hamsterserver.controllers.models.QueryFilter;
import com.moittie.hamsterserver.models.ActivityRecord;
import com.moittie.hamsterserver.persistence.models.Activity;
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
import org.springframework.stereotype.Controller;

import java.util.Map;

@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class StatisticController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityTagViewService activityTagViewService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/activities/tags")
    public Response getTagDistribution(final @Context UriInfo uriInfo, final @Valid @NotBlank @QueryParam("field") String field,
                          final @QueryParam("value") String value) {
        System.out.println("passe");;
        Map<String, String> filters = ControllerHelper.getFilters(uriInfo);
//        LOGGER.info("Received GET request to count deployments with filters {}.", filters);
        // TODO: filter by user
        return Response.ok(this.activityTagViewService.count(filters, field, value)).build();
    }
}
