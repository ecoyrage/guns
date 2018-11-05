package cn.stylefeng.guns.modular.scheduler;

import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.guns.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-11-03 10:23
 **/
@Service
public class MyschedulerService {
    @Autowired
    private IUserService userService;
    @Transactional
    public boolean insertUser(User user){
       return userService.insert(user);
    }
}
