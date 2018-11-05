//package cn.stylefeng.guns.core.aop;
//
//import cn.hutool.core.date.DateUtil;
//import cn.stylefeng.guns.modular.scheduler.MyschedulerService;
//import cn.stylefeng.guns.modular.system.model.User;
//import cn.stylefeng.guns.modular.system.service.IUserService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * @program: guns
// * @description:
// * @author: Chenchao
// * @create: 2018-11-03 09:37
// **/
//@Aspect
//@Component
//public class ScheduledAop {
//    @Autowired
//    private IUserService userService;
//    @Autowired
//    private MyschedulerService myschedulerService;
//
//
//    @Pointcut(value = "@annotation(org.springframework.scheduling.annotation.Scheduled)")
//    private void cutScheduled() {
//    }
//
////    @Before("cutScheduled()")
////    public void deBefore(JoinPoint joinPoint) throws Throwable {
////        // 接收到请求，记录请求内容
////        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = attributes.getRequest();
////        // 记录下请求内容
////        System.out.println("URL : " + request.getRequestURL().toString());
////        System.out.println("HTTP_METHOD : " + request.getMethod());
////        System.out.println("IP : " + request.getRemoteAddr());
////        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
////
////    }
//
////    @AfterReturning(returning = "ret", pointcut = "cutScheduled()")
////    public void doAfterReturning(Object ret) throws Throwable {
////        // 处理完请求，返回内容
////        System.out.println("方法的返回值 : " + ret);
////    }
//
//    @Around("cutScheduled()")
//    public Object arroundDeptPointcut(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            //获取拦截方法的参数
//            String className = pjp.getTarget().getClass().getName();
//            Object[] params = pjp.getArgs();
//
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            User user=(User) o;
//            user.setBirthday(DateUtil.parse("1990-10-31"));
//            System.out.println("方法的返回值 : " + user);
//            boolean b=myschedulerService.insertUser(user);
//            int i=1/0;
//            return user;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
////    @AfterReturning(returning = "ret", pointcut = "cutScheduled()")
////    public boolean doAfterReturning(Object ret) throws Throwable {
////        // 处理完请求，返回内容
////        User user=(User) ret;
////        user.setBirthday(DateUtil.parse("1990-10-31"));
////        System.out.println("方法的返回值 : " + ret);
////        boolean b=userService.insert(user);
////        return b;
////    }
//}
