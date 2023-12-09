package com.moittie.hamsterserver.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record OAuthCodeRecord(@NotBlank String code) {
}
