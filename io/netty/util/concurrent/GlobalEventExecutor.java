package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GlobalEventExecutor extends AbstractScheduledEventExecutor {
    volatile Thread thread;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) GlobalEventExecutor.class);
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    final ScheduledFutureTask<Void> quietPeriodTask = new ScheduledFutureTask<>(this, Executors.callable(new Runnable() { // from class: io.netty.util.concurrent.GlobalEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    }, null), ScheduledFutureTask.deadlineNanos(SCHEDULE_QUIET_PERIOD_INTERVAL), -SCHEDULE_QUIET_PERIOD_INTERVAL);
    private final ThreadFactory threadFactory = new DefaultThreadFactory(getClass());
    private final TaskRunner taskRunner = new TaskRunner();
    private final AtomicBoolean started = new AtomicBoolean();
    private final Future<?> terminationFuture = new FailedFuture(this, new UnsupportedOperationException());

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    private GlobalEventExecutor() {
        scheduledTaskQueue().add(this.quietPeriodTask);
    }

    final Runnable takeTask() throws InterruptedException {
        Runnable runnablePoll;
        BlockingQueue<Runnable> blockingQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
            if (scheduledFutureTaskPeekScheduledTask == null) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            long jDelayNanos = scheduledFutureTaskPeekScheduledTask.delayNanos();
            if (jDelayNanos > 0) {
                try {
                    runnablePoll = blockingQueue.poll(jDelayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused2) {
                    return null;
                }
            } else {
                runnablePoll = blockingQueue.poll();
            }
            if (runnablePoll == null) {
                fetchFromScheduledTaskQueue();
                runnablePoll = blockingQueue.poll();
            }
        } while (runnablePoll == null);
        return runnablePoll;
    }

    private void fetchFromScheduledTaskQueue() {
        if (!hasScheduledTasks()) {
            return;
        }
        long jNanoTime = AbstractScheduledEventExecutor.nanoTime();
        while (true) {
            Runnable runnablePollScheduledTask = pollScheduledTask(jNanoTime);
            if (runnablePollScheduledTask == null) {
                return;
            } else {
                this.taskQueue.add(runnablePollScheduledTask);
            }
        }
    }

    public final int pendingTasks() {
        return this.taskQueue.size();
    }

    private void addTask(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        this.taskQueue.add(runnable);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public final boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    public final boolean awaitInactivity(long j, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        Thread thread = this.thread;
        if (thread == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread.join(timeUnit.toMillis(j));
        return !thread.isAlive();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        addTask(runnable);
        if (inEventLoop()) {
            return;
        }
        startThread();
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            Thread threadNewThread = this.threadFactory.newThread(this.taskRunner);
            this.thread = threadNewThread;
            threadNewThread.start();
        }
    }

    final class TaskRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        TaskRunner() {
        }

        @Override // java.lang.Runnable
        public final void run() throws InterruptedException {
            while (true) {
                Runnable runnableTakeTask = GlobalEventExecutor.this.takeTask();
                if (runnableTakeTask != null) {
                    try {
                        runnableTakeTask.run();
                    } catch (Throwable th) {
                        GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", th);
                    }
                    if (runnableTakeTask != GlobalEventExecutor.this.quietPeriodTask) {
                        continue;
                    }
                }
                Queue<ScheduledFutureTask<?>> queue = GlobalEventExecutor.this.scheduledTaskQueue;
                if (GlobalEventExecutor.this.taskQueue.isEmpty() && (queue == null || queue.size() == 1)) {
                    GlobalEventExecutor.this.started.compareAndSet(true, false);
                    if ((GlobalEventExecutor.this.taskQueue.isEmpty() && (queue == null || queue.size() == 1)) || !GlobalEventExecutor.this.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }
}
