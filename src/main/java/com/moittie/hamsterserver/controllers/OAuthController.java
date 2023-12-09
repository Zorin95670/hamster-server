package com.moittie.hamsterserver.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.moittie.hamsterserver.models.OAuthCodeRecord;
import com.moittie.hamsterserver.models.OAuthTokenRecord;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.persistence.models.UserToken;
import com.moittie.hamsterserver.services.OAuthService;
import com.moittie.hamsterserver.services.UserService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/oauth")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class OAuthController {

    @Autowired
    private OAuthService oAuthService;

    @Autowired
    private UserService userService;

    @POST
    public final Response login(@Valid OAuthCodeRecord record) throws IOException, URISyntaxException, InterruptedException {
        OAuthTokenRecord oauthToken = oAuthService.getToken(record);
        User user = oAuthService.getUserProfil(oauthToken);
        user = userService.register(user);
        UserToken token = userService.generateToken(user);

        ObjectNode userJson = JsonNodeFactory.instance.objectNode();
        userJson.put("firstName", user.getFirstname());
        userJson.put("lastName", user.getLastname());
        userJson.put("picture", user.getPicture());

        ObjectNode tokenJson = JsonNodeFactory.instance.objectNode();
        tokenJson.put("value", token.getToken());
        tokenJson.put("expirationDate", token.getExpirationDate().getTime());

        ObjectNode json = JsonNodeFactory.instance.objectNode();
        json.set("user", userJson);
        json.set("token", tokenJson);

        return Response.status(Response.Status.OK).entity(json).build();
    }
}
