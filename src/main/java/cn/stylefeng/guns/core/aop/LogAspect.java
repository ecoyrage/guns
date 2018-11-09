package cn.stylefeng.guns.core.aop;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-10-26 10:22
 **/
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.modular.system.model.Notice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by wuwf on 17/4/27.
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * cn.stylefeng.guns.modular.system.controller.BlackboardController.*(..))")
    public void webLog(){}

    @Pointcut("execution(public * cn.stylefeng.guns.modular.system.controller.DictController.deptUpdate(..))")
    public void deptUpdate(){}

    @Before("webLog()||deptUpdate()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()||deptUpdate()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }
//
//    //后置异常通知
//    @AfterThrowing("webLog()")
//    public void throwss(JoinPoint jp){
//        System.out.println("方法异常时执行.....");
//    }
//
//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("webLog()")
//    public void after(JoinPoint jp){
//        System.out.println("方法最后执行.....");
//    }

    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("webLog()")
//    public Object arroundwebLog(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Around("deptUpdate()")
    public Object arroundDeptPointcut(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {
            //获取拦截方法的参数
            String className = pjp.getTarget().getClass().getName();
            Object[] params = pjp.getArgs();
            Object o =  pjp.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}