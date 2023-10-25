package com.tju.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.tju.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Kepass1ove
 * @version 1.0
 * @description: TODO
 * @date 2023/10/21 10:12
 */

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
