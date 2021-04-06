package com.gxaedu.crm.controller.user;

import com.gxaedu.crm.pojo.YongHu;
import com.gxaedu.crm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/21
 * Description:
 * Version: V1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/yonghu", method = RequestMethod.GET)
//    public YongHu selectYongHuById(String id) {
//        return userService.selectYongHuById(id);
//    }

    @RequestMapping(value = "/yonghu", method = RequestMethod.GET)
    public YongHu selectYongHuById(String id, String mima) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("mima", mima);
        System.out.println("map=" + map);
        return userService.selectYongHuById(map);
    }
}
