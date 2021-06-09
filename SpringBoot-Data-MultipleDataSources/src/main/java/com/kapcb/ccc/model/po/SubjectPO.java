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
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 11:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "subject")
public class SubjectPO implements Serializable {

    private static final long serialVersionUID = -1034637064962133996L;

    @TableField("id")
    private Long id;

    @TableField("subject_name")
    private String subjectName;

    @TableField("subject_teacher")
    private String subjectTeacher;

    @TableField("subject_classroom")
    private String subjectClassroom;

    @TableField("start_time")
    private LocalDateTime startTime;

    @TableField("end_time")
    private LocalDateTime endTime;
}