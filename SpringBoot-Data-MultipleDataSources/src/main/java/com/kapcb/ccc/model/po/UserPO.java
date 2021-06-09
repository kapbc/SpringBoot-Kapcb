package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: UserPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: User PO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 13:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = 5781170431775975101L;

    @TableField("id")
    private Long id;

    @TableField("subject_id")
    private Long subjectId;

    @TableField("subject_name")
    private String subjectName;

    @TableField("student_name")
    private String studentName;

    @TableField("student_sex")
    private String studentSex;

    @TableField("start_time")
    private LocalDateTime startTime;

    @TableField("version")
    private Integer version;
}