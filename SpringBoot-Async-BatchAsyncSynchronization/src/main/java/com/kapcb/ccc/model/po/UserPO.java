package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: User PO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 16:50
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = -6077534385780909398L;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "emil")
    private String email;

    @TableField(value = "product_owner")
    private String productOwner;

    @TableField(value = "supplier_id")
    private Long supplierId;
}