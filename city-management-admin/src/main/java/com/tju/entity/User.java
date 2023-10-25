package com.tju.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@ApiModel(value = "User", description = "此实体用于存储用户数据")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "id", name = "主键", required = false, example = "1413342269393674242", hidden = false)
    private Long id;

    @ApiModelProperty(value = "username", name = "用户名", required = true, example = "admin", hidden = false)
    private String username;

    @ApiModelProperty(value = "password", name = "密码", required = true, example = "123456", hidden = false)
    private String password;

    @ApiModelProperty(value = "auth", name = "权限标识", required = true, example = "1", hidden = false)
    // 权限
    private String auth;


    @ApiModelProperty(value = "status", name = "状态标识", required = true, example = "1", hidden = false)
    // 是否禁用
    private Integer status;

    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT) // 插入时更新字段
    private LocalDateTime createTime;

    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime;


    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
