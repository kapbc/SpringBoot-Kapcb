package com.kapcb.ccc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title:Article</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "kapcb",indexStoreType = "article")
public class Article implements Serializable {
    private static final long serialVersionUID = 4397985739060685441L;

    @Id
    private Integer id;
    private String author;
    private String title;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
}
