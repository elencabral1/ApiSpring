package br.com.consoletech.application.process;

import br.com.consoletech.application.hotel.Hotel;
import br.com.consoletech.application.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public ProcessService(ProcessRepository processRepository, HotelRepository hotelRepository) {
        this.processRepository = processRepository;
        this.hotelRepository = hotelRepository;
    }

    public ProcessResponseDto createProcess(ProcessDto processDto) {
        Hotel hotel = hotelRepository.findById(String.valueOf(processDto.hotelId()))
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Process process = new Process();
        process.setHotel(hotel);
        process.setStatus(ProcessStatus.fromCode(processDto.statusCode()));
        process.setDetail(processDto.detail());

        Process savedProcess = processRepository.save(process);

        return new ProcessResponseDto(savedProcess);
    }

    public ProcessResponseDto getProcessById(Long id) {
        Process process = processRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Process not found"));

        return new ProcessResponseDto(process);
    }
}
