package br.com.consoletech.application.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Hotel saveHotel(HotelDto hotelDto) {
        Hotel hotel = HotelMapper.toEntity(hotelDto);
        hotelRepository.save(hotel);
        return hotel;
    }


    @Transactional(readOnly = true)
    public Hotel getHotelById(String hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.orElse(null);
    }


    @Transactional(readOnly = true)
    public Hotel getHotelByMessageId(String messageId) {
        System.out.println(messageId);
        Optional<Hotel> optionalHotel = hotelRepository.findByMessageId(messageId);
        return optionalHotel.orElse(null);
    }

}



