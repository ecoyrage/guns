/**
 * SingletonExample2 class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.singleton;

import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.NotThreadSafe;
import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.ThreadSafe;

/**
 * 懒汉模式 =》volatile+双重检测机制
 *
 */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {
    }

    /**
     *   1、memory = allocate() 分配对象的内存空间
     *   2、ctorInstance() 初始化对象
     *   3、instance = memory  设置instance指向刚才分配的内存
     */


    //volatile+双重检测机制防止指令重排
    private volatile static SingletonExample5 instance = null;

    private static synchronized SingletonExample5 getInstance(){
        //双重检测机制
        if(instance ==null){
            synchronized (SingletonExample5.class) { //同步锁
                if(instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
