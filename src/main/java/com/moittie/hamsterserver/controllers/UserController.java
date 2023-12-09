package com.moittie.hamsterserver.controllers;

import com.moittie.hamsterserver.models.UserRecord;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.services.UserService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

@Path("/me")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GET
    public final Response getInformation(final @HeaderParam("Authorization") String authorization) {
        User user = userService.getUserFromToken(authorization);

        UserRecord record = new UserRecord(
                user.getEmail(),
                user.getFirstname(),
                user.getLastname()
        );

        return Response.ok(record).build();
    }

    @GET
    @Path("/picture")
    public final Response getPicture(final @HeaderParam("Authorization") String authorization) throws URISyntaxException, IOException, InterruptedException {
        User user = userService.getUserFromToken(authorization);

        HttpResponse<byte[]> response = userService.getPicture(user);
        String contentType = response.headers()
                .firstValue("Content-Type")
                .orElse("application/octet-stream");

        return Response.ok(response.body(), contentType).build();
    }
}
