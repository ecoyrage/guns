/**
 * SynchronizedException9 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

/**
 * 描述：方法抛出异常后，会释放锁。展示不抛出异常前和抛出异常后对比：一旦抛出异常，第二个线程会立刻进入同步方法，表示锁释放
 */
public class SynchronizedException9 implements Runnable{

    static SynchronizedException9 instance = new SynchronizedException9();

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
        System.out.println("我是静态加锁方法1"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName()+"运行结束");
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
