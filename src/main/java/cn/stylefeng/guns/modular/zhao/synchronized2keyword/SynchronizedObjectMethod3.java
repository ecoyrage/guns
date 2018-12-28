/**
 * SynchronizedObjectMethod3 class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 * 描述：对象锁
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class SynchronizedObjectMethod3 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    static int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");

    }

    @Override
    public void run() {
        method();

    }
    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰符形式，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
