/**
 * CountExampleThreadSafe class
 *
 * @author ZhaoMing
 * @data 2019/1/22
 */
package cn.stylefeng.guns.modular.zhao.highconcurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class CountExampleThreadSafe {

    //请求总数
    private static int clientTotal = 1000;

    //同时并发执行线程数
    private static int threadTotal = 200;


    public static AtomicInteger count = new AtomicInteger(0);

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

        count.incrementAndGet();
    }
}
