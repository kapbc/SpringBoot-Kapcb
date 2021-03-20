package com.kapcb.ccc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: ItemPojo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/18 22:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPojo {

    private Long id;
    private String title;
    private String sellPoint;
    private BigDecimal price;
    private Long num;
    private String barcode;
    private String image;
    private String cid;
    private Integer status;
    private Date created;

    private Date updated;

}
