package br.com.consoletech.application.hotel;

import java.util.Set;

public record HotelDtoList(String echoToken, String timestamp, String sourceId, String hotelId, String rateId, Set<RatePrice> ratePrices
) {

    public HotelDtoList(Hotel hotel){
        this(hotel.getEchoToken(), hotel.getTimestamp(), hotel.getSourceId(), hotel.getHotelId(), hotel.getRateId(), hotel.getRatePrices()
        );
    }

}
