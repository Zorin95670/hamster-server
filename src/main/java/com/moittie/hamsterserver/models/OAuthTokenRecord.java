package com.moittie.hamsterserver.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record OAuthTokenRecord(
        @NotBlank String access_token,
        @NotBlank String id_token,
        @NotBlank String scope,
        @NotBlank String token_type,
        @NotNull int expires_in) {
}
