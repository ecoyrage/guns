/**
 * SynchronizedYesAndNo6 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

/**
 * @decription 同时访问同步方法和非同步方法
 */
public class SynchronizedYesAndNo6 implements Runnable {

    static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();

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

    public synchronized void method1(){
        System.out.println("我是加锁方法"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public void method2(){
        System.out.println("我是不加锁方法"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
