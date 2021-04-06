package com.gxaedu.crm.service.login;

import com.gxaedu.crm.pojo.YongHu;
import com.gxaedu.crm.pojo.YongHuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/21
 * Description:
 * Version: V1.0
 */
@Service
public class LoginService {
    @Autowired
    private YongHuMapper yongHuMapper;

    public YongHu selectByYongHu(String yonghuming) {
        return yongHuMapper.selectByYongHu(yonghuming);
    }
}
