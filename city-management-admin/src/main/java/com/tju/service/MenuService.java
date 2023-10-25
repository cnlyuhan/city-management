package com.tju.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tju.entity.Menu;
import com.tju.entity.Menu;

public interface MenuService extends IService<Menu> {
    void delete(long id);

    void saveMenu(Menu column);
}
