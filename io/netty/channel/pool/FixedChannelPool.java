package io.netty.channel.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.OneTimeTask;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class FixedChannelPool extends SimpleChannelPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final IllegalStateException FULL_EXCEPTION = new IllegalStateException("Too many outstanding acquire operations");
    private static final TimeoutException TIMEOUT_EXCEPTION = new TimeoutException("Acquire operation took longer then configured maximum time");
    private final long acquireTimeoutNanos;
    private int acquiredChannelCount;
    private boolean closed;
    private final EventExecutor executor;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private int pendingAcquireCount;
    private final Queue<AcquireTask> pendingAcquireQueue;
    private final Runnable timeoutTask;

    public enum AcquireTimeoutAction {
        NEW,
        FAIL
    }

    static /* synthetic */ int access$1108(FixedChannelPool fixedChannelPool) {
        int i = fixedChannelPool.acquiredChannelCount;
        fixedChannelPool.acquiredChannelCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$906(FixedChannelPool fixedChannelPool) {
        int i = fixedChannelPool.pendingAcquireCount - 1;
        fixedChannelPool.pendingAcquireCount = i;
        return i;
    }

    static {
        FULL_EXCEPTION.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        TIMEOUT_EXCEPTION.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i) {
        this(bootstrap, channelPoolHandler, i, Integer.MAX_VALUE);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i, int i2) {
        this(bootstrap, channelPoolHandler, ChannelHealthChecker.ACTIVE, null, -1L, i, i2);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j, int i, int i2) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j, i, i2, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j, int i, int i2, boolean z) {
        super(bootstrap, channelPoolHandler, channelHealthChecker, z);
        this.pendingAcquireQueue = new ArrayDeque();
        if (i <= 0) {
            throw new IllegalArgumentException("maxConnections: " + i + " (expected: >= 1)");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxPendingAcquires: " + i2 + " (expected: >= 1)");
        }
        if (acquireTimeoutAction == null && j == -1) {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1L;
        } else {
            if (acquireTimeoutAction == null && j != -1) {
                throw new NullPointerException("action");
            }
            if (acquireTimeoutAction != null && j < 0) {
                throw new IllegalArgumentException("acquireTimeoutMillis: " + j + " (expected: >= 1)");
            }
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(j);
            int i3 = AnonymousClass6.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[acquireTimeoutAction.ordinal()];
            if (i3 == 1) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.1
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.promise.setFailure(FixedChannelPool.TIMEOUT_EXCEPTION);
                    }
                };
            } else if (i3 == 2) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.2
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.acquired();
                        FixedChannelPool.super.acquire(acquireTask.promise);
                    }
                };
            } else {
                throw new Error();
            }
        }
        this.executor = bootstrap.group().next();
        this.maxConnections = i;
        this.maxPendingAcquires = i2;
    }

    /* renamed from: io.netty.channel.pool.FixedChannelPool$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction = new int[AcquireTimeoutAction.values().length];

        static {
            try {
                $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[AcquireTimeoutAction.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[AcquireTimeoutAction.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public final Future<Channel> acquire(final Promise<Channel> promise) {
        try {
            if (this.executor.inEventLoop()) {
                acquire0(promise);
            } else {
                this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.pool.FixedChannelPool.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FixedChannelPool.this.acquire0(promise);
                    }
                });
            }
        } catch (Throwable th) {
            promise.setFailure(th);
        }
        return promise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquire0(Promise<Channel> promise) {
        if (this.closed) {
            promise.setFailure(new IllegalStateException("FixedChannelPooled was closed"));
            return;
        }
        if (this.acquiredChannelCount < this.maxConnections) {
            Promise<Channel> promiseNewPromise = this.executor.newPromise();
            AcquireListener acquireListener = new AcquireListener(promise);
            acquireListener.acquired();
            promiseNewPromise.addListener((GenericFutureListener<? extends Future<? super Channel>>) acquireListener);
            super.acquire(promiseNewPromise);
            return;
        }
        if (this.pendingAcquireCount >= this.maxPendingAcquires) {
            promise.setFailure(FULL_EXCEPTION);
            return;
        }
        AcquireTask acquireTask = new AcquireTask(promise);
        if (this.pendingAcquireQueue.offer(acquireTask)) {
            this.pendingAcquireCount++;
            Runnable runnable = this.timeoutTask;
            if (runnable != null) {
                acquireTask.timeoutFuture = this.executor.schedule(runnable, this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
                return;
            }
            return;
        }
        promise.setFailure(FULL_EXCEPTION);
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public final Future<Void> release(Channel channel, final Promise<Void> promise) {
        Promise promiseNewPromise = this.executor.newPromise();
        super.release(channel, promiseNewPromise.addListener((GenericFutureListener) new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.4
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) {
                if (FixedChannelPool.this.closed) {
                    promise.setFailure(new IllegalStateException("FixedChannelPooled was closed"));
                    return;
                }
                if (future.isSuccess()) {
                    FixedChannelPool.this.decrementAndRunTaskQueue();
                    promise.setSuccess(null);
                } else {
                    if (!(future.cause() instanceof IllegalArgumentException)) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                    }
                    promise.setFailure(future.cause());
                }
            }
        }));
        return promiseNewPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementAndRunTaskQueue() {
        this.acquiredChannelCount--;
        runTaskQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskQueue() {
        AcquireTask acquireTaskPoll;
        while (this.acquiredChannelCount < this.maxConnections && (acquireTaskPoll = this.pendingAcquireQueue.poll()) != null) {
            ScheduledFuture<?> scheduledFuture = acquireTaskPoll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.pendingAcquireCount--;
            acquireTaskPoll.acquired();
            super.acquire(acquireTaskPoll.promise);
        }
    }

    final class AcquireTask extends AcquireListener {
        final long expireNanoTime;
        final Promise<Channel> promise;
        ScheduledFuture<?> timeoutFuture;

        public AcquireTask(Promise<Channel> promise) {
            super(promise);
            this.expireNanoTime = System.nanoTime() + FixedChannelPool.this.acquireTimeoutNanos;
            this.promise = FixedChannelPool.this.executor.newPromise().addListener((GenericFutureListener) this);
        }
    }

    abstract class TimeoutTask implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public abstract void onTimeout(AcquireTask acquireTask);

        private TimeoutTask() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jNanoTime = System.nanoTime();
            while (true) {
                AcquireTask acquireTask = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.peek();
                if (acquireTask == null || jNanoTime - acquireTask.expireNanoTime < 0) {
                    return;
                }
                FixedChannelPool.this.pendingAcquireQueue.remove();
                FixedChannelPool.access$906(FixedChannelPool.this);
                onTimeout(acquireTask);
            }
        }
    }

    class AcquireListener implements FutureListener<Channel> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected boolean acquired;
        private final Promise<Channel> originalPromise;

        AcquireListener(Promise<Channel> promise) {
            this.originalPromise = promise;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Channel> future) {
            if (FixedChannelPool.this.closed) {
                this.originalPromise.setFailure(new IllegalStateException("FixedChannelPooled was closed"));
                return;
            }
            if (future.isSuccess()) {
                this.originalPromise.setSuccess(future.getNow());
                return;
            }
            if (this.acquired) {
                FixedChannelPool.this.decrementAndRunTaskQueue();
            } else {
                FixedChannelPool.this.runTaskQueue();
            }
            this.originalPromise.setFailure(future.cause());
        }

        public void acquired() {
            if (this.acquired) {
                return;
            }
            FixedChannelPool.access$1108(FixedChannelPool.this);
            this.acquired = true;
        }
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.pool.FixedChannelPool.5
            @Override // java.lang.Runnable
            public void run() {
                if (FixedChannelPool.this.closed) {
                    return;
                }
                FixedChannelPool.this.closed = true;
                while (true) {
                    AcquireTask acquireTask = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.poll();
                    if (acquireTask == null) {
                        FixedChannelPool.this.acquiredChannelCount = 0;
                        FixedChannelPool.this.pendingAcquireCount = 0;
                        FixedChannelPool.super.close();
                        return;
                    } else {
                        ScheduledFuture<?> scheduledFuture = acquireTask.timeoutFuture;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        acquireTask.promise.setFailure(new ClosedChannelException());
                    }
                }
            }
        });
    }
}
