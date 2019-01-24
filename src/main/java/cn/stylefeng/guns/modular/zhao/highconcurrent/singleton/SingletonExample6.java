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
public class SingletonExample6 {
    private SingletonExample6() {
    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    private static SingletonExample6 getInstance(){

        return instance;
    }
}
