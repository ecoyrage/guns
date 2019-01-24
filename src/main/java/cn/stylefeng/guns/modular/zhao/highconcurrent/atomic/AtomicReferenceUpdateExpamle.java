/**
 * AtomicReferenceUpdateExpamle class
 *
 * @author ZhaoMing
 * @data 2019/1/24
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.atomic;

import cn.stylefeng.guns.modular.zhao.highconcurrent.annotions.ThreadSafe;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@ThreadSafe
public class AtomicReferenceUpdateExpamle {

    private static AtomicIntegerFieldUpdater<AtomicReferenceUpdateExpamle> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceUpdateExpamle.class,"count");


    public volatile int count = 100;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static AtomicReferenceUpdateExpamle expamle = new AtomicReferenceUpdateExpamle();

    public static void main(String[] args) {
        if(updater.compareAndSet(expamle,100,120)){
            System.out.println("update success1:"+expamle.getCount());
        }
        if(updater.compareAndSet(expamle,100,120)){
            System.out.println("update success2:"+expamle.getCount());
        }else{
            System.out.println("update failed:"+expamle.getCount());
        }

    }
}
