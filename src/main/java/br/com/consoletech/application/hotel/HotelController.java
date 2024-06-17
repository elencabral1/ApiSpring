package br.com.consoletech.application.hotel;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid HotelDto hotelDto) {
        Hotel hotel = hotelService.saveHotel(hotelDto);
        String message = String.format("Processado com sucesso: messageId %s", hotel.getMessageId());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable("id") String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            HotelDto hotelDto = HotelMapper.toDto(hotel);
            return ResponseEntity.ok(hotelDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<String> getHotelByMessageId(@PathVariable("messageId") String messageId) {
        Hotel hotel = hotelService.getHotelByMessageId(messageId);
        if (hotel != null) {
            return ResponseEntity.ok("Processado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

