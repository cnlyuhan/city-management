package com.tju.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tju.entity.Contact;
import com.tju.entity.R;
import com.tju.mapper.ContactMapper;
import com.tju.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
* @description: TODO
* @author user
* @date 2023/10/15 17:17
* @version 1.0
*/


@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
    * @description: 新增联系
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:21
    */

//    @PutMapping("/submit")
//    public R<String> submit(@RequestBody Contact contact){
//        log.info("新增联系：{}", contact);
//        contact.setCreateTime(LocalDateTime.now());
//        contactService.save(contact);
//        return R.success("新增成功，我们会尽快回复！");
//    }


    /**
    * @description: 分页展示Contact
    * @param:
    * @return: com.tju.entity.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:46
    */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        Page<Contact> contactPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Contact> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Contact::getCreateTime);
        contactService.page(contactPage, queryWrapper);
        return R.success(contactPage);
    }

}
