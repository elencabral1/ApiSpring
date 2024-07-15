package br.com.consoletech.application.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public ResponseEntity<ProcessResponseDto> createProcess(@RequestBody ProcessDto processDto) {
        ProcessResponseDto createdProcess = processService.createProcess(processDto);
        return ResponseEntity.ok(createdProcess);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessResponseDto> getProcessById(@PathVariable Long id) {
        ProcessResponseDto processResponse = processService.getProcessById(id);
        return ResponseEntity.ok(processResponse);
    }
}

