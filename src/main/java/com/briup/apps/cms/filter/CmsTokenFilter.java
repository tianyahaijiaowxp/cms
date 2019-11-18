package com.briup.apps.cms.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-16 14:04
 **/
public class CmsTokenFilter implements Filter {

    @Autowired
    private StringRedisTemplate strTplRedis;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------Token Filter Init------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------TokenFilter doFilter------");
        if(request instanceof HttpServletRequest){
            HttpServletRequest req = (HttpServletRequest) request;
            String token = req.getHeader("token");
            System.out.println("token = " + token);
//            String message = strTplRedis.opsForValue().get(token);
            if(token != null || judge(req)){
                System.out.println("验证通过");
            }else{
                System.out.println("验证失败");
                return;
            }
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("------TokenFilter destroy------");
    }

    private boolean judge(HttpServletRequest request){
//        if("/user/login".equals(request.getServletPath()) || "/user/register".equals(request.getServletPath())
////            || request.getServletPath().contains("swagger") || request.getServletPath().contains("v2")){
////            System.out.println(request.getServletPath());
////            return true;
////        }else{
////            System.out.println(request.getServletPath());
////            return false;
////        }
        System.out.println(request.getServletPath());
        return true;
    }
}
