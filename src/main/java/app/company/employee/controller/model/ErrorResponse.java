package app.company.employee.controller.model;

public class ErrorResponse {
    public static final String CLIENT_ERROR_CODE = "001";
    public static final String COMPANY_ERROR_CODE = "002";
    private String errorMessage;
    private String errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
