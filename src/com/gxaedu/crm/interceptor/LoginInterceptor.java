package com.gxaedu.crm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Tp
 * Date: 2020/02/26
 * Description:
 * Version: V1.0
 */
public class LoginInterceptor   implements HandlerInterceptor {

    public LoginInterceptor() {
        System.out.println("LoginInterceptor构造函数");
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("LoginInterceptor----------preHandle");
        // return代表是否继续执行后面的拦截机制，如果false，则代表放弃后面所有的拦截
        //                                       如果true，则代表继续执行后续的所有拦截
        System.out.println("LoginInterceptor URI=" + httpServletRequest.getRequestURI());   // 相对路径
        System.out.println("LoginInterceptor URL=" + httpServletRequest.getRequestURL());    // 绝对路径
        System.out.println("LoginInterceptor RemoteAddr" + httpServletRequest.getRemoteAddr());  // 用户请求IP地址
        System.out.println("LoginInterceptor LocalAddr" + httpServletRequest.getLocalAddr());    // 用户请求IP地址

        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("username");

        String url = httpServletRequest.getRequestURL().toString();  // 获取用户请求的路径
        /*
        用户级别的拦截器后期会被shiro替代

        判断用户是否成功登陆过
        1.判断用户信息是否在session中
        2.判断用户是否在login.html

        (1)用户名没有登录，在login.html
        (2)用户名没有登录，在login.html之外的页面
        (3)用户名登录成功，在login.html
        (4)用户名登录成功，在login.html之外的页面
         */
        /*if(url.endsWith("/crm_login")) {   // 用户请求登录的接口放行
            // 放行
        }
        else if(obj == null) {  // 用户没有登录
            if(url.endsWith("login.html")) {  // (1)用户名没有登录，在login.html
                // 放行
            }
            else {  // (2)用户名没有登录，在login.html之外的页面
                httpServletResponse.sendRedirect("login.html");  // 转向，也可以叫做重定向
            }
        }
        else {   // 用户登录成功
            if(url.endsWith("login.html")) {  // (3)用户名登录成功，在login.html
                // 当用户登录成功之后，不能回到login.html
                httpServletResponse.sendRedirect("index.html");  // 转向，也可以叫做重定向
            }
            else {  // (4)用户名登录成功，在login.html之外的页面
                // 放行
            }
        }*/

        // Cannot forward after response has been committed 死锁跳转


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("LoginInterceptor------------postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
       // System.out.println("LoginInterceptor------------afterCompletion");
    }
}
