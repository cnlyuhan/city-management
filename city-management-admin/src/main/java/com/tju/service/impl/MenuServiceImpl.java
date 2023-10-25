package com.tju.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.common.CustomException;
import com.tju.entity.Member;
import com.tju.entity.Menu;
import com.tju.entity.Menu;
import com.tju.entity.Post;
import com.tju.mapper.ColumnMapper;
import com.tju.service.MemberService;
import com.tju.service.MenuService;
import com.tju.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<ColumnMapper, Menu> implements MenuService {

    @Autowired
    private PostService postService;


    @Autowired
    private MemberService memberService;

    /**
    * @description: 删除menu,id为menu的id
    * @param:
    * @return: void
    * @author: Kepass1ove
    * @date: 2023/10/21 11:37
    */

    @Override
    public void delete(long id) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        Menu menu = this.getById(id);
        int memberFlag = menu.getMemberFlag();
        int hasSon = menu.getHasSon();
        Long fatherMenu = menu.getFatherMenu();
        // 判断是否有子栏目
        if(hasSon == 1){
            throw new CustomException("该栏目下有子栏目，无法删除！");
        }
        // 判断里面装的是member还是post
        if(memberFlag == 0){
            // 如果装的是post
            LambdaQueryWrapper<Post> postLambdaQueryWrapper = new LambdaQueryWrapper<>();
            postLambdaQueryWrapper.eq(Post::getMenuId, id);
            int count = postService.count(postLambdaQueryWrapper);
            if(count > 0){
                // menu下有文章，无法删除
                throw new CustomException("该栏目下有文章，无法删除！");
            }
            else{
                // 没有文章，可以删除
                super.removeById(id);

            }
        }
        else{
            // 里面装的是member
            LambdaQueryWrapper<Member> memberLambdaQueryWrapper = new LambdaQueryWrapper<>();
            memberLambdaQueryWrapper.eq(Member::getMenuId, id);
            int count = memberService.count(memberLambdaQueryWrapper);
            if(count > 0){
                throw new CustomException("该栏目下有成员，无法删除！");
            }
            else{
                // 没有文章，可以删除
                super.removeById(id);
            }
        }

        // 删除完之后，如果父栏目没有子栏目了，把has_son置为0
        LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.eq(Menu::getFatherMenu, fatherMenu);
        int count = this.count(menuLambdaQueryWrapper);
        if(count == 0){
            Menu fatherMenuEntity = this.getById(fatherMenu);
            fatherMenuEntity.setHasSon(0);
            this.updateById(fatherMenuEntity);
        }
    }

    @Override
    public void saveMenu(Menu column) {
        Long fatherMenu = column.getFatherMenu();
        if (fatherMenu == 0){
            // 如果是最高级栏目，就直接保存
            this.save(column);
        }
        else{
            // 把该栏目的父栏目的has_son更新为1
            Menu fatherMenuEntity = this.getById(fatherMenu);
            fatherMenuEntity.setHasSon(1);
            this.updateById(fatherMenuEntity);
        }
    }
}
