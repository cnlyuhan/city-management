package com.tju.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tju.entity.Post;
import com.tju.entity.PostDto;

public interface PostService extends IService<Post> {

    public PostDto getByIdWithMenuName(Long id);

}
