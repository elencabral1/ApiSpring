package br.com.consoletech.application.process;

public record ProcessResponseDto(
        Long hotelId,
        String status,
        String detail
) {
    public ProcessResponseDto(Process process) {
        this(process.getHotel().getMessageId(), process.getStatus().getDescription(), process.getDetail());
    }
}
