package cn.jhezmann.controller;

import cn.jhezmann.beans.User;
import cn.jhezmann.service.BaseService;
import cn.jhezmann.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    BaseService<User> userBaseService;

    public MainController() {
    }

    public User getUser(Integer id, String name){

        User user = userBaseService.get(id,name);
        return user;
    }
}
