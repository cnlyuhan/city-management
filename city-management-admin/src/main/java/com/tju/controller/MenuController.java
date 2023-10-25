package com.tju.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tju.anno.UserStatusCheck;
import com.tju.entity.Menu;
import com.tju.entity.Menu;
import com.tju.entity.R;
import com.tju.service.MenuService;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
    * @description: 新增栏目
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author Kepass1ove
    * @date: 2023/10/15 15:41
    */

    @PostMapping("/save")
    @UserStatusCheck
    public R<String> save(@RequestBody Menu column){
        log.info("新增栏目：", column);
//        column.setFatherMenu((Long) column.getFatherMenu());
        menuService.saveMenu(column);
        return R.success("新增栏目成功！");
    }

    /**
    * @description: 获得最高等级栏目（无父栏目的栏目）
    * @param:
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Menu>>
    * @author Kepass1ove
    * @date: 2023/10/15 15:41
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
    * @description: 根据id获取当前id的menu的所有子menu
    * @param:
    * @return: com.tju.entity.R<java.util.List<com.tju.entity.Menu>>
    * @author: Kepass1ove
    * @date: 2023/10/15 15:57
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

    @DeleteMapping("/delete")
    public R<String> deleteById(long id){
        log.info("要删除的menu的id为：{}",id);
        menuService.delete(id);
        return R.success("删除栏目成功！");
    }

}
