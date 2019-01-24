/**
 * SingletonExample2 class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.singleton;

import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.ThreadSafe;

/**
 * 懒汉模式
 *
 */
@ThreadSafe
public class SingletonExample3 {
    private SingletonExample3() {
    }

    private static SingletonExample3 instance = null;

    private static synchronized SingletonExample3 getInstance(){
        if(instance ==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
