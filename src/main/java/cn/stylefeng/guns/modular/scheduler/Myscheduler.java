package cn.stylefeng.guns.modular.scheduler;

import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.guns.modular.system.service.IUserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;


/**
 * @program: guns
 * @description: 定时任务
 * @author: Chenchao
 * @create: 2018-11-03 09:07
 **/
@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "wz", name = "dev", havingValue = "false")
public class Myscheduler{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;


    @Scheduled(cron = "0/5 * * * * ?") // 每5s执行一次
    public void testSchedule() {
        logger.info("定时测试");
//        User user=new User();
//        user.setName("测试");
//        return user;
    }
}
