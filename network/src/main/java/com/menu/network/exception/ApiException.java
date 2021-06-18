package com.menu.network.exception;


/**
 * @author lidabo
 * API异常
 */
public class ApiException extends RuntimeException {

    int errorCode;

    public ApiException(String msg, int errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
