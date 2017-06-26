package com.luohaibo.Interceptor;

import com.luohaibo.controller.MyFirstController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luohaibo on 2017/6/16.
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {

    private static final Logger vrlogger = LoggerFactory.getLogger(CommonInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("+++++++进入了拦截器 + 可以用来拦截签名");

        vrlogger.info("------进入了拦截器 + 可以用来拦截签名");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
