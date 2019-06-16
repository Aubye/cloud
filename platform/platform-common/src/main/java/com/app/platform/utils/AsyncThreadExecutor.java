package com.app.platform.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Slf4j
public class AsyncThreadExecutor implements AutoCloseable {

    private static final int DEFAULT_QUEUE_SIZE = 1000;
    private static final int DEFAULT_POOL_SIZE = 10;

    private int queueSize = DEFAULT_QUEUE_SIZE;
    private int poolSize = DEFAULT_POOL_SIZE;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
            new BasicThreadFactory.Builder().namingPattern("async thread executor monitor").build());

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(poolSize, poolSize,
            0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
            new BasicThreadFactory.Builder().namingPattern("async thread executor monitor").build(),
            (r, executor) -> log.error("the async executor pool is full"));

    private final ExecutorService executorService = threadPoolExecutor;

    @PostConstruct
    private void init() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            //线程池需要执行的任务数
            long taskCount = threadPoolExecutor.getTaskCount();
            //线程池正在运行过程中已完成的任务数
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            //曾经创建过的最大现场数
            int largestPoolSize = threadPoolExecutor.getLargestPoolSize();
            //线程池里的线程数量
            int poolSize = threadPoolExecutor.getPoolSize();
            //线程池里的活跃线程数量
            int activeCount = threadPoolExecutor.getActiveCount();
            log.info("asyncThreadExecutor.executor monitor taskCount:{}, completedTaskCount:{}, largestPoolSize:{}, poolSize:{}, activeCount:{}",
                    taskCount, completedTaskCount, largestPoolSize, poolSize, activeCount);
        }, 0, 10, TimeUnit.MINUTES);
    }

    public void executor(Runnable task) {
        executorService.execute(task);
    }

    public Future<?> executorAck(FutureTask task) {
        return executorService.submit(task);
    }

    @Override
    public void close() throws Exception {
        executorService.shutdown();
    }
}
