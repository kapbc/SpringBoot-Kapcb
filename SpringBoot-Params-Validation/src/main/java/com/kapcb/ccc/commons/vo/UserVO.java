package com.kapcb.ccc.commons.vo;

import com.kapcb.ccc.commons.annotation.ListSize;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * <a>Title: UserVO </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 19:23
 */
@Data
public class UserVO implements Serializable {

    @Range(min = 18, max = 110, message = "年龄必须在18 ~ 110岁之间")
    private Integer age;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 15, message = "密码的长度为6 ~ 15位之间")
    @Pattern(regexp = "[a-zA-Z]*", message = "密码不合法")
    private String password;

    private Double balance;

    @Email
    @NotBlank
    private String email;

    @Length(min = 6, max = 11, message = "手机号码长度不正确")
    @NotBlank
    private String phone;

    @ListSize(size = 5)
    private List<String> contentList;
}