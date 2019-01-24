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
 * 双重检测机制（指令重排会导致线程不安全）
 *
 */
@NotThreadSafe
public class SingletonExample4 {
    private SingletonExample4() {
    }

    /**
     *   1、memory = allocate() 分配对象的内存空间
     *   2、ctorInstance() 初始化对象
     *   3、instance = memory  设置instance指向刚才分配的内存
     */


    private static SingletonExample4 instance = null;

    private static synchronized SingletonExample4 getInstance(){
        //双重检测机制
        if(instance ==null){
            synchronized (SingletonExample4.class) { //同步锁
                if(instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
