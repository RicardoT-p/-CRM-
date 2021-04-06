package com.gxaedu.crm.controller.login;

import com.gxaedu.crm.pojo.YongHu;
import com.gxaedu.crm.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/21
 * Description:
 * Version: V1.0
 */
@RestController
public class LoginController {
    // final的变量在java语法中，允许在构造函数初始化一次
//    private final LoginService loginService;
//
//    @Autowired
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/crm_login",method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody Map<String, String> map, HttpServletRequest request) {
        // 获取用户请求过来的用户名
        // 显示出来的字符串都应该配置为资源文件，比如properties
        String yonghuming = map.get("login");  // login是前端页面固定传递过来的用户名
        /*
           首先验证用户名是否存在，不要像很多实例里面编写的同时验证用户名和密码，这不是企业的操作
           spring的权限认证框架、shiro框架，都是先检查用户名是否存在，再判断密码是否正确
           用户的登录行为没办法通过主键来检查和判断
         */
        YongHu yongHu = loginService.selectByYongHu(yonghuming);
        if(yongHu != null) {
            // 获取用户请求过来的密码(未加密)
            String mima = map.get("pwd");
            String md5MiMa = DigestUtils.md5DigestAsHex(mima.getBytes());
            if(yongHu.getMima().equals(md5MiMa)) {   // 判断用户的密码是否一致
                // 如果判断为true，则代表用户名和密码都正确，允许用户登录
                map.put("Status","200");
                map.put("Text","登录成功!");

                HttpSession session = request.getSession();
                // 如果登录成功，则绑定用户信息到session，由过滤器判断拦截
                // 每一个用户一个session，session是独立的，用户和session是一对一的关系
                session.setAttribute("username", yonghuming);

            }
            else {  // 这里代表用户名存在，但是密码错误
                map.put("Status","10001");
                map.put("Text","登录失败!用户名或者密码错误!");
            }
        }
        else {  // 如果yongHu POJO对为null，则代表用户名不存在
            map.put("Status","10003");
            map.put("Text","登录失败!账户不存在!");
        }
        // 判断用户返回数据是否存在
        // 如果try处理时，没有异常，那么代表认证成功，也就是登录成功
//        map.put("Status","10002");
//        map.put("Text","登录失败!账户已被冻结!");
//        map.put("Status","ok");
//        map.put("Text","登录失败!没有登录权限!");
        return map;
    }

    public static void main(String[] args) {
        // spring md5加密
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }

}
