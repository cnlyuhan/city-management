package com.tju.utils;

import com.tju.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class updateUserUtils {
    public static Long getCurrentId(HttpServletRequest httpServletRequest){
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Long operateUser = (Long) claims.get("id");
        return operateUser;
    }

    public static boolean checkAdmin(HttpServletRequest httpServletRequest){
        Long id = getCurrentId(httpServletRequest);
        if(id == 1713122010360557569L){
            return true;
        }
        else {
            return false;
        }
    }

    public static Long getTestId(){
        return 1713122010360557569L;
    }

}
