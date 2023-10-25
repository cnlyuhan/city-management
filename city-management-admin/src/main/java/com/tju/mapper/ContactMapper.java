package com.tju.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tju.entity.Contact;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Kepass1ove
 * @version 1.0
 * @description: TODO
 * @date 2023/10/15 17:16
 */

@Mapper
public interface ContactMapper extends BaseMapper<Contact> {
}
