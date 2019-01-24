/**
 * AtomicReferenceExample class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.atomic;

import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class AtomicReferenceExample {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2); //2
        count.compareAndSet(0,1); //no
        count.compareAndSet(1,3); //no
        count.compareAndSet(2,4); //4
        count.compareAndSet(3,4); //no
        System.out.println("count:"+count.get());
    }
}
