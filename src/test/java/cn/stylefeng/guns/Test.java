package cn.stylefeng.guns;

import cn.stylefeng.roses.core.util.MD5Util;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-10-29 10:47
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(MD5Util.encrypt("a"));
        System.out.println(MD5Util.encrypt("dd"+MD5Util.encrypt("111111")+"5.wz"));
    }
}
