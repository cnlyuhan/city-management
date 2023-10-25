package com.tju.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;

    private Long fatherMenu;

    private Integer hasSon;

    private Integer memberFlag;

    @TableField(fill = FieldFill.INSERT) // 插入时更新字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
