package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-12-01 13:54
 **/
public class RunnableThread {
    public static void main(String[] args){
        Runnable r1=new ImplRunnable("r1",1000); //Runnable接口必须依托Thread类才能创建线程
        Thread t1=new Thread(r1); //Runnable并不能调用start()方法，因为不是线程，所以要用Thread类加入线程
        Runnable r2=new ImplRunnable("r2",2000);
        Thread t2=new Thread(r2);
        Runnable r3=new ImplRunnable("r3",3000);
        Thread t3=new Thread(r3);

        t1.start(); //启动线程并调用run方法
        t2.start();
        t3.start();
    }
}
class ImplRunnable implements Runnable{ //继承Runnable接口的类
    String name;
    int time;
    public ImplRunnable(String name, int time) { //构造线程名字和休眠时间
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() { //实现Runnable的run方法
//        try{
//            Thread.sleep(time); //所有线程加入休眠
//        }
//        catch(InterruptedException e){
//            e.printStackTrace();
//            System.out.println("线程中断异常");
//        }
        System.out.println("名称为："+name+",线程休眠："+time+"毫秒");
    }
}
