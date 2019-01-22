/**
 * Testmain class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class Testmain implements Runnable {

    static Testmain instance = new Testmain();



    public static void main(String[] args) {
        Thread t1 = new Thread(new Testmain());
        Thread t2 = new Thread(new Testmain2());
        t1.start();
        t2.start();
    }

    public void method(){

    }

    @Override
    public void run() {
        System.out.println("Testmain当前线程"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TestSynchrozied a = new TestSynchrozied();
        TestSynchrozied.metod();
        System.out.println("Testmain当前线程结束"+Thread.currentThread().getName());
    }

}
