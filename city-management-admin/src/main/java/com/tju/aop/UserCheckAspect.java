package com.tju.aop;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tju.entity.R;
import com.tju.entity.User;
import com.tju.service.UserService;
import com.tju.utils.updateUserUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.Kernel;
import java.util.Objects;

/**
* @description: 判断用户权限
* @author Kepass1ove
* @date 2023/10/15 16:31
* @version 1.0
*/

@Slf4j
@Component
@Aspect
public class UserCheckAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @Around("@annotation(com.tju.anno.UserAuthCheck)")
    public Object userAuthCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Long id = updateUserUtils.getCurrentId(httpServletRequest);
        User user = userService.getById(id);
        Integer auth = Integer.valueOf(user.getAuth());
        Integer status = user.getStatus();
        if(auth == 0 || status == 0){
            R error = R.error("您无权执行此操作！");
//            return JSONObject.toJSONString(error);
            return error;
        }
        return joinPoint.proceed();
    }

    @Around("@annotation(com.tju.anno.UserStatusCheck)")
    public Object userStatusCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Long id = updateUserUtils.getCurrentId(httpServletRequest);
        User user = userService.getById(id);
        Integer status = user.getStatus();
        if(status == 0){
            R error = R.error("您账户已经被禁用！");
//            return JSONObject.toJSONString(error);
            return error;
        }
        return joinPoint.proceed();
    }

}
