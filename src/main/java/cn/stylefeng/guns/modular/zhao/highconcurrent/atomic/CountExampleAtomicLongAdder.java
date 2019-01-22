/**
 * CountExampleThreadSafe class
 *
 * @author ZhaoMing
 * @data 2019/1/22
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
public class CountExampleAtomicLongAdder {

    //请求总数
    private static int clientTotal = 1000;

    //同时并发执行线程数
    private static int threadTotal = 200;


    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);


        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:"+count);


    }

    private static void add(){
//        count++;

//        count.incrementAndGet();

        count.increment();
    }
}
