package br.com.consoletech.application.exception;

public class ErrorResponse {
    private String message;
    private String detail;
    private String errorName;

    public ErrorResponse(String message, String detail, String errorName) {
        this.message = message;
        this.detail = detail;
        this.errorName = errorName;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
