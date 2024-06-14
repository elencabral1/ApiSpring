package br.com.consoletech.application.hotel;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

public record HotelDto(
        @NotNull
        String echoToken,
        @NotNull
        String timestamp,
        @NotNull
        String sourceId,
        @NotNull
        String hotelId,
        @NotNull
        String rateId,
        Set<RatePriceDto> ratePrices

) {

        public HotelDto {
                Objects.requireNonNull(echoToken, "Echo token must not be null");
                Objects.requireNonNull(timestamp, "Timestamp must not be null");
                Objects.requireNonNull(sourceId, "Source ID must not be null");
                Objects.requireNonNull(hotelId, "Hotel ID must not be null");
                Objects.requireNonNull(rateId, "Ratw ID must not be null");
        }
}
