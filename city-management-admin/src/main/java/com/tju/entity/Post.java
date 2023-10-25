package com.tju.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String postContent;

    private String postTitle;

    private String htmlContent;

    private Long menuId;

    private String image;

    @TableField(fill = FieldFill.INSERT) // 插入时更新字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    // 文章浏览量
    private Long pageView;




}
