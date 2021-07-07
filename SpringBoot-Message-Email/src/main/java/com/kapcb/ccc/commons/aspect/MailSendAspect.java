package com.kapcb.ccc.commons.aspect;

import com.kapcb.ccc.commons.service.MailSendLogService;
import com.kapcb.ccc.commons.service.impl.MailSendLogServiceImpl;
import com.kapcb.ccc.domain.MailSendLog;
import com.kapcb.ccc.domain.ReturnInfo;
import com.kapcb.ccc.utils.StringToolUtil;
import com.kapcb.ccc.utils.ThreadLocalUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * <a>Title: MailSendAspect </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/10 22:35
 */
@Slf4j
@Aspect
@Component
@Order(value = 2)
public class MailSendAspect {

    private final MailSendLogService mailSendLogService;

    @Autowired
    public MailSendAspect(@Qualifier("mailSendLogService") MailSendLogServiceImpl mailSendLogService) {
        this.mailSendLogService = mailSendLogService;
    }

    /**
     * 定义切面
     */
    @Pointcut("execution(public * com.kapcb.ccc.commons.service.MailService.send(..))")
    public void mailLog() {
    }

    @AfterReturning(returning = "result", pointcut = "mailLog()")
    public void doAfterReturning(JoinPoint joinPoint, ReturnInfo result) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        /**
         * 下面两个数组中，参数值和参数名的个数和位置是一一对应的
         * 参数值
         */
        Object[] args = joinPoint.getArgs();
        log.info("the args is : " + Arrays.toString(args));
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        /**
         * 参数名称
         */
        String[] argsName = methodSignature.getParameterNames();
        log.info("the args name is : " + Arrays.toString(argsName));
//        CompletableFuture.runAsync()
    }

    @AllArgsConstructor
    private static class MailSendLogStoreThread extends Thread {

        private MailSendLogService mailSendLogService;

        private Object[] args;

        private String[] argsName;

        private String form;

        private String ip;

        private Integer code;

        private String message;

        @Override
        public void run() {
            ThreadLocalUtil.remove("current_mail_from");
            MailSendLog mailSendLog = new MailSendLog();
            for (int i = 0; i < argsName.length; i++) {
                log.info("the arguments name is : " + argsName[i]);
                if ("attachmentFile".equals(argsName[i])) {
                    continue;
                }
                /**
                 * 获取字段上的注解
                 */
                Field field = ReflectionUtils.findField(mailSendLog.getClass(), argsName[i]);
                Column column = field.getAnnotation(Column.class);
                /**
                 * 暴力访问
                 */
                field.setAccessible(true);
                String object = Objects.equals(null, column) ? StringToolUtil.asString(args[i]) : StringToolUtil.asString(args[i], column.length());
            }
            super.run();
        }
    }
}
