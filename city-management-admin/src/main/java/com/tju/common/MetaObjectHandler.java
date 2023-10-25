package com.tju.common;

import com.tju.utils.updateUserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

// 自定义元数据处理器

@Component
@Slf4j
public class MetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {
    // 插入操作自动填充

    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info(metaObject.toString());
        Long operateUserId = updateUserUtils.getCurrentId(httpServletRequest);
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", operateUserId);
        metaObject.setValue("updateUser", operateUserId);
    }


    // 更新操作自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info(metaObject.toString());
        Long operateUserId = updateUserUtils.getCurrentId(httpServletRequest);
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", operateUserId);
    }
}