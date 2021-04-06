package com.gxaedu.crm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/22
 * Description:
 * Version: V1.0
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    /*
   urlPatterns = "/*"  代表匹配任意的请求
   一个合法的filter，必须实现JavaEE中的Filter接口
   Filter接口有三个抽象方法 init  doFilter destory
   运行机制或者规则，可以理解为制度
   运行机制只能死记硬背，没有捷径
    */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // init是初始化的方法，在web服务器启动时被系统调用
        System.out.println("LoginFilter-----------init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 用户每一次请求都会被调用
        // 因为Filter中的doFilter方法拦截每一个用户请求，要注意的是：浏览器加载的所有静态资源，每一个静态资源都是一个请求
        // 因为Filter是原生的对象，所以它会被Spring优先执行
        System.out.println("LoginFilter-----------doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        System.out.println("URI=" + httpServletRequest.getRequestURI());   // 相对路径
        System.out.println("URL=" + httpServletRequest.getRequestURL());    // 绝对路径
        System.out.println("RemoteAddr" + httpServletRequest.getRemoteAddr());  // 用户请求IP地址
        System.out.println("LocalAddr" + httpServletRequest.getLocalAddr());    // 用户请求IP地址
        // 黑名单处理-白名单处理

        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("username");
        /*
         如果用户没有登录过或登录失败，那么Controller就没有封装用户信息到session，
         所以，session直接获取username会返回一个null
          */
        String url = httpServletRequest.getRequestURL().toString();
        if(url.endsWith("login.html") ||
                url.endsWith(".js") ||
                url.endsWith(".css") ||
                url.endsWith(".png") ||
                url.endsWith(".jpg") ||
                url.endsWith(".gif") ||
                url.endsWith(".ico") ||
                url.endsWith("/crm_login")) {
            // 判断用户是否进入的登录页面，如果是登录页面，那么不检查session数据，直接放行
            filterChain.doFilter(servletRequest, servletResponse);  // 用户的请求被放行
        }
        else if(obj == null) {  // obj如果登录null，代表用户没有登录或者登录没成功
            // 如果用户没有登录，那么不允许用户访问登录界面以外的任何页面
            httpServletResponse.sendRedirect("login.html");  // 转向，也可以叫做重定向
            // 转向的页面login.html也算是一个请求，如果不过滤掉，那么用户请求将死锁
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);  // 用户的请求被放行
            // 冗余代码，自行优化
            // 盗链
        }


    }

    @Override
    public void destroy() {
        // destroy是销毁方法，在web服务器关闭时被系统调用
        System.out.println("LoginFilter-----------destroy");
    }
}
