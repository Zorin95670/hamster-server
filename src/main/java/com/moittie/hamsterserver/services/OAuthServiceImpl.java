package com.moittie.hamsterserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.models.OAuthCodeRecord;
import com.moittie.hamsterserver.models.OAuthTokenRecord;
import com.moittie.hamsterserver.persistence.models.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

@Service
@Transactional
public class OAuthServiceImpl implements OAuthService {

    @Value("${oauth.client-id}")
    private String clientId;

    @Value("${oauth.client-secret}")
    private String clientSecret;

    @Value("${oauth.redirect_uri}")
    private String redirectUri;

    @Override
    public OAuthTokenRecord getToken(OAuthCodeRecord record) throws IOException, URISyntaxException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();

        json.put("grant_type", "authorization_code");
        json.put("code", record.code());
        json.put("client_id", clientId);
        json.put("client_secret", clientSecret);
        json.put("redirect_uri", redirectUri);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://accounts.google.com/o/oauth2/token"))
                .headers("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != Response.Status.OK.getStatusCode()) {
            throw new ApiException(HttpStatus.FORBIDDEN, ApiErrorCode.REJECTED_FROM_PROVIDER);
        }

        JsonNode data = mapper.readTree(response.body());

        return new OAuthTokenRecord(
                data.get("access_token").asText(),
                data.get("id_token").asText(),
                data.get("scope").asText(),
                data.get("token_type").asText(),
                data.get("expires_in").asInt()
        );
    }

    @Override
    public User getUserProfil(OAuthTokenRecord record) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.googleapis.com/oauth2/v1/userinfo"))
                .headers("Authorization", String.format("%s %s", record.token_type(), record.access_token()))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != Response.Status.OK.getStatusCode()) {
            throw new ApiException(HttpStatus.FORBIDDEN, ApiErrorCode.REJECTED_FROM_PROVIDER);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(response.body());

        User user = new User();

        user.setGoogleId(data.get("id").asText());
        user.setEmail(data.get("email").asText());
        user.setFirstname(data.get("given_name").asText());
        user.setLastname(data.get("family_name").asText());
        user.setPicture(data.get("picture").asText());

        return user;
    }


}
