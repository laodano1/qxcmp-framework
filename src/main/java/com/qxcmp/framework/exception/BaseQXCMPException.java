package com.qxcmp.framework.exception;

public abstract class BaseQXCMPException extends Exception {
    public BaseQXCMPException() {
    }

    public BaseQXCMPException(String message) {
        super(message);
    }

    public BaseQXCMPException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseQXCMPException(Throwable cause) {
        super(cause);
    }

    public BaseQXCMPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
