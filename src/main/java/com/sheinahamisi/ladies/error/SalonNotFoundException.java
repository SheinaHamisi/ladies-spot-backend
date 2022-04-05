package com.sheinahamisi.ladies.error;

public class SalonNotFoundException extends RuntimeException {
    public SalonNotFoundException() {
        super();
    }

    public SalonNotFoundException(String message) {
        super(message);
    }

    public SalonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalonNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SalonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
