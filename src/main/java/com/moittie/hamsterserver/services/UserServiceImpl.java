package com.moittie.hamsterserver.services;

import com.moittie.hamsterserver.controllers.models.ApiErrorCode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import com.moittie.hamsterserver.persistence.models.User;
import com.moittie.hamsterserver.persistence.models.UserToken;
import com.moittie.hamsterserver.persistence.repository.UserRepository;
import com.moittie.hamsterserver.persistence.repository.UserTokenRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Override
    public User register(User user) {
        Optional<User> optional = userRepository.findByGoogleId(user.getGoogleId());

        return optional.orElseGet(() -> userRepository.save(user));
    }

    @Override
    public UserToken generateToken(User user) {
        Optional<UserToken> optional = userTokenRepository.findByUsrId(user.getId());
        optional.ifPresent(userToken -> {
            userTokenRepository.delete(userToken);
            userTokenRepository.flush();
        });

        UserToken token = new UserToken();
        token.setUsrId(user.getId());

        return userTokenRepository.save(token);
    }

    @Override
    public User getUserFromToken(String authorization) {
        System.out.println(authorization);
        if (StringUtils.isBlank(authorization)) {
            throw new ApiException(HttpStatus.FORBIDDEN, ApiErrorCode.EMPTY_TOKEN);
        }
        UserToken token = userTokenRepository
                .findByToken(authorization.replace("token ", ""))
                .orElseThrow(() -> new ApiException(HttpStatus.FORBIDDEN, ApiErrorCode.NO_TOKEN));

        return userRepository
                .findById(token.getUsrId())
                .orElseThrow(() -> new ApiException(HttpStatus.FORBIDDEN, ApiErrorCode.NO_TOKEN));
    }

    @Override
    public HttpResponse<byte[]> getPicture(User user) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(user.getPicture()))
                .GET()
                .build();

        return HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofByteArray());
    }
}
