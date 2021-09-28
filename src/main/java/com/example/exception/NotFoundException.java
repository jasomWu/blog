package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**文件找不到异常
 * @author sunwu
 * @since 2021-09-23-15:26
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    static final long serialVersionUID = 745739L;
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFoundException(String message) {
        super(message);
    }
}
