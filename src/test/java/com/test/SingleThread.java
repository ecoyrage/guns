package com.test;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-12-01 13:49
 **/
public class SingleThread {
    public static void main(String[] args){
        Thread thread = Thread.currentThread(); //获取当前运行的线程对象
        thread.setName("单线程"); //线程重命名
        System.out.println(thread.getName()+"正在运行");
        for(int i=0;i<10;i++){
            System.out.println("线程正在休眠："+i);
            try {
                thread.sleep(1000); //线程休眠，延迟一秒
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("线程出错");
            }
        }
    }
}
