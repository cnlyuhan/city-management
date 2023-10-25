package com.tju.controller;

import com.tju.entity.R;
import com.tju.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
* @description: TODO
* @author Kepass1ove
* @date 2023/10/20 23:50
* @version 1.0
*/


@RequestMapping("/common")
@RestController
@Slf4j
public class CommonController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    public R<String> upload(MultipartFile image) throws IOException {
        log.info("文件上传，{}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功，url为：{}", url);
        return R.success(url);
    }

}
