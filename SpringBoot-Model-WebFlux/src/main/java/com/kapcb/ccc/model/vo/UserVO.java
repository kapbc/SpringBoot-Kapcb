package com.kapcb.ccc.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: UserVO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 15:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = 3690952228983604935L;

    private Long userId;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssS")
    private LocalDateTime birthday;

    private String sex;

    private String password;
}
