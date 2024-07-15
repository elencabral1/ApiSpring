package br.com.consoletech.application.process;

import jakarta.validation.constraints.NotNull;

public record ProcessDto(
        @NotNull Long hotelId,
        @NotNull int statusCode,
        @NotNull String detail
) {}




