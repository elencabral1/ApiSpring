package br.com.consoletech.application.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

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
        Hotel hotel2 = hotelRepository.save(hotel);
        return hotel2;
    }


    @Transactional(readOnly = true)
    public Hotel getHotelById(String hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.orElse(null);
    }


    @Transactional(readOnly = true)
    public Hotel getHotelByMessageId(Long messageId) {
        System.out.println(messageId);
        Optional<Hotel> optionalHotel = hotelRepository.findByMessageId(messageId);
        return optionalHotel.orElse(null);
    }


}



