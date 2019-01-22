/**
 * Testmain2 class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class Testmain2 implements Runnable {

    public static void main(String[] args) {

    }



    @Override
    public void run() {

        System.out.println("Testmain2当前线程"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestSynchrozied b = new TestSynchrozied();
        b.method2();
        TestSynchrozied.metod();
        System.out.println("Testmain2当前线程结束"+Thread.currentThread().getName());
    }
}
