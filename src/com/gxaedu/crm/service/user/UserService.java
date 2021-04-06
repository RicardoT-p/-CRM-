package com.gxaedu.crm.service.user;

import com.gxaedu.crm.pojo.YongHu;
import com.gxaedu.crm.pojo.YongHuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/21
 * Description:
 * Version: V1.0
 */
@Service
public class UserService {  // userService
    @Autowired
    private YongHuMapper yongHuMapper;

//    public YongHu selectYongHuById(String id) {
//        return yongHuMapper.selectByPrimaryKey(id);
//    }

    public YongHu selectYongHuById(Map<String, String> map) {
        return yongHuMapper.selectByPrimaryKey(map);
    }
}
