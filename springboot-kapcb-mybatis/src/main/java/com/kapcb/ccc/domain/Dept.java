package com.kapcb.ccc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * <a>Title:Dept</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 13:24
 */
@Data
public class Dept implements Serializable {

    private static final long serialVersionUID = 3033423463596148357L;

    private Integer id;
    private String deptName;

}
