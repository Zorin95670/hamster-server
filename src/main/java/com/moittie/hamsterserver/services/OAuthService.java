package com.moittie.hamsterserver.services;

import com.moittie.hamsterserver.models.OAuthCodeRecord;
import com.moittie.hamsterserver.models.OAuthTokenRecord;
import com.moittie.hamsterserver.persistence.models.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface OAuthService {

    OAuthTokenRecord getToken(OAuthCodeRecord record) throws IOException, URISyntaxException, InterruptedException;

    User getUserProfil(OAuthTokenRecord record) throws URISyntaxException, IOException, InterruptedException;
}
