package com.gxaedu.crm.service;

import com.gxaedu.crm.pojo.HelloSQL;
import com.gxaedu.crm.pojo.HelloSQLMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/16
 * Description:
 * Version: V1.0
 */
@Service
public class HelloSQLService {   // 为什么并没有使用interface?


    public HelloSQLService() {
        System.out.println("HelloSQLService构造器");
    }

    // 定义interface的目的是为了做第三方API接口扩展
    // 做系统集成，或者被第三方服务商调用的时候，才会需要提供interface
    // 因为这样做的话，可以方便扩展
    // 闭关项目，所有的请求都是来自自己系统平台，那么是不需要定义接口的
    // 动态代理如果在没有需求的情况下使用，会增加服务的负担
    @Resource
    private HelloSQLMapper helloSQLMapper;

    public List<HelloSQL> selectUser() {
        // 企业的标准规范 service调用的mapper方法，那么service中的这个方法和mapper方法同名
        return helloSQLMapper.selectUser();
    }

    /**
     * 基于用户传入的一个id，查询此id对应的一条完整记录
     * @param id   用户传入的id值
     * @return     返回用户传入id所对应的一条完整记录
     */
    public HelloSQL selectUserById(String id) {
        // javadoc 打包 技术文档
        // 企业的标准规范 service调用的mapper方法，那么service中的这个方法和mapper方法同名
        return helloSQLMapper.selectUserById(id);
    }
}
