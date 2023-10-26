package com.tju.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PostDto extends Post{

    @ApiModelProperty(value = "columnName", name = "栏目名称")
    private String menuName;

}
