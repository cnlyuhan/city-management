package com.tju.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.entity.User;
import com.tju.mapper.UserMapper;
import com.tju.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
