/**
 * SynchronizedClassClass5 class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();



    @Override
    public void run() {
        synchronized (SynchronizedClassClass5.class){
            System.out.println("类锁第二种形式synchronized(*.class)"+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"执行结束");

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();

        while(t1.isAlive() || t2.isAlive()){ }

        System.out.println("finished");
    }
}
