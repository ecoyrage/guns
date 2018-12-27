/**
 * SynchronizedObjectCodeBlock2 class
 *
 * @author ZhaoMing
 * @data 2018/12/27
 *
 * 描述：对象锁，代码块形式
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");

        /**
         *
         * 运行结果：
         * 对象锁lock1的代码块形式，线程名字为Thread-0
         * Thread-0lock1运行结束
         * 对象锁lock2的代码块形式，线程名字为Thread-0
         * 对象锁lock1的代码块形式，线程名字为Thread-1
         * Thread-0lock2运行结束
         * Thread-1lock1运行结束
         * 对象锁lock2的代码块形式，线程名字为Thread-1
         * Thread-1lock2运行结束
         * finished
         *
         */
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("对象锁lock1的代码块形式，线程名字为" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1运行结束");
        }

        synchronized (lock2) {
            System.out.println("对象锁lock2的代码块形式，线程名字为" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2运行结束");
        }
    }
}
