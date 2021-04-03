package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: UserVO </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private Long id;
    private Integer age;
    private String username;
    private String email;
    private String address;
    private Date birthday;

    public UserVO(Builder builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.username = builder.username;
        this.email = builder.email;
        this.address = builder.address;
        this.birthday = builder.birthday;
    }

    public static class Builder {

        private Long id = 1L;
        private Integer age = 0;
        private String username = "";
        private String email = "";
        private String address = "";
        private Date birthday = new Date();

        public Builder() {
        }

        public UserVO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UserVO.Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserVO.Builder username(String username) {
            this.username = username;
            return this;
        }

        public UserVO.Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserVO.Builder address(String address) {
            this.address = address;
            return this;
        }

        public UserVO.Builder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserVO build() {
            return new UserVO(this);
        }
    }
}
