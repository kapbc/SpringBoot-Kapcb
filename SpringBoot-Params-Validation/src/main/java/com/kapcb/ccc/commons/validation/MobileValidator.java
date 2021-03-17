package com.kapcb.ccc.commons.validation;

import com.kapcb.ccc.commons.annotation.Mobile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a>Title: MobileValidator </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 14:27
 */
@Slf4j
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public void initialize(Mobile constraintAnnotation) {
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isBlank(value)) {
                return true;
            } else {
                String mobileRegex = "[1]\\\\d{10}";
                Pattern pattern = Pattern.compile(mobileRegex);
                Matcher matcher = pattern.matcher(value);
                return matcher.matches();
            }
        } catch (Exception e) {
            log.error("the valid error message is : " + e.getMessage());
            return false;
        }
    }
}
