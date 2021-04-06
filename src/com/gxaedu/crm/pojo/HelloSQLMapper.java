package com.gxaedu.crm.pojo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/16
 * Description:
 * Version: V1.0
 */
public interface HelloSQLMapper {
    // java 接口中的定义的方法，都是public的，不可修改
    // java 接口中定义的属性，都是public static final的
    // list代表集合，可以装载一条数据，也可以装载多条数据
    List<HelloSQL> selectUser();

    /* 通过用户传入的id获取指定的一条数据 */
    // http传输中，90%以上的数据都是String
    // json也是String
    HelloSQL selectUserById(String id);
}