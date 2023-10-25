package com.tju.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.entity.Menu;
import com.tju.mapper.ColumnMapper;
import com.tju.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<ColumnMapper, Menu> implements MenuService {

}
