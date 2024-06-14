package br.com.consoletech.application.hotel;

import jakarta.validation.constraints.NotNull;

public record PaxDto(
        @NotNull
        String capacity,
        @NotNull
        Double price
) {
}

