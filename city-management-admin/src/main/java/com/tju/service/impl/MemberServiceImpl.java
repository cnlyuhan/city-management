package com.tju.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.entity.Member;
import com.tju.mapper.MemberMapper;
import com.tju.service.MemberService;
import org.springframework.stereotype.Service;

/**
* @description: TODO
* @author Kepass1ove
* @date 2023/10/21 10:12
* @version 1.0
*/

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
}
