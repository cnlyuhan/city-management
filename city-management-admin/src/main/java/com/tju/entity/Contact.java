package com.tju.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String content;

//    @TableField(fill = FieldFill.INSERT) // 插入时更新字段
    private LocalDateTime createTime;


}
