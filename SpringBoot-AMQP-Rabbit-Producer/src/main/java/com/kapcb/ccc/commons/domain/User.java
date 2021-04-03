package com.kapcb.ccc.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 12:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private int age;
    private Long userId;
    private String email;
    private String username;
    private String password;

    public User(Builder builder) {
        this.age = builder.age;
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private int age = 0;
        private Long userId = 0L;
        private String email = "";
        private String username = "";
        private String password = "";

        public Builder() {
        }

        public User.Builder age(int age) {
            this.age = age;
            return this;
        }

        public User.Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public User.Builder email(String email) {
            this.email = email;
            return this;
        }

        public User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public User.Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}