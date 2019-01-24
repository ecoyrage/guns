/**
 * SynchronizedDifferentMethod7 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

/**
 * @decription 同时访问一个类的不同的普通同步方法
 */
public class SynchronizedDifferentMethod7 implements Runnable {

    static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();

    static SynchronizedDifferentMethod7 instance2 = new SynchronizedDifferentMethod7();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();

        while(t1.isAlive() || t2.isAlive()){ }

        System.out.println("finished");

    }

    @Override
    public void run() {
        if("Thread-0".equalsIgnoreCase(Thread.currentThread().getName())){
            method1();
        }else{
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("我是加锁方法1"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是加锁方法2"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
