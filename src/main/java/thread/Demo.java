package thread;

import jodd.util.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    volatile int a = 1;
    volatile int b = 1;

    public void add() {
        System.out.println("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
    }

    public void compare() {
        System.out.println("compare start");
        for (int i = 0; i < 10000; i++) {
            // a始终等于b吗？
            if (a < b) {
                System.out.println("a:{" + a + "},b:{" + b + "},{" + (a > b) + "}");
                // 最后的a>b应该始终是false吗？
            }
        }
        System.out.println("compare done");
    }

    public static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void test1(){
        // 使用一个计数器跟踪完成的任务数
        AtomicInteger atomicInteger = new AtomicInteger();
        // 创建一个具有2个核心线程、5个最大线程，使用容量为10的ArrayBlockingQueue阻塞队列作为工作队列的线程池，使用默认的AbortPolicy拒绝策略
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().withNameFormat("demo-threadpool-%d").get(),
                new ThreadPoolExecutor.AbortPolicy());

        System.out.println("start...");
        printStats(threadPool);

        // 每隔1秒提交一次，一共提交20次任务
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = atomicInteger.incrementAndGet();
            try {
                threadPool.submit(() -> {
                    log.info("{} started", id);
                    // 每个任务耗时10秒
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception ex) {
                // 提交出现异常的话，打印出错信息并为计数器减一
                log.error("error submitting task {}", id, ex);
                atomicInteger.decrementAndGet();
            }
        });


        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void oom1() throws InterruptedException {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        printStats(threadPool);//打印线程池的信息，稍后我会解释这段代码
        for (int i = 0; i < 1000_000_000; i++) {
            threadPool.execute(() -> {
                String payload = IntStream.rangeClosed(1, 1000_000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                }
                log.info(payload);
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    public void test3(){//创建定长线程池，可执行周期性的任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i <3; i++) {
            final int index = i;
            //scheduleWithFixedDelay 固定的延迟时间执行任务； scheduleAtFixedRate 固定的频率执行任务
            scheduledThreadPool.scheduleWithFixedDelay(() -> {
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            }, 0, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        scheduledThreadPool.shutdown();
    }

    public void test4(){ //单线程的线程池，线程异常结束，会创建一个新的线程，能确保任务按提交顺序执行
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        //提交 3 个任务
        for (int i = 0; i <3; i++) {
            final int index = i;
            singleThreadPool.execute(() -> {
                //执行第二个任务时，报错，测试线程池会创建新的线程执行任务三
                if (index == 1) {
                    throw new RuntimeException("线程执行出现异常");
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        singleThreadPool.shutdown();
    }

    public void test5(){//创建单线程可执行周期性任务的线程池
        ScheduledExecutorService singleScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        //提交 3 个固定频率执行的任务
        for (int i = 0; i <3; i++) {
            final int index = i;
            //scheduleWithFixedDelay 固定的延迟时间执行任务； scheduleAtFixedRate 固定的频率执行任务
            singleScheduledThreadPool.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            }, 0, 3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        singleScheduledThreadPool.shutdown();
    }

    public void test6(){//创建 4个工作线程的 任务可窃取线程池，如果不设置并行数，默认取 CPU 总核数
        ExecutorService workStealingThreadPool = Executors.newWorkStealingPool(4);
        for (int i = 0; i <10; i++) {
            final int index = i;
            workStealingThreadPool.execute(() -> {
                try {
                    //模拟任务执行时间为 任务编号为0 1 2 的执行时间需要 3秒；其余任务200 毫秒，导致任务时间差异较大
                    if (index <= 2) {
                        Thread.sleep(3000);
                    } else {
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
        }
        try {
            Thread.sleep(10000);//休眠 10 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("10秒后...");
    }
    public void test7() throws Exception{
        AtomicLong atomicLong = new AtomicLong();
        Files.lines(Paths.get("E:/tmp/in_all_twyx_2020-10-20.csv")).parallel().forEach(line -> {
            System.out.println(atomicLong.incrementAndGet()+"\t"+line);
        });

        IntStream.rangeClosed(1, 1000000000).parallel().forEach(a->{
            String payload = IntStream.rangeClosed(1, 1000)
                    .mapToObj(__ -> "a")
                    .collect(Collectors.joining("")) + UUID.randomUUID().toString();
            System.out.println(a+"\t"+payload);
        });
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        try{
            demo.oom1();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
