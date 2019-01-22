/**
 * TestSynchrozied class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

public class TestSynchrozied {

    static int count = 0;

    public static synchronized void metod(){
        count++;
        System.out.println("计数"+count);
    }

    public void method2(){
        System.out.println("普通方法");
    }
}
