package com.moittie.hamsterserver.controllers.handler;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.moittie.hamsterserver.controllers.models.ApiException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {

    @Override
    public final Response toResponse(final ApiException exception) {
        ObjectNode body = JsonNodeFactory.instance.objectNode();

        body.put("errorCode", exception.getErrorCode().name());

        return Response.status(exception.getStatus().value())
                .entity(body.toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
