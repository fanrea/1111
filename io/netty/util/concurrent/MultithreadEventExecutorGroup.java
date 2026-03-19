package io.netty.util.concurrent;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final AtomicInteger childIndex;
    private final EventExecutor[] children;
    private final EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise<?> terminationFuture;

    interface EventExecutorChooser {
        EventExecutor next();
    }

    private static boolean isPowerOfTwo(int i) {
        return ((-i) & i) == i;
    }

    protected abstract EventExecutor newChild(Executor executor, Object... objArr);

    protected MultithreadEventExecutorGroup(int i, ThreadFactory threadFactory, Object... objArr) {
        this(i, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    protected MultithreadEventExecutorGroup(int i, Executor executor, Object... objArr) {
        this.childIndex = new AtomicInteger();
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        int i2 = 0;
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", Integer.valueOf(i)));
        }
        executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
        this.children = new EventExecutor[i];
        if (isPowerOfTwo(this.children.length)) {
            this.chooser = new PowerOfTwoEventExecutorChooser();
        } else {
            this.chooser = new GenericEventExecutorChooser();
        }
        for (int i3 = 0; i3 < i; i3++) {
            try {
                try {
                    this.children[i3] = newChild(executor, objArr);
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a child event loop", e);
                }
            } catch (Throwable th) {
                for (int i4 = 0; i4 < i3; i4++) {
                    this.children[i4].shutdownGracefully();
                }
                while (i2 < i3) {
                    EventExecutor eventExecutor = this.children[i2];
                    while (!eventExecutor.isTerminated()) {
                        try {
                            eventExecutor.awaitTermination(2147483647L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw th;
                        }
                    }
                    i2++;
                }
                throw th;
            }
        }
        FutureListener<Object> futureListener = new FutureListener<Object>() { // from class: io.netty.util.concurrent.MultithreadEventExecutorGroup.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Object> future) {
                if (MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.this.children.length) {
                    MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                }
            }
        };
        EventExecutor[] eventExecutorArr = this.children;
        int length = eventExecutorArr.length;
        while (i2 < length) {
            eventExecutorArr[i2].terminationFuture().addListener(futureListener);
            i2++;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
        Collections.addAll(linkedHashSet, this.children);
        this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
    }

    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this.chooser.next();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return children().iterator();
    }

    public final int executorCount() {
        return this.children.length;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final <E extends EventExecutor> Set<E> children() {
        return (Set<E>) this.readonlyChildren;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdownGracefully(j, j2, timeUnit);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdown();
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long jNanoTime;
        long jNanoTime2 = System.nanoTime() + timeUnit.toNanos(j);
        loop0: for (EventExecutor eventExecutor : this.children) {
            do {
                jNanoTime = jNanoTime2 - System.nanoTime();
                if (jNanoTime <= 0) {
                    break loop0;
                }
            } while (!eventExecutor.awaitTermination(jNanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    final class PowerOfTwoEventExecutorChooser implements EventExecutorChooser {
        private PowerOfTwoEventExecutorChooser() {
        }

        @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup.EventExecutorChooser
        public final EventExecutor next() {
            return MultithreadEventExecutorGroup.this.children[MultithreadEventExecutorGroup.this.childIndex.getAndIncrement() & (MultithreadEventExecutorGroup.this.children.length - 1)];
        }
    }

    final class GenericEventExecutorChooser implements EventExecutorChooser {
        private GenericEventExecutorChooser() {
        }

        @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup.EventExecutorChooser
        public final EventExecutor next() {
            return MultithreadEventExecutorGroup.this.children[Math.abs(MultithreadEventExecutorGroup.this.childIndex.getAndIncrement() % MultithreadEventExecutorGroup.this.children.length)];
        }
    }
}
