/**
 * SynchronizedStaticAndNormal8 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

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

    public synchronized static void method1(){
        System.out.println("我是静态加锁方法1"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是非静态加锁方法2"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
