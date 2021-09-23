package com.example.handle;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**异常处理类
 * @author sunwu
 * @since 2021-09-23-15:05
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public String exceptionHandle(HttpServletRequest request ,Exception e,Model model) throws Exception {
        // 将文件找不到异常不定位到error页面
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        log.error(" url :{} , exception :{}", request.getRequestURL(), e.getMessage());
        model.addAttribute("url", request.getRequestURI());
        model.addAttribute("exception", e);
        return "error/error";
    }
}
