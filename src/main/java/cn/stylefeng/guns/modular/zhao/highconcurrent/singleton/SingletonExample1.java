/**
 * SingletonExample1 class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.singleton;

import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.NotRecommand;
import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
@NotRecommand
public class SingletonExample1 {

    private SingletonExample1() {
    }

    private static SingletonExample1 instance = null;

    private static SingletonExample1 getInstance(){
        if(instance !=null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
