package cn.stylefeng.guns;

import cn.stylefeng.guns.core.util.JwtTokenUtil;
import cn.stylefeng.roses.core.util.HttpSessionContext;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-10-29 10:47
 **/
public class Test {
//    private JwtTokenUtil jwtTokenUtil = SpringContextHolder.getBean(JwtTokenUtil.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public static void main(String[] args) {
//        System.out.println(MD5Util.encrypt("a"));
//        System.out.println(MD5Util.encrypt("dd"+MD5Util.encrypt("111111")+"5.wz"));
//
//        String s="江苏省常州市金坛市横街西路...";
//        System.out.println(s.substring(0,1));
//        String s1="江苏省常州市金坛市横街西路 奥斯卡好看";
//        System.out.println((s1.substring(0,13)+"...").length());
        char a='d';
        int b=a;
        float c=a;
        double d=a;
        System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n");

    }

    int foo(int n){
        if(n<2){
            return n;
        }else{
            return foo(n-1)+foo(n-2);
        }
    }



}
