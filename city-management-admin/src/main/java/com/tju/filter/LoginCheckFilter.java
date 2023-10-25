package com.tju.filter;

import com.alibaba.fastjson.JSONObject;
import com.tju.entity.R;
import com.tju.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Slf4j
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 1 获取请求url
        String url = req.getRequestURI().toString();

        // 2判断是否含有login，若有，则放行
        if(url.contains("login") || url.contains("swagger") || url.contains("v2/api-docs") || url.contains("front") || url.contains("doc")){
            log.info("登录放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取jwt
        String jwt = req.getHeader("token");

        // 判断jwt令牌
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            R<String> r = R.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(r);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5 解析token 如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // 解析失败
            e.printStackTrace();
            log.info("解析令牌失败");
            R<String> error = R.error("NOT_LOGIN");
            // 手动把error变为json（注意RestController会把result自动变为json，但这里不是controller）
            String notLogin = JSONObject.toJSONString(error);
            // 往response写入未登录的信息
            resp.getWriter().write(notLogin);
            return;
        }

        // 6 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
