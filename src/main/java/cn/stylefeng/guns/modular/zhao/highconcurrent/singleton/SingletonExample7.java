/**
 * SingletonExample2 class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.singleton;

/**
 * 枚举模式
 *
 */
public class SingletonExample7 {

    private SingletonExample7() {
    }



    private static SingletonExample7 getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 instance;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            instance = new SingletonExample7();
        }
        public SingletonExample7 getInstance(){
            return instance;
        }

    }
}
