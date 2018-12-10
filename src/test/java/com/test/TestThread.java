package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-12-01 13:50
 **/
public class TestThread {
    public static void main(String[] args){
        Thread t1 = new ExtendThread("t1",1000); //使用上转对象创建线程，并构造线程名字和线程休眠时间
        Thread t2 = new ExtendThread("t2",2000);
        Thread t3 = new ExtendThread("t3",3000);
        t1.start(); //启动线程并调用run方法
        t2.start();
        t3.start();
    }
}

class ExtendThread extends Thread{ //继承Thread的类
    String name;
    int time;
    public ExtendThread(String name, int time) { //构造线程名字和休眠时间
        this.name=name;
        this.time=time;
    }
    public void run(){ //重写Thread类的run方法
        try{
            Thread.sleep(time); //所有线程加入休眠
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("名称为："+name+",线程休眠："+time+"毫秒");
    }
}

