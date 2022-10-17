package com.oct2022.oct2022.configuration;


import com.oct2022.oct2022.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String currentUrl = request.getRequestURL().toString();
            System.out.println(currentUrl);

            if(request.getMethod().equals("OPTIONS")){
                return true;
            }

            if(currentUrl.contains("login") || currentUrl.contains("register") || currentUrl.contains("Image")){
                System.out.println("in url contains login now");
                return true;
            }

            System.out.println("not in url contains login");
            String token = request.getHeader("token");
            String user_id = request.getHeader("user_id");

            if(token == null || token.isEmpty()){
                throw new Exception("token is empty");
            }

            if(user_id == null || user_id.isEmpty()){
                throw new Exception("id is empty");
            }

            userService.isTokenExpired(token);

            if(userService.validateToken(Integer.parseInt(user_id), token)){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            throw new CustomException(e.getMessage());
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("testing post handle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("after completion");
    }

}

