package com.vinc.service.order.exception;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */
public class AddOrderException extends RuntimeException{

    public AddOrderException() {
    }

    public AddOrderException(String message) {
        super(message);
    }

    public AddOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddOrderException(Throwable cause) {
        super(cause);
    }

    public AddOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
