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
    public void saveHotel(HotelDto hotelDto) {
        Hotel hotel = HotelMapper.toEntity(hotelDto);
        System.out.println("chegou no service");
        System.out.println(hotel);
        hotelRepository.save(hotel);
    }


    @Transactional(readOnly = true)
    public Hotel getHotelById(String hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.orElse(null);
    }

}



