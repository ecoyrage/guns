package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-11-17 14:36
 **/
public class Main {
    public static void test(MyInterface myInterface){
        myInterface.lMethod();
    }

    public static void main(String[] args) {
        test(()-> System.out.println("a"));
    }
}
