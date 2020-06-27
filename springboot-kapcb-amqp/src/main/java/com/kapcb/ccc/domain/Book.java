package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <a>Title:Book</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 22:07
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 2512061366942430593L;

    private String author;
    private String bookName;
}
