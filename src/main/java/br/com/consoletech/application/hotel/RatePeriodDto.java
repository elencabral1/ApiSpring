package br.com.consoletech.application.hotel;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public record RatePeriodDto(
        @NotNull
        Date from,
        @NotNull
        Date to,
        @NotNull
        List<PaxDto> pax
) {
    public RatePeriodDto {
        Objects.requireNonNull(from, "From date must not be null");
        Objects.requireNonNull(to, "To date must not be null");
        Objects.requireNonNull(pax, "Pax list must not be null");
    }


}