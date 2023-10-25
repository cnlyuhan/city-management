package com.tju.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tju.entity.*;
import com.tju.service.ContactService;
import com.tju.service.MemberService;
import com.tju.service.MenuService;
import com.tju.service.PostService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @description: TODO
* @author Kepass1ove
* @date 2023/10/15 19:22
* @version 1.0
*/

@RestController
@RequestMapping("/front")
@Slf4j
public class FrontController {

    @Autowired
    private PostService postService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private MenuService menuService;
    
    @Autowired
    private MemberService memberService;

    /**
    * @description: 根据id获取文章
    * @param:
    * @return: com.tju.entity.R<com.tju.entity.PostDto>
    * @author: Kepass1ove
    * @date: 2023/10/15 19:36
    */

    @GetMapping("/getPost")
    public R<PostDto> getPostById(Long id){
        PostDto postDto = postService.getByIdWithMenuName(id);
        return R.success(postDto);
    }

    /**
    * @description: 分页查询当前menuId的所有文章
    * @param:
    * @return: com.tju.entity.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
    * @author: Kepass1ove
    * @date: 2023/10/15 19:37
    */

    @GetMapping("/page")
    public R<Page> page(@ApiParam(required = true)int page, @ApiParam(required = true) int pageSize,
                        @ApiParam(required = true) Long menuId, @ApiParam(required = false) String title){
        Page<Post> postPage = new Page<>(page, pageSize);
        Page<PostDto> postDtoPage = new Page<>();

        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Post::getMenuId, menuId);
        queryWrapper.like(title != null, Post::getPostTitle, title);
        queryWrapper.orderByDesc(Post::getUpdateTime);
        postService.page(postPage, queryWrapper);
        BeanUtils.copyProperties(postPage, postDtoPage, "records");
        List<Post> records = postPage.getRecords();
        List<PostDto> list = records.stream().map((item) ->{
            PostDto postDto = new PostDto();
            BeanUtils.copyProperties(item, postDto);
            Long id = item.getMenuId();
            Menu menu = menuService.getById(id);
            postDto.setMenuName(menu.getName());
            return postDto;
        }).collect(Collectors.toList());
        postDtoPage.setRecords(list);
        return R.success(postDtoPage);
    }

    /**
    * @description: 获取所有最高级别的menu
    * @param:
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Menu>>
    * @author: Kepass1ove
    * @date: 2023/10/15 19:38
    */

    @GetMapping("/getTopMenus")
    public R<List<Menu>> getTopMenus(){
        log.info("获取所有最高级栏目");
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getFatherMenu, 0L);
        queryWrapper.orderByDesc(Menu::getCreateTime);
        List<Menu> menuList = menuService.list(queryWrapper);
        return R.success(menuList);
    }

    /**
    * @description: 获取当前menu所有的子menu
    * @param:
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Menu>>
    * @author: Kepass1ove
    * @date: 2023/10/15 19:38
    */

    @GetMapping("/getSonMenus")
    public R<List<Menu>> getSonMenus(Long id){
        log.info("获取id为{}所有的子栏目", id);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getFatherMenu, id);
        queryWrapper.orderByDesc(Menu::getCreateTime);
        List<Menu> menuList = menuService.list(queryWrapper);
        return R.success(menuList);
    }
    
    /**
    * @description: 提交Contact
    * @param: 
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 20:12
    */
    
    @PutMapping("/submit")
    public R<String> submit(@RequestBody Contact contact){
        contact.setCreateTime(LocalDateTime.now());
        contactService.save(contact);
        return R.success("新增成功，我们会尽快回复！");
    }
    
    /**
    * @description: 获得当前menu下的所有成员
    * @param: 
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Member>>
    * @author: Kepass1ove
    * @date: 2023/10/21 15:41
    */
    
    @GetMapping("/getMembersByMenuId")
    public R<List<Member>> getMembersByMenuId(Long menuId){
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getMenuId, menuId);
        queryWrapper.orderByDesc(Member::getUpdateTime);
        List<Member> list = memberService.list(queryWrapper);
        return R.success(list);
    }
    
    
}
