package br.com.consoletech.application.hotel;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HotelMapper {

    public static Hotel toEntity(HotelDto dto) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(dto.hotelId());
        hotel.setEchoToken(dto.echoToken());
        hotel.setReceivableDate(dto.receivableDate());
        hotel.setSourceId(dto.sourceId());
        hotel.setRateId(dto.rateId());

        Set<RatePrice> ratePrices = dto.ratePrices().stream().map(ratePriceDTO -> {
            RatePrice ratePrice = new RatePrice();
            ratePrice.setRoomTypeId(ratePriceDTO.roomTypeId());
            ratePrice.setHotel(hotel);

            Set<RatePeriod> prices = ratePriceDTO.prices().stream().map(priceDTO -> {
                RatePeriod price = new RatePeriod();
                price.setFrom(priceDTO.from());
                price.setTo(priceDTO.to());
                price.setRatePrice(ratePrice);

                List<Pax> paxes = priceDTO.pax().stream().map(paxDTO -> {
                    Pax pax = new Pax();
                    pax.setCapacity(paxDTO.capacity());
                    pax.setPrice(paxDTO.price());
                    pax.setPrices(price);
                    return pax;
                }).collect(Collectors.toList());

                price.setPaxList(paxes);
                return price;
            }).collect(Collectors.toSet());

            ratePrice.setPriceList(prices);
            return ratePrice;
        }).collect(Collectors.toSet());

        hotel.setRatePrices(ratePrices);
        return hotel;
    }
    public static HotelDto toDto(Hotel hotel) {
        Set<RatePriceDto> ratePrices = hotel.getRatePrices().stream().map(ratePrice -> {
            Set<RatePeriodDto> prices = ratePrice.getPriceList().stream().map(price -> {
                List<PaxDto> paxes = price.getPaxList().stream().map(pax -> new PaxDto(pax.getCapacity(), pax.getPrice())).collect(Collectors.toList());
                return new RatePeriodDto(price.getFrom(), price.getTo(), paxes);
            }).collect(Collectors.toSet());
            return new RatePriceDto(ratePrice.getRoomTypeId(), prices);
        }).collect(Collectors.toSet());

        return new HotelDto(hotel.getEchoToken(), hotel.getReceivableDate(), hotel.getSourceId(), hotel.getHotelId(), hotel.getRateId(), ratePrices);
    }

}
