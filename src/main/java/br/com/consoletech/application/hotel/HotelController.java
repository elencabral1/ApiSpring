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
    public ResponseEntity<?> save(@RequestBody @Valid HotelDto hotelDto) {
        Hotel hotel = hotelService.saveHotel(hotelDto);
        if (hotel != null) {
            String message = String.format("Processed successfully: messageId %s", hotel.getMessageId());
            return ResponseEntity.ok(message);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Hotel not saved",
                    "The hotel could not be saved with the provided details. Please check the input and try again.",
                    "HotelSaveError"
            );
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            HotelDto hotelDto = HotelMapper.toDto(hotel);
            return ResponseEntity.ok(hotelDto);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Hotel not found",
                    String.format("No hotel found with the provided ID: %s", hotelId),
                    "HotelNotFound"
            );
            return ResponseEntity.status(404).body(errorResponse);
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

