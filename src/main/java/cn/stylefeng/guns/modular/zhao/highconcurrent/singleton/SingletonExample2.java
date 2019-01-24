/**
 * SingletonExample2 class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.singleton;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
public class SingletonExample2 {
    private SingletonExample2() {
    }

    private static SingletonExample2 instance = new SingletonExample2();

    private static SingletonExample2 getInstance(){

        return instance;
    }
}
