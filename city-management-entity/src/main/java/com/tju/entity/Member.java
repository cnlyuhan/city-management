package com.tju.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @description: TODO
* @author Kepass1ove
* @date 2023/10/21 10:09
* @version 1.0
*/

@Data
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String image;

    private String intro;

    private String homePage;

    private String email;

    private String position;

    private String company;

    private Long menuId;

    @TableField(fill = FieldFill.INSERT) // 插入时更新字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;



}
