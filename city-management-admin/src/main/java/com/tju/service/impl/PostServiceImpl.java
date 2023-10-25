package com.tju.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.entity.Menu;
import com.tju.entity.Menu;
import com.tju.entity.Post;
import com.tju.entity.PostDto;
import com.tju.mapper.PostMapper;
import com.tju.service.MenuService;
import com.tju.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    @Lazy
    private MenuService menuService;

    @Override
    public PostDto getByIdWithMenuName(Long id) {
        Post p = this.getById(id);
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(p, postDto);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getId, p.getMenuId());
        Menu column = menuService.getOne(queryWrapper);
        postDto.setMenuName(column.getName());
        return postDto;
    }
}
