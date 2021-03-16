package com.kapcb.ccc.commons.validation;

import com.kapcb.ccc.commons.annotation.ListSize;
import com.kapcb.ccc.commons.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * <a>Title: ListSizeValidator </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/15 21:27
 */
@Slf4j
@Component
public class ListSizeValidator implements ConstraintValidator<ListSize, List> {

    private Integer size;

    @Override
    public void initialize(ListSize constraintAnnotation) {
        log.info("begin to dynamic get the value from annotation");
        this.size = constraintAnnotation.size();
        log.info("the required List size is : " + size);
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext context) {
        log.info("the list size is : " + list.size());
        if (list.size() < this.size) {
            log.info("the validator is pass!");
            return true;
        }

        /**
         * 自定义校验错误信息
         */
        StringBuilder message = new StringBuilder();
        message.append(" the list size must range between [0 ~ " + this.size + "]");
        log.info(" the message is : " + message.toString());
        context.disableDefaultConstraintViolation();
        ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = context.buildConstraintViolationWithTemplate(message.toString());
        constraintViolationBuilder.addConstraintViolation();
        return false;

    }
}
