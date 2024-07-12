package br.com.consoletech.application.hotel;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public record HotelDto(
        @NotNull
        String echoToken,
        @NotNull
        Date date,
        @NotNull(message = "MessageId cannot be null")
        String messageId,
        @NotNull
        String sourceId,
        @NotNull(message = "HotelId cannot be null")
        String hotelId,
        @NotNull
        String rateId,
        Set<RatePriceDto> ratePrices

) {

        public HotelDto {
                Objects.requireNonNull(echoToken, "Echo token must not be null");
                Objects.requireNonNull(date, "Receivable Date must not be null");
                Objects.requireNonNull(messageId, "Message ID must not be null");
                Objects.requireNonNull(sourceId, "Source ID must not be null");
                Objects.requireNonNull(hotelId, "Hotel ID must not be null");
                Objects.requireNonNull(rateId, "Rate ID must not be null");
        }
}
