package com.tju.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tju.anno.UserStatusCheck;
import com.tju.entity.Member;
import com.tju.entity.R;
import com.tju.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @description: TODO
* @author Kepass1ove
* @date 2023/10/21 9:53
* @version 1.0
*/

@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
    * @description: 新增成员
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/21 10:24
    */

    @UserStatusCheck
    @PutMapping("/save")
    public R<String> save(@RequestBody Member member){
        log.info("新增成员：{}", member);
        memberService.save(member);
        return R.success("新增成员成功！");
    }

    /**
    * @description: 根据menuId取得当前menu下所有成员
    * @param:
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Member>>
    * @author: Kepass1ove
    * @date: 2023/10/21 10:25
    */

    @GetMapping("/getMembersByMenuId")
    public R<List<Member>> getMembersByMenuId(Long menuId){
        log.info("查询menuId：{}下所有的成员", menuId);
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getMenuId, menuId);
        queryWrapper.orderByDesc(Member::getUpdateTime);
        List<Member> list = memberService.list(queryWrapper);
        return R.success(list);
    }

    /**
    * @description: 更新成员信息
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/21 10:26
    */
    @UserStatusCheck
    @PutMapping
    public R<String> update(@RequestBody Member member){
        log.info("更新成员信息：{}", member);
        memberService.updateById(member);
        return R.success("成员信息更新成功！");
    }

    /**
    * @description: 根据成员id查询成员信息
    * @param:
    * @return: com.tju.entity.R<com.tju.entity.Member>
    * @author: Kepass1ove
    * @date: 2023/10/21 10:28
    */

    @GetMapping("/getById")
    public R<Member> getById(Long id){
        log.info("要查询的成员的id为：{}", id);
        Member member = memberService.getById(id);
        return R.success(member);
    }

    @UserStatusCheck
    @DeleteMapping("/delete")
    public R<String> deleteById(Long id){
        log.info("要删除的成员id为：{}", id);
        memberService.removeById(id);
        return R.success("成员信息删除成功！");
    }




}
