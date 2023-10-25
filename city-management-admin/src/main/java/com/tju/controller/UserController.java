package com.tju.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tju.anno.UserAuthCheck;
import com.tju.entity.R;
import com.tju.entity.User;
import com.tju.service.UserService;
import com.tju.utils.JwtUtils;
import com.tju.utils.updateUserUtils;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;


    /**
    * @description: 用户登录
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:04
    */

    @PostMapping("/login")
    @ApiOperation(value = "登录功能", notes = "返回值中的data为jwt字符串")
    public R<String> login(@RequestBody User user){
        log.info("用户登录：{}", user);
        String pwd = user.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User user_return = userService.getOne(queryWrapper);
        if(user_return == null){
            return R.error("没有此用户！");
        }
        if(!user_return.getPassword().equals(pwd)){
            return R.error("密码错误！");
        }
        if(user_return.getStatus() == 0){
            return R.error("用户已被禁用");
        }

        // 登录成功
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user_return.getId());
        claims.put("username", user_return.getUsername());
        String jwt = JwtUtils.generateJwt(claims);
        return R.success(jwt);
    }

    /**
    * @description: 新增员工
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:03
    */

    @UserAuthCheck
    @PostMapping("/save")
    @ApiOperation(value = "新增员工功能")
    public R<String> save(@RequestBody User user){
        log.info("新增员工，{}", user);
        userService.save(user);
        return R.success("新增用户成功！");
    }

    /**
    * @description: 更新员工状态
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:03
    */

    @UserAuthCheck
    @PostMapping("/updateStatus")
    public R<String> updateStatus(@RequestBody User user){
        log.info("更新员工状态，状态为：{}", user.getStatus());
        userService.updateById(user);
        return R.success("更新用户状态成功！");

    }

    /**
    * @description: 更新员工权限
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:02
    */

    @UserAuthCheck
    @PostMapping("/updateAuth")
    public R<String> updateAuth(@RequestBody User user){
        log.info("更新员工权限，权限为：{}", user.getAuth());
        userService.updateById(user);
        return R.success("更新用户权限成功！");
    }

    /**
    * @description: 删除员工
    * @param:
    * @return: com.tju.entity.R<java.lang.String>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:02
    */

    @UserAuthCheck
    @DeleteMapping("/delete")
    public R<String> deleteById(Long id){
        log.info("删除员工，id为：{}", id);
        userService.removeById(id);
        return R.success("删除用户成功！");
    }

    /**
    * @description: 分页查询用户
    * @param:
    * @return: com.tju.entity.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
    * @author: Kepass1ove
    * @date: 2023/10/15 17:02
    */

    @GetMapping("/page")
    public R<Page> page(@ApiParam(required = true) int page,
                        @ApiParam(required = true) int pageSize, @ApiParam(required = false) String username){
        Page<User> userPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(username), User::getUsername, username);
        queryWrapper.orderByDesc(User::getCreateTime);
        userService.page(userPage, queryWrapper);
        return R.success(userPage);
    }


}
