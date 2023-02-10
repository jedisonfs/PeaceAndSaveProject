package co.edu.sena.mapping.util.exception.runtime;

import org.springframework.stereotype.Component;

@Component("UserNotDeletedException")
public class UserNotDeletedException extends RuntimeException {

    private static final long serialVersionUID = 123L;
    private String errorCode;
    private String errorMessage;

    public UserNotDeletedException() {

    }

    public UserNotDeletedException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public UserNotDeletedException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
