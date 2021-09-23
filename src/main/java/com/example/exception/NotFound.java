package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**文件找不到异常
 * @author sunwu
 * @since 2021-09-23-15:26
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException{
    static final long serialVersionUID = 745739L;
    public NotFound() {
        super();
    }

    public NotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFound(String message) {
        super(message);
    }
}
