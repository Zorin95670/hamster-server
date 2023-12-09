package com.moittie.hamsterserver.services;

import com.moittie.hamsterserver.models.UserRecord;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.persistence.models.UserToken;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public interface UserService {

    User register(User user);

    UserToken generateToken(User user);

    User getUserFromToken(String authorization);

    HttpResponse<byte[]> getPicture(User user) throws URISyntaxException, IOException, InterruptedException;
}
