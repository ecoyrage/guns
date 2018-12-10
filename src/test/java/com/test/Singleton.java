package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-12-01 13:23
 **/
public class Singleton {
    private Singleton(){
    }
    private static volatile Singleton instance = null;
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

