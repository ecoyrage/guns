/**
 * DisappearRequest1 class
 *
 * @author ZhaoMing
 * @data 2018/12/27
 * 描述：多线程不加锁的情形
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class DisappearRequest1 implements Runnable {
    static DisappearRequest1 instance = new DisappearRequest1();
    static DisappearRequest1 instance2 = new DisappearRequest1();


    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);

        /**
         * 预期结果：200000
         * 实际结果：<200000
         */
    }

    @Override
    public  synchronized void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
            /**
             *   ++ 操作解读：
             *   1、读取i的值
             *   2、将i值加一
             *   3、将i值写入到内存中
             *
             */
        }
    }
}
