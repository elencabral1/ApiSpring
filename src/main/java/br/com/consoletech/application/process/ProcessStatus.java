package br.com.consoletech.application.process;

public enum ProcessStatus {
    RECEIVED(0, "Received"),
    PROCESSED(1, "Processed"),
    FAILED(2, "Processed with erros");

    private final int code;
    private final String description;

    ProcessStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProcessStatus fromCode(int code) {
        for (ProcessStatus status : ProcessStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
