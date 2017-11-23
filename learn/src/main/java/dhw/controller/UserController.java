package dhw.controller;

import dhw.bean.User;
import dhw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/user")
    public String user(){
        User user = userMapper.getUserByName("测试");
        return user.getName()+"---------------"+user.getAge();
    }
}
