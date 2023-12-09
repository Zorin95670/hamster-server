package com.moittie.hamsterserver.controllers;

import com.moittie.hamsterserver.controllers.helpers.ControllerHelper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Path("/activities/{activityId}/tags")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class ActivityTagController {

    @GET
    public final Response getTags() {
        return Response.status(Response.Status.OK).entity(Page.empty()).build();
    }

    // TODO: POST add tag on activity
    // TODO: DELETE tag on activity
}
