package com.tju.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tju.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
