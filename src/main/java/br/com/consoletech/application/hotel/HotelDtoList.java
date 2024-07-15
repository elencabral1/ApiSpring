package br.com.consoletech.application.hotel;

import java.util.Set;

public record HotelDtoList(String echoToken, String receivableDate, String sourceId, String hotelId, String rateId, Set<RatePrice> ratePrices
) {

    public HotelDtoList(Hotel hotel){
        this(hotel.getEchoToken(), hotel.getReceivableDate(), hotel.getSourceId(), hotel.getHotelId(), hotel.getRateId(), hotel.getRatePrices()
        );
    }

}
