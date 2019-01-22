/**
 * SynchronizedRecursion10 class
 *
 * @author ZhaoMing
 * @data 2019/1/21
 */
package cn.stylefeng.guns.modular.zhao.synchronized2keyword;

/**
 * 描述：可重入粒度测试：递归调用本方法
 */
public class SynchronizedRecursion10 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion10 recursion10 = new SynchronizedRecursion10();
        recursion10.method1();

    }

    private synchronized void method1(){
        System.out.println("这是method1,a="+a);
        if(a == 0){
            a++;
            method1();
        }
    }


}
