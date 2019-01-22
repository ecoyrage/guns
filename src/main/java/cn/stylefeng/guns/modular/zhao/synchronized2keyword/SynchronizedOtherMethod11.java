/**
 * SynchronizedOtherMethod11 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

/**
 * 可重入粒度测试：调用本类的其他同步方法
 */
public class SynchronizedOtherMethod11 {

    private synchronized void method1(){
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2(){
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod11 otherMethod11 = new SynchronizedOtherMethod11();
        otherMethod11.method1();
    }
}
