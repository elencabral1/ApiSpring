package br.com.consoletech.application.hotel;

import br.com.consoletech.application.exception.ErrorResponse;
import br.com.consoletech.application.process.ProcessDto;
import br.com.consoletech.application.process.ProcessService;
import br.com.consoletech.application.process.ProcessStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;
    private final ProcessService processService;


    @Autowired
    public HotelController(HotelService hotelService, ProcessService processService) {
        this.hotelService = hotelService;
        this.processService = processService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid HotelDto hotelDto) {
        Hotel hotel = hotelService.saveHotel(hotelDto);
        if (hotel != null) {
            ProcessDto processDto = new ProcessDto(
                    hotel.getMessageId(),
                    0,
                    "Hotel created and awaiting processing"
            );
            processService.createProcess(processDto);
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
    public ResponseEntity<?> getHotelByMessageId(@PathVariable("messageId") Long messageId) {
        Hotel hotel = hotelService.getHotelByMessageId(messageId);
        if (hotel != null) {
            String message = String.format("Processed: messageId %s", hotel.getMessageId());
            return ResponseEntity.ok(message);
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

