package com.gxaedu.crm.controller;

import com.gxaedu.crm.pojo.HelloSQL;
import com.gxaedu.crm.service.HelloSQLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/16
 * Description:
 * Version: V1.0
 */
@Controller
public class HelloSQLController {

    public HelloSQLController() {
        System.out.println("HelloSQLController构造器");
    }

    @Resource
    private HelloSQLService helloSQLService;
    // @RequestMapping代表请求规则  value属性代表请求路径  method属性代表请求的模式
    // 用户在浏览器中输入一个网址，然后点击回车跳转，这个动作是http协议中的get请求
    // Deploy took 13,517 milliseconds这个提示代表tomcat已经完整启动
    /*
        1.用户输入一个正确的路径请求，回车
        2.spring mvc会匹配对应的RequestMapping中value
        3.如果匹配成功，调用RequestMapping对应方法中的代码(helloSQLService.selectUser();)
        4.调用service中的对应方法(public List<HelloSQL> selectUser())
        5.调用mapper接口中的方法(helloSQLMapper.selectUser();)
        6.mapper接口通过动态代理调用mapper.xml文件中的id对应的SQL语句
        7.mysql
        接着会查询数据库，数据库查询成功，会返回数据以上述的流程反转回去
     */
    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
//    @GetMapping()
    @ResponseBody
    public List<HelloSQL> login() {
        return helloSQLService.selectUser();
    }

    @RequestMapping(value = "/loginasdasd", method = RequestMethod.GET)
    @ResponseBody
    public List<HelloSQL> login(@RequestParam(name="username") String username,
                                @RequestParam(name="password") String password) {
        // http://localhost:8080/login?username=thinknovo&password=123456
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return helloSQLService.selectUser();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public List<HelloSQL> login(@RequestParam(name="id") String id) {
//        // http://localhost:8080/login?username=thinknovo&password=123456
//        System.out.println("id=" + id);
//        return helloSQLService.selectUser();
//    }

    @RequestMapping(value = "/onlyuser", method = RequestMethod.GET)
    @ResponseBody
    public HelloSQL selectUserById(@RequestParam(name="id") String id) {
        System.out.println("selectUserById id=" + id);
        return helloSQLService.selectUserById(id);
        /*
            用户请求->Controller->Service->interfaceMapper->MapperXML->DB
               结果<-           <-       <-               <-         <-
         */
    }
}

//  ibatis-apache   mybatis-google
// Exception 异常
        /*
        org.springframework.web.util.NestedServletException:
            Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException:
                nested exception is org.apache.ibatis.exceptions.TooManyResultsException:
                    Expected one result (or null) to be returned by selectOne(), but found: 2
         */

