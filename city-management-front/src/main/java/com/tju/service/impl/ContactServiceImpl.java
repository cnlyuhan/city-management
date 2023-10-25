package com.tju.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.entity.Contact;
import com.tju.mapper.ContactMapper;
import com.tju.service.ContactService;
import org.springframework.stereotype.Service;

/**
* @description: TODO
* @author user
* @date 2023/10/15 17:23
* @version 1.0
*/

@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {
}
