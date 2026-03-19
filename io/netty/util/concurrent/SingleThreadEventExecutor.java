package io.netty.util.concurrent;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER;
    private static final long SCHEDULE_PURGE_INTERVAL;
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private final Set<Runnable> shutdownHooks;
    private volatile int state;
    private final Queue<Runnable> taskQueue;
    private final Promise<?> terminationFuture;
    private volatile Thread thread;
    private final Semaphore threadLock;
    private volatile ThreadProperties threadProperties;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SingleThreadEventExecutor.class);
    private static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
        @Override // java.lang.Runnable
        public final void run() {
        }
    };
    private static final Runnable NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.2
        @Override // java.lang.Runnable
        public final void run() {
        }
    };

    protected void cleanup() {
    }

    protected abstract void run();

    protected boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    static {
        AtomicIntegerFieldUpdater<SingleThreadEventExecutor> atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(SingleThreadEventExecutor.class, "state");
        if (atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater == null) {
            atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
        }
        STATE_UPDATER = atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater;
        AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(SingleThreadEventExecutor.class, "threadProperties");
        if (atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
        }
        PROPERTIES_UPDATER = atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater;
        SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z);
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z) {
        super(eventExecutorGroup);
        this.threadLock = new Semaphore(0);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        if (executor == null) {
            throw new NullPointerException("executor");
        }
        this.addTaskWakesUp = z;
        this.executor = executor;
        this.taskQueue = newTaskQueue();
    }

    protected Queue<Runnable> newTaskQueue() {
        return new LinkedBlockingQueue();
    }

    protected void interruptThread() {
        Thread thread = this.thread;
        if (thread == null) {
            this.interrupted = true;
        } else {
            thread.interrupt();
        }
    }

    protected Runnable pollTask() {
        Runnable runnablePoll;
        do {
            runnablePoll = this.taskQueue.poll();
        } while (runnablePoll == WAKEUP_TASK);
        return runnablePoll;
    }

    protected Runnable takeTask() {
        Runnable runnable;
        Runnable runnable2;
        Queue<Runnable> queue = this.taskQueue;
        if (!(queue instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        }
        BlockingQueue blockingQueue = (BlockingQueue) queue;
        do {
            ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
            if (scheduledFutureTaskPeekScheduledTask == null) {
                try {
                    runnable = (Runnable) blockingQueue.take();
                } catch (InterruptedException unused) {
                }
                try {
                    if (runnable != WAKEUP_TASK) {
                        return runnable;
                    }
                    return null;
                } catch (InterruptedException unused2) {
                    return runnable;
                }
            }
            long jDelayNanos = scheduledFutureTaskPeekScheduledTask.delayNanos();
            if (jDelayNanos > 0) {
                try {
                    runnable2 = (Runnable) blockingQueue.poll(jDelayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused3) {
                    return null;
                }
            } else {
                runnable2 = null;
            }
            if (runnable2 == null) {
                fetchFromScheduledTaskQueue();
                runnable2 = (Runnable) blockingQueue.poll();
            }
        } while (runnable2 == null);
        return runnable2;
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

    protected Runnable peekTask() {
        return this.taskQueue.peek();
    }

    protected boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    public final int pendingTasks() {
        return this.taskQueue.size();
    }

    protected void addTask(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (isShutdown()) {
            reject();
        }
        this.taskQueue.add(runnable);
    }

    protected boolean removeTask(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        return this.taskQueue.remove(runnable);
    }

    protected boolean runAllTasks() {
        fetchFromScheduledTaskQueue();
        Runnable runnablePollTask = pollTask();
        if (runnablePollTask == null) {
            return false;
        }
        do {
            try {
                runnablePollTask.run();
            } catch (Throwable th) {
                logger.warn("A task raised an exception.", th);
            }
            runnablePollTask = pollTask();
        } while (runnablePollTask != null);
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean runAllTasks(long r8) {
        /*
            r7 = this;
            r7.fetchFromScheduledTaskQueue()
            java.lang.Runnable r0 = r7.pollTask()
            if (r0 != 0) goto Lb
            r8 = 0
            return r8
        Lb:
            long r1 = io.netty.util.concurrent.ScheduledFutureTask.nanoTime()
            long r1 = r1 + r8
            r8 = 0
            r3 = r8
        L13:
            r0.run()     // Catch: java.lang.Throwable -> L17
            goto L1f
        L17:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
            java.lang.String r6 = "A task raised an exception."
            r5.warn(r6, r0)
        L1f:
            r5 = 1
            long r3 = r3 + r5
            r5 = 63
            long r5 = r5 & r3
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 != 0) goto L31
            long r5 = io.netty.util.concurrent.ScheduledFutureTask.nanoTime()
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3b
        L31:
            java.lang.Runnable r0 = r7.pollTask()
            if (r0 != 0) goto L13
            long r5 = io.netty.util.concurrent.ScheduledFutureTask.nanoTime()
        L3b:
            r7.lastExecutionTime = r5
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(long):boolean");
    }

    protected long delayNanos(long j) {
        ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
        if (scheduledFutureTaskPeekScheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return scheduledFutureTaskPeekScheduledTask.delayNanos(j);
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }

    protected void wakeup(boolean z) {
        if (!z || STATE_UPDATER.get(this) == 3) {
            this.taskQueue.add(WAKEUP_TASK);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    public void addShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.add(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable);
                }
            });
        }
    }

    public void removeShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable);
                }
            });
        }
    }

    private boolean runShutdownHooks() {
        boolean z = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((Runnable) it.next()).run();
                } finally {
                    z = true;
                }
                z = true;
            }
        }
        if (z) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return z;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("quietPeriod: " + j + " (expected >= 0)");
        }
        if (j2 < j) {
            throw new IllegalArgumentException("timeout: " + j2 + " (expected >= quietPeriod (" + j + "))");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (isShuttingDown()) {
            return terminationFuture();
        }
        boolean zInEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i = STATE_UPDATER.get(this);
            int i2 = 3;
            if (zInEventLoop || i == 1 || i == 2) {
                z = true;
            } else {
                i2 = i;
                z = false;
            }
            if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j);
                this.gracefulShutdownTimeout = timeUnit.toNanos(j2);
                if (i == 1) {
                    doStartThread();
                }
                if (z) {
                    wakeup(zInEventLoop);
                }
                return terminationFuture();
            }
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        boolean z;
        if (isShutdown()) {
            return;
        }
        boolean zInEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i = STATE_UPDATER.get(this);
            int i2 = 4;
            if (zInEventLoop || i == 1 || i == 2 || i == 3) {
                z = true;
            } else {
                i2 = i;
                z = false;
            }
            if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                if (i == 1) {
                    doStartThread();
                }
                if (z) {
                    wakeup(zInEventLoop);
                    return;
                }
                return;
            }
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return STATE_UPDATER.get(this) >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return STATE_UPDATER.get(this) >= 4;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return STATE_UPDATER.get(this) == 5;
    }

    protected boolean confirmShutdown() throws InterruptedException {
        if (!isShuttingDown()) {
            return false;
        }
        if (!inEventLoop()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        cancelScheduledTasks();
        if (this.gracefulShutdownStartTime == 0) {
            this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
        }
        if (runAllTasks() || runShutdownHooks()) {
            if (isShutdown()) {
                return true;
            }
            wakeup(true);
            return false;
        }
        long jNanoTime = ScheduledFutureTask.nanoTime();
        if (isShutdown() || jNanoTime - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || jNanoTime - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
            return true;
        }
        wakeup(true);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        if (this.threadLock.tryAcquire(j, timeUnit)) {
            this.threadLock.release();
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        boolean zInEventLoop = inEventLoop();
        if (zInEventLoop) {
            addTask(runnable);
        } else {
            startThread();
            addTask(runnable);
            if (isShutdown() && removeTask(runnable)) {
                reject();
            }
        }
        if (this.addTaskWakesUp || !wakesUpForTask(runnable)) {
            return;
        }
        wakeup(zInEventLoop);
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties = this.threadProperties;
        if (threadProperties != null) {
            return threadProperties;
        }
        Thread thread = this.thread;
        if (thread == null) {
            submit(NOOP_TASK).syncUninterruptibly();
            thread = this.thread;
        }
        DefaultThreadProperties defaultThreadProperties = new DefaultThreadProperties(thread);
        return !PROPERTIES_UPDATER.compareAndSet(this, null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private void startThread() {
        if (STATE_UPDATER.get(this) == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            doStartThread();
        }
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.5
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00d3, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00d4, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00f0, code lost:
            
                if (r9.this$0.taskQueue.isEmpty() == false) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x00f2, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0112, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x011b, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x022b, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x022c, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x0248, code lost:
            
                if (r9.this$0.taskQueue.isEmpty() == false) goto L60;
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x024a, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x026a, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0273, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x037a, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:91:0x037b, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER.set(r9.this$0, 5);
                r9.this$0.threadLock.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x0397, code lost:
            
                if (r9.this$0.taskQueue.isEmpty() == false) goto L93;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0399, code lost:
            
                io.netty.util.concurrent.SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + r9.this$0.taskQueue.size() + ')');
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x03b9, code lost:
            
                r9.this$0.terminationFuture.setSuccess(null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x03c2, code lost:
            
                throw r1;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 1116
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.AnonymousClass5.run():void");
            }
        });
    }

    static final class DefaultThreadProperties implements ThreadProperties {
        private final Thread t;

        DefaultThreadProperties(Thread thread) {
            this.t = thread;
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final Thread.State state() {
            return this.t.getState();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final int priority() {
            return this.t.getPriority();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final boolean isInterrupted() {
            return this.t.isInterrupted();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final boolean isDaemon() {
            return this.t.isDaemon();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final String name() {
            return this.t.getName();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final long id() {
            return this.t.getId();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final StackTraceElement[] stackTrace() {
            return this.t.getStackTrace();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public final boolean isAlive() {
            return this.t.isAlive();
        }
    }
}
