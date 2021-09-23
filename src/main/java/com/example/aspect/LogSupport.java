package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**日志切面，记录信息
 * @author sunwu
 * @since 2021-09-23-16:05
 */
@Slf4j
@Aspect
public class LogSupport {
    /**
     * web页面的所有信息
     */
    @Pointcut("execution(* com.example.web.*.*(..))")
    public void log(){}

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        log.info("-----------before-->{}()------------",joinPoint.getSignature().getDeclaringTypeName());
        log.info("Request --> ",requestLog.toString());
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void returnLog(Object result){
        log.info("Result --> {}",result);
    }

    //内部封装类
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    ", returnContext='" +
                    '}';
        }
    }

}
