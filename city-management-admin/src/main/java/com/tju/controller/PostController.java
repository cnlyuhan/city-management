package com.tju.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tju.anno.UserStatusCheck;
import com.tju.entity.*;
import com.tju.service.MenuService;
import com.tju.service.PostService;
import com.tju.utils.updateUserUtils;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private MenuService menuService;


    /**
    * @description: 新增文章
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:12
    */

    @PostMapping("/save")
    @UserStatusCheck
    public R<String> save(@RequestBody Post post){
        log.info("新增文章，", post);
        postService.save(post);
        return R.success("新增文章成功！");
    }
    /**
    * @description: 根据id获取一篇文章
    * @param:
    * @return: com.tju.entity.R<com.tju.entity.PostDto>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:13
    */

    @GetMapping("/getPost")
    public R<PostDto> getPostById(Long id){
        log.info("请求的文章id是：{}", id);
        PostDto postDto = postService.getByIdWithMenuName(id);
        return R.success(postDto);
    }


    /**
    * @description: 查询当前栏目下的所有文章
    * @param:
    * @return: com.tju.entity.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:11
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
    * @description: 根据id删除文章
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:13
    */

    @UserStatusCheck
    @DeleteMapping("/delete")
    public R<String> delete(Long id){
        log.info("删除的id为：{}", id);
        postService.removeById(id);
        return R.success("文章删除成功！");
    }

    /**
    * @description: 更新一篇文章
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:14
    */

    @UserStatusCheck
    @PutMapping
    public R<String> update(@RequestBody Post post){
        log.info("修改文章：{}", post);
        postService.updateById(post);
        return R.success("文章内容修改成功！");
    }


}
