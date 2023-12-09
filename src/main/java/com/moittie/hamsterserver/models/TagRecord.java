package com.moittie.hamsterserver.models;

import jakarta.validation.constraints.NotBlank;

public record TagRecord(
        @NotBlank String name,
        @NotBlank String backgroundColor,
        @NotBlank String textColor
) {
}
