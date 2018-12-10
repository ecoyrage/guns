package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-11-17 14:36
 **/
public class Main {
    public static void test(MyInterface myInterface) {
        myInterface.lMethod();
    }

    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
//        test(()-> System.out.println("a"));
        int a = 10 >> 1;
        int b = a++; //a=5
        int c = ++a;
        int d = b * a++;
        System.out.println("a:" + a + "\nb:" + b + "\nc:" + c + "\nd:" + d);
        System.out.println(10>>1);
    }
}
