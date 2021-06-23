package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: UserPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 14:33
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = 5781170431775975101L;

    @Id
    private Long userId;

    private String firstName;

    private String lastName;

    private LocalDateTime birthday;

    private Integer version;

    private String sex;

    private Boolean delete;

    private String password;
}