package br.com.consoletech.application.hotel;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

public record RatePriceDto(
        @NotNull
        String roomTypeId,
        @NotNull
        Set<RatePeriodDto> prices
) {
    public RatePriceDto {
        Objects.requireNonNull(roomTypeId, "Room type ID must not be null");
        Objects.requireNonNull(prices, "Prices list must not be null");
    }

}