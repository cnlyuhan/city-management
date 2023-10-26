package com.tju;

import com.tju.entity.Member;
import com.tju.entity.Menu;
import com.tju.entity.Post;
import com.tju.service.MemberService;
import com.tju.service.MenuService;
import com.tju.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CityManagementAdminApplicationTests {

    @Autowired
    private PostService postService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MenuService menuService;
    @Test
    void contextLoads() {
    }
    
    /**
    * @description: 插入临时测试数据，注意：要将common.MetaObjectHandler中的Long operateUserId = updateUserUtils.getCurrentId(httpServletRequest);注释掉，换成Long testId = updateUserUtils.getTestId();然后metaObject.setValue也要换成testId
    * @param: 
    * @return: void
    * @author: Kepass1ove
    * @date: 2023/10/26 16:34
    */
    
    @Test
    public void insertPostsandMembers(){
        List<Menu> allMenuList = menuService.list();
        for(Menu menu: allMenuList){
            Long fatherMenu = menu.getFatherMenu();
            Integer hasSon = menu.getHasSon();
            Integer memberFlag = menu.getMemberFlag();
            String menuName = menu.getName();
            Long menuId = menu.getId();
            if(hasSon == 1){
                continue;
            }
            if(memberFlag == 0){
                // 插入的是文章
                Post post = new Post();
                post.setPostTitle(menuName + "的标题");
                post.setHtmlContent(menuName + "的文章内容");
                post.setMenuId(menuId);
                post.setImage("imageUrl");
                postService.save(post);
            }
            else {
                // 插入的是成员
                Member member = new Member();
                member.setMenuId(menuId);
                member.setImage("portraitUrl");
                member.setIntro("这是该成员的简介");
                member.setName("张三");
                memberService.save(member);
            }
        }
    }



}
