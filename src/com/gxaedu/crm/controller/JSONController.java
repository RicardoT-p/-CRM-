package com.gxaedu.crm.controller;

import com.gxaedu.crm.pojo.HelloSQL;
import com.gxaedu.crm.service.HelloSQLService;

import com.gxaedu.crm.vo.MyValueObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/16
 * Description:
 * Version: V1.0
 */
@Controller
public class JSONController {

    public JSONController() {
        System.out.println("JSONController构造器");
    }

    @Resource
    private HelloSQLService helloSQLService;

    @RequestMapping(value = "/test01", method = {RequestMethod.GET})
    @ResponseBody
    public List<HelloSQL> login() {
        return helloSQLService.selectUser();
    }

    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    @ResponseBody
    public HelloSQL selectUserById(@RequestParam(name="id") String id) {
        System.out.println("selectUserById id=" + id);
        return helloSQLService.selectUserById(id);
    }

    @RequestMapping(value = "/test03", method = RequestMethod.GET)
    @ResponseBody
    public Map select01() {
        Map map = new HashMap();
        map.put("name01","gxa01");
        map.put("name02","gxa02");
        map.put("name03","gxa03");
        map.put("name04","gxa04");
        map.put("name05","gxa05");
        // {"name04":"gxa04","name03":"gxa03","name02":"gxa02","name01":"gxa01","name05":"gxa05"}
        // set
        return map;
    }

    @RequestMapping(value = "/test04", method = RequestMethod.GET)
    @ResponseBody
    public Set select02() {
        Set set = new HashSet();
        set.add("gxa01");
        set.add("gxa02");
        set.add("gxa03");
        // {"name04":"gxa04","name03":"gxa03","name02":"gxa02","name01":"gxa01","name05":"gxa05"}
        // set
        return set;
    }

    @RequestMapping(value = "/test05", method = RequestMethod.GET)
    @ResponseBody
    public HelloSQL[] select03() {
        // 反射处理
        HelloSQL[] helloSQLArrray = new HelloSQL[3];
        HelloSQL helloSQL = new HelloSQL();
        helloSQL.setUsername("gxa01");
        helloSQLArrray[0] = helloSQL;

        helloSQL = new HelloSQL();
        helloSQL.setUsername("gxa02");
        helloSQLArrray[1] = helloSQL;

        helloSQL = new HelloSQL();
        helloSQL.setUsername("gxa03");
        helloSQLArrray[2] = helloSQL;

        return helloSQLArrray;
    }

    @RequestMapping(value = "/test06", method = RequestMethod.GET)
    @ResponseBody
    public MyValueObject select04() {
        MyValueObject myValueObject = new MyValueObject();
        myValueObject.setMyid(100);
        myValueObject.setHelloSQLList(helloSQLService.selectUser());
        return myValueObject;
    }
    /*
    {"myid":100,
    "helloSQLList":
        [
            {"id":1,"username":"thinknovo","password":"123456"},
            {"id":2,"username":"gxa","password":"654321"}
        ]
     }
     */
}