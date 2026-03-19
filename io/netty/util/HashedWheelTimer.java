package io.netty.util;

import androidx.core.location.LocationRequestCompat;
import io.netty.util.internal.MpscLinkedQueueNode;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HashedWheelTimer implements Timer {
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER;
    private final Queue<Runnable> cancelledTimeouts;
    private final ResourceLeak leak;
    private final int mask;
    private volatile long startTime;
    private final CountDownLatch startTimeInitialized;
    private final long tickDuration;
    private final Queue<HashedWheelTimeout> timeouts;
    private final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HashedWheelTimer.class);
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector = new ResourceLeakDetector<>((Class<?>) HashedWheelTimer.class, 1, Runtime.getRuntime().availableProcessors() * 4);

    private static int normalizeTicksPerWheel(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2;
    }

    static {
        AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(HashedWheelTimer.class, "workerState");
        if (atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater == null) {
            atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");
        }
        WORKER_STATE_UPDATER = atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater;
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j, timeUnit);
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit, int i) {
        this(Executors.defaultThreadFactory(), j, timeUnit, i);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100L, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
        this(threadFactory, j, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i) {
        this.worker = new Worker();
        this.workerState = 0;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + j);
        }
        if (i <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i);
        }
        this.wheel = createWheel(i);
        this.mask = this.wheel.length - 1;
        this.tickDuration = timeUnit.toNanos(j);
        if (this.tickDuration >= LocationRequestCompat.PASSIVE_INTERVAL / this.wheel.length) {
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", Long.valueOf(j), Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL / this.wheel.length)));
        }
        this.workerThread = threadFactory.newThread(this.worker);
        this.leak = leakDetector.open(this);
    }

    private static HashedWheelBucket[] createWheel(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i);
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("ticksPerWheel may not be greater than 2^30: " + i);
        }
        int iNormalizeTicksPerWheel = normalizeTicksPerWheel(i);
        HashedWheelBucket[] hashedWheelBucketArr = new HashedWheelBucket[iNormalizeTicksPerWheel];
        for (int i2 = 0; i2 < iNormalizeTicksPerWheel; i2++) {
            hashedWheelBucketArr[i2] = new HashedWheelBucket();
        }
        return hashedWheelBucketArr;
    }

    public void start() throws InterruptedException {
        int i = WORKER_STATE_UPDATER.get(this);
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("cannot be started once stopped");
                }
                throw new Error("Invalid WorkerState");
            }
        } else if (WORKER_STATE_UPDATER.compareAndSet(this, 0, 1)) {
            this.workerThread.start();
        }
        while (this.startTime == 0) {
            try {
                this.startTimeInitialized.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // io.netty.util.Timer
    public Set<Timeout> stop() throws InterruptedException {
        if (Thread.currentThread() == this.workerThread) {
            throw new IllegalStateException(HashedWheelTimer.class.getSimpleName() + ".stop() cannot be called from " + TimerTask.class.getSimpleName());
        }
        if (!WORKER_STATE_UPDATER.compareAndSet(this, 1, 2)) {
            WORKER_STATE_UPDATER.set(this, 2);
            ResourceLeak resourceLeak = this.leak;
            if (resourceLeak != null) {
                resourceLeak.close();
            }
            return Collections.emptySet();
        }
        boolean z = false;
        while (this.workerThread.isAlive()) {
            this.workerThread.interrupt();
            try {
                this.workerThread.join(100L);
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        ResourceLeak resourceLeak2 = this.leak;
        if (resourceLeak2 != null) {
            resourceLeak2.close();
        }
        return this.worker.unprocessedTimeouts();
    }

    @Override // io.netty.util.Timer
    public Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit) throws InterruptedException {
        if (timerTask == null) {
            throw new NullPointerException("task");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        start();
        HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(this, timerTask, (System.nanoTime() + timeUnit.toNanos(j)) - this.startTime);
        this.timeouts.add(hashedWheelTimeout);
        return hashedWheelTimeout;
    }

    final class Worker implements Runnable {
        private long tick;
        private final Set<Timeout> unprocessedTimeouts;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        @Override // java.lang.Runnable
        public final void run() throws InterruptedException {
            HashedWheelTimer.this.startTime = System.nanoTime();
            if (HashedWheelTimer.this.startTime == 0) {
                HashedWheelTimer.this.startTime = 1L;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long jWaitForNextTick = waitForNextTick();
                if (jWaitForNextTick > 0) {
                    int i = (int) (this.tick & HashedWheelTimer.this.mask);
                    processCancelledTasks();
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimer.this.wheel[i];
                    transferTimeoutsToBuckets();
                    hashedWheelBucket.expireTimeouts(jWaitForNextTick);
                    this.tick++;
                }
            } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            for (HashedWheelBucket hashedWheelBucket2 : HashedWheelTimer.this.wheel) {
                hashedWheelBucket2.clearTimeouts(this.unprocessedTimeouts);
            }
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll();
                if (hashedWheelTimeout != null) {
                    if (!hashedWheelTimeout.isCancelled()) {
                        this.unprocessedTimeouts.add(hashedWheelTimeout);
                    }
                } else {
                    processCancelledTasks();
                    return;
                }
            }
        }

        private void transferTimeoutsToBuckets() {
            HashedWheelTimeout hashedWheelTimeout;
            for (int i = 0; i < 100000 && (hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i++) {
                if (hashedWheelTimeout.state() != 1) {
                    long j = hashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimeout.remainingRounds = (j - this.tick) / HashedWheelTimer.this.wheel.length;
                    HashedWheelTimer.this.wheel[(int) (Math.max(j, this.tick) & HashedWheelTimer.this.mask)].addTimeout(hashedWheelTimeout);
                }
            }
        }

        private void processCancelledTasks() {
            while (true) {
                Runnable runnable = (Runnable) HashedWheelTimer.this.cancelledTimeouts.poll();
                if (runnable == null) {
                    return;
                }
                try {
                    runnable.run();
                } catch (Throwable th) {
                    if (HashedWheelTimer.logger.isWarnEnabled()) {
                        HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", th);
                    }
                }
            }
        }

        private long waitForNextTick() throws InterruptedException {
            long j = HashedWheelTimer.this.tickDuration * (this.tick + 1);
            while (true) {
                long jNanoTime = System.nanoTime() - HashedWheelTimer.this.startTime;
                long j2 = ((j - jNanoTime) + 999999) / 1000000;
                if (j2 <= 0) {
                    if (jNanoTime == Long.MIN_VALUE) {
                        return -9223372036854775807L;
                    }
                    return jNanoTime;
                }
                if (PlatformDependent.isWindows()) {
                    j2 = (j2 / 10) * 10;
                }
                try {
                    Thread.sleep(j2);
                } catch (InterruptedException unused) {
                    if (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 2) {
                        return Long.MIN_VALUE;
                    }
                }
            }
        }

        public final Set<Timeout> unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }
    }

    static final class HashedWheelTimeout extends MpscLinkedQueueNode<Timeout> implements Timeout {
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER;
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final int ST_INIT = 0;
        HashedWheelBucket bucket;
        private final long deadline;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        long remainingRounds;
        private volatile int state = 0;
        private final TimerTask task;
        private final HashedWheelTimer timer;

        @Override // io.netty.util.internal.MpscLinkedQueueNode
        public final Timeout value() {
            return this;
        }

        static {
            AtomicIntegerFieldUpdater<HashedWheelTimeout> atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(HashedWheelTimeout.class, "state");
            if (atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater == null) {
                atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
            }
            STATE_UPDATER = atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater;
        }

        HashedWheelTimeout(HashedWheelTimer hashedWheelTimer, TimerTask timerTask, long j) {
            this.timer = hashedWheelTimer;
            this.task = timerTask;
            this.deadline = j;
        }

        @Override // io.netty.util.Timeout
        public final Timer timer() {
            return this.timer;
        }

        @Override // io.netty.util.Timeout
        public final TimerTask task() {
            return this.task;
        }

        @Override // io.netty.util.Timeout
        public final boolean cancel() {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            this.timer.cancelledTimeouts.add(new Runnable() { // from class: io.netty.util.HashedWheelTimer.HashedWheelTimeout.1
                @Override // java.lang.Runnable
                public void run() {
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimeout.this.bucket;
                    if (hashedWheelBucket != null) {
                        hashedWheelBucket.remove(HashedWheelTimeout.this);
                    }
                }
            });
            return true;
        }

        public final boolean compareAndSetState(int i, int i2) {
            return STATE_UPDATER.compareAndSet(this, i, i2);
        }

        public final int state() {
            return this.state;
        }

        @Override // io.netty.util.Timeout
        public final boolean isCancelled() {
            return state() == 1;
        }

        @Override // io.netty.util.Timeout
        public final boolean isExpired() {
            return state() == 2;
        }

        public final void expire() {
            if (compareAndSetState(0, 2)) {
                try {
                    this.task.run(this);
                } catch (Throwable th) {
                    if (HashedWheelTimer.logger.isWarnEnabled()) {
                        HashedWheelTimer.logger.warn("An exception was thrown by " + TimerTask.class.getSimpleName() + '.', th);
                    }
                }
            }
        }

        public final String toString() {
            long jNanoTime = (this.deadline - System.nanoTime()) + this.timer.startTime;
            StringBuilder sb = new StringBuilder(192);
            sb.append(StringUtil.simpleClassName(this));
            sb.append('(');
            sb.append("deadline: ");
            if (jNanoTime > 0) {
                sb.append(jNanoTime);
                sb.append(" ns later");
            } else if (jNanoTime < 0) {
                sb.append(-jNanoTime);
                sb.append(" ns ago");
            } else {
                sb.append("now");
            }
            if (isCancelled()) {
                sb.append(", cancelled");
            }
            sb.append(", task: ");
            sb.append(task());
            sb.append(')');
            return sb.toString();
        }
    }

    static final class HashedWheelBucket {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;

        private HashedWheelBucket() {
        }

        public final void addTimeout(HashedWheelTimeout hashedWheelTimeout) {
            hashedWheelTimeout.bucket = this;
            if (this.head == null) {
                this.tail = hashedWheelTimeout;
                this.head = hashedWheelTimeout;
            } else {
                HashedWheelTimeout hashedWheelTimeout2 = this.tail;
                hashedWheelTimeout2.next = hashedWheelTimeout;
                hashedWheelTimeout.prev = hashedWheelTimeout2;
                this.tail = hashedWheelTimeout;
            }
        }

        public final void expireTimeouts(long j) {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            while (hashedWheelTimeout != null) {
                boolean z = true;
                if (hashedWheelTimeout.remainingRounds <= 0) {
                    if (hashedWheelTimeout.deadline <= j) {
                        hashedWheelTimeout.expire();
                    } else {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", Long.valueOf(hashedWheelTimeout.deadline), Long.valueOf(j)));
                    }
                } else if (!hashedWheelTimeout.isCancelled()) {
                    hashedWheelTimeout.remainingRounds--;
                    z = false;
                }
                HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
                if (z) {
                    remove(hashedWheelTimeout);
                }
                hashedWheelTimeout = hashedWheelTimeout2;
            }
        }

        public final void remove(HashedWheelTimeout hashedWheelTimeout) {
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            if (hashedWheelTimeout.prev != null) {
                hashedWheelTimeout.prev.next = hashedWheelTimeout2;
            }
            if (hashedWheelTimeout.next != null) {
                hashedWheelTimeout.next.prev = hashedWheelTimeout.prev;
            }
            if (hashedWheelTimeout == this.head) {
                if (hashedWheelTimeout == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = hashedWheelTimeout2;
                }
            } else if (hashedWheelTimeout == this.tail) {
                this.tail = hashedWheelTimeout.prev;
            }
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.bucket = null;
        }

        public final void clearTimeouts(Set<Timeout> set) {
            while (true) {
                HashedWheelTimeout hashedWheelTimeoutPollTimeout = pollTimeout();
                if (hashedWheelTimeoutPollTimeout == null) {
                    return;
                }
                if (!hashedWheelTimeoutPollTimeout.isExpired() && !hashedWheelTimeoutPollTimeout.isCancelled()) {
                    set.add(hashedWheelTimeoutPollTimeout);
                }
            }
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            if (hashedWheelTimeout == null) {
                return null;
            }
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            if (hashedWheelTimeout2 == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = hashedWheelTimeout2;
                hashedWheelTimeout2.prev = null;
            }
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.bucket = null;
            return hashedWheelTimeout;
        }
    }
}
