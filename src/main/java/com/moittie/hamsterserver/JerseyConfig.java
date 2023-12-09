package com.moittie.hamsterserver;

import com.moittie.hamsterserver.controllers.*;
import com.moittie.hamsterserver.controllers.handler.ApiExceptionHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ActivityController.class);
        register(ActivityTagController.class);
        register(OAuthController.class);
        register(StatisticController.class);
        register(TagController.class);
        register(UserController.class);
        register(ApiExceptionHandler.class);
    }
}