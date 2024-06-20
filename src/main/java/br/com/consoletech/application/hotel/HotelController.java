package br.com.consoletech.application.hotel;

import br.com.consoletech.application.exception.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getHotelByMessageId(@PathVariable("messageId") String messageId) {
        Hotel hotel = hotelService.getHotelByMessageId(messageId);
        if (hotel != null) {
            return ResponseEntity.ok("Processed");
        } else {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Hotel not found",
                    "No hotel found with the provided messageId",
                    "HotelNotFound"
            );
            return ResponseEntity.status(404).body(errorResponse);
        }
    }
}

