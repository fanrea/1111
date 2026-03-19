package io.netty.util.concurrent;

import com.alipay.sdk.m.f0.c;
import io.netty.util.Signal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    private static final int MAX_LISTENER_STACK_DEPTH = 8;
    private final EventExecutor executor;
    private DefaultPromise<V>.LateListeners lateListeners;
    private Object listeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName() + ".rejectedExecution");
    private static final Signal SUCCESS = Signal.valueOf(DefaultPromise.class, c.p);
    private static final Signal UNCANCELLABLE = Signal.valueOf(DefaultPromise.class, "UNCANCELLABLE");

    static {
        CauseHolder causeHolder = new CauseHolder(new CancellationException());
        CANCELLATION_CAUSE_HOLDER = causeHolder;
        causeHolder.cause.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        if (eventExecutor == null) {
            throw new NullPointerException("executor");
        }
        this.executor = eventExecutor;
    }

    protected DefaultPromise() {
        this.executor = null;
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        Object obj = this.result;
        if (obj instanceof CauseHolder) {
            return ((CauseHolder) obj).cause;
        }
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        if (genericFutureListener == null) {
            throw new NullPointerException("listener");
        }
        if (isDone()) {
            notifyLateListener(genericFutureListener);
            return this;
        }
        synchronized (this) {
            if (!isDone()) {
                if (this.listeners == null) {
                    this.listeners = genericFutureListener;
                } else if (this.listeners instanceof DefaultFutureListeners) {
                    ((DefaultFutureListeners) this.listeners).add(genericFutureListener);
                } else {
                    this.listeners = new DefaultFutureListeners((GenericFutureListener) this.listeners, genericFutureListener);
                }
                return this;
            }
            notifyLateListener(genericFutureListener);
            return this;
        }
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        if (genericFutureListenerArr == null) {
            throw new NullPointerException("listeners");
        }
        for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
            if (genericFutureListener == null) {
                break;
            }
            addListener((GenericFutureListener) genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        if (genericFutureListener == null) {
            throw new NullPointerException("listener");
        }
        if (isDone()) {
            return this;
        }
        synchronized (this) {
            if (!isDone()) {
                if (this.listeners instanceof DefaultFutureListeners) {
                    ((DefaultFutureListeners) this.listeners).remove(genericFutureListener);
                } else if (this.listeners == genericFutureListener) {
                    this.listeners = null;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        if (genericFutureListenerArr == null) {
            throw new NullPointerException("listeners");
        }
        for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
            if (genericFutureListener == null) {
                break;
            }
            removeListener((GenericFutureListener) genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> sync() throws Throwable {
        await();
        rethrowIfFailed();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> syncUninterruptibly() throws Throwable {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    private void rethrowIfFailed() throws Throwable {
        Throwable thCause = cause();
        if (thCause == null) {
            return;
        }
        PlatformDependent.throwException(thCause);
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        synchronized (this) {
            while (!isDone()) {
                checkDeadLock();
                incWaiters();
                try {
                    wait();
                    decWaiters();
                } catch (Throwable th) {
                    decWaiters();
                    throw th;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.util.concurrent.Future
    public Promise<V> awaitUninterruptibly() {
        if (isDone()) {
            return this;
        }
        boolean z = false;
        synchronized (this) {
            while (!isDone()) {
                checkDeadLock();
                incWaiters();
                try {
                    try {
                        wait();
                        decWaiters();
                    } catch (Throwable th) {
                        decWaiters();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    z = true;
                    decWaiters();
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    private boolean await0(long j, boolean z) throws InterruptedException {
        if (isDone()) {
            return true;
        }
        if (j <= 0) {
            return isDone();
        }
        if (z && Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        long jNanoTime = System.nanoTime();
        boolean z2 = false;
        try {
            synchronized (this) {
                if (isDone()) {
                    return true;
                }
                if (j <= 0) {
                    return isDone();
                }
                checkDeadLock();
                incWaiters();
                long jNanoTime2 = j;
                do {
                    try {
                        try {
                            wait(jNanoTime2 / 1000000, (int) (jNanoTime2 % 1000000));
                        } catch (InterruptedException e) {
                            if (z) {
                                throw e;
                            }
                            z2 = true;
                        }
                        if (isDone()) {
                            return true;
                        }
                        jNanoTime2 = j - (System.nanoTime() - jNanoTime);
                    } finally {
                        decWaiters();
                    }
                } while (jNanoTime2 > 0);
                boolean zIsDone = isDone();
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                return zIsDone;
            }
        } finally {
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected void checkDeadLock() {
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor != null && eventExecutorExecutor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    public Promise<V> setSuccess(V v) {
        if (setSuccess0(v)) {
            notifyListeners();
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    public boolean trySuccess(V v) {
        if (!setSuccess0(v)) {
            return false;
        }
        notifyListeners();
        return true;
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            notifyListeners();
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public boolean tryFailure(Throwable th) {
        if (!setFailure0(th)) {
            return false;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.result;
        if (isDone0(obj) || obj == UNCANCELLABLE) {
            return false;
        }
        synchronized (this) {
            Object obj2 = this.result;
            if (!isDone0(obj2) && obj2 != UNCANCELLABLE) {
                this.result = CANCELLATION_CAUSE_HOLDER;
                if (hasWaiters()) {
                    notifyAll();
                }
                notifyListeners();
                return true;
            }
            return false;
        }
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        Object obj = this.result;
        if (isDone0(obj)) {
            return !isCancelled0(obj);
        }
        synchronized (this) {
            Object obj2 = this.result;
            if (isDone0(obj2)) {
                return isCancelled0(obj2) ? false : true;
            }
            this.result = UNCANCELLABLE;
            return true;
        }
    }

    private boolean setFailure0(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        if (isDone()) {
            return false;
        }
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.result = new CauseHolder(th);
            if (hasWaiters()) {
                notifyAll();
            }
            return true;
        }
    }

    private boolean setSuccess0(V v) {
        if (isDone()) {
            return false;
        }
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            if (v == null) {
                this.result = SUCCESS;
            } else {
                this.result = v;
            }
            if (hasWaiters()) {
                notifyAll();
            }
            return true;
        }
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v = (V) this.result;
        if ((v instanceof CauseHolder) || v == SUCCESS) {
            return null;
        }
        return v;
    }

    private boolean hasWaiters() {
        return this.waiters > 0;
    }

    private void incWaiters() {
        short s = this.waiters;
        if (s == Short.MAX_VALUE) {
            throw new IllegalStateException("too many waiters: " + this);
        }
        this.waiters = (short) (s + 1);
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        Object obj = this.listeners;
        if (obj == null) {
            return;
        }
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop() && (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < 8) {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
            try {
                if (obj instanceof DefaultFutureListeners) {
                    notifyListeners0(this, (DefaultFutureListeners) obj);
                } else {
                    notifyListener0(this, (GenericFutureListener) obj);
                }
                return;
            } finally {
                this.listeners = null;
                internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
            }
        }
        if (obj instanceof DefaultFutureListeners) {
            final DefaultFutureListeners defaultFutureListeners = (DefaultFutureListeners) obj;
            execute(eventExecutorExecutor, new OneTimeTask() { // from class: io.netty.util.concurrent.DefaultPromise.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyListeners0(DefaultPromise.this, defaultFutureListeners);
                    DefaultPromise.this.listeners = null;
                }
            });
        } else {
            final GenericFutureListener genericFutureListener = (GenericFutureListener) obj;
            execute(eventExecutorExecutor, new OneTimeTask() { // from class: io.netty.util.concurrent.DefaultPromise.2
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyListener0(DefaultPromise.this, genericFutureListener);
                    DefaultPromise.this.listeners = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListeners0(Future<?> future, DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i = 0; i < size; i++) {
            notifyListener0(future, genericFutureListenerArrListeners[i]);
        }
    }

    private void notifyLateListener(GenericFutureListener<?> genericFutureListener) {
        DefaultPromise<V>.LateListeners lateListeners;
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop()) {
            if (this.listeners == null && ((lateListeners = this.lateListeners) == null || lateListeners.isEmpty())) {
                InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
                int iFutureListenerStackDepth = internalThreadLocalMap.futureListenerStackDepth();
                if (iFutureListenerStackDepth < 8) {
                    internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
                    try {
                        notifyListener0(this, genericFutureListener);
                        return;
                    } finally {
                        internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
                    }
                }
            } else {
                DefaultPromise<V>.LateListeners lateListeners2 = this.lateListeners;
                if (lateListeners2 == null) {
                    lateListeners2 = new LateListeners();
                    this.lateListeners = lateListeners2;
                }
                lateListeners2.add(genericFutureListener);
                execute(eventExecutorExecutor, lateListeners2);
                return;
            }
        }
        execute(eventExecutorExecutor, new LateListenerNotifier(genericFutureListener));
    }

    protected static void notifyListener(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        if (eventExecutor.inEventLoop() && (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < 8) {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
            try {
                notifyListener0(future, genericFutureListener);
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
            }
        }
        execute(eventExecutor, new OneTimeTask() { // from class: io.netty.util.concurrent.DefaultPromise.3
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPromise.notifyListener0(future, genericFutureListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void execute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    private synchronized Object progressiveListeners() {
        Object obj = this.listeners;
        if (obj == null) {
            return null;
        }
        if (obj instanceof DefaultFutureListeners) {
            DefaultFutureListeners defaultFutureListeners = (DefaultFutureListeners) obj;
            int iProgressiveSize = defaultFutureListeners.progressiveSize();
            if (iProgressiveSize == 0) {
                return null;
            }
            int i = 0;
            if (iProgressiveSize == 1) {
                GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
                int length = genericFutureListenerArrListeners.length;
                while (i < length) {
                    GenericFutureListener<? extends Future<?>> genericFutureListener = genericFutureListenerArrListeners[i];
                    if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                        return genericFutureListener;
                    }
                    i++;
                }
                return null;
            }
            GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners2 = defaultFutureListeners.listeners();
            GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[iProgressiveSize];
            int i2 = 0;
            while (i < iProgressiveSize) {
                GenericFutureListener<? extends Future<?>> genericFutureListener2 = genericFutureListenerArrListeners2[i2];
                if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                    int i3 = i + 1;
                    genericProgressiveFutureListenerArr[i] = (GenericProgressiveFutureListener) genericFutureListener2;
                    i = i3;
                }
                i2++;
            }
            return genericProgressiveFutureListenerArr;
        }
        if (obj instanceof GenericProgressiveFutureListener) {
            return obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void notifyProgressiveListeners(final long j, final long j2) {
        Object objProgressiveListeners = progressiveListeners();
        if (objProgressiveListeners == null) {
            return;
        }
        final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop()) {
            if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
                notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) objProgressiveListeners, j, j2);
                return;
            } else {
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) objProgressiveListeners, j, j2);
                return;
            }
        }
        if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
            final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) objProgressiveListeners;
            execute(eventExecutorExecutor, new OneTimeTask() { // from class: io.netty.util.concurrent.DefaultPromise.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j, j2);
                }
            });
        } else {
            final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) objProgressiveListeners;
            execute(eventExecutorExecutor, new OneTimeTask() { // from class: io.netty.util.concurrent.DefaultPromise.5
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j, j2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j, long j2) {
        for (GenericProgressiveFutureListener<?> genericProgressiveFutureListener : genericProgressiveFutureListenerArr) {
            if (genericProgressiveFutureListener == null) {
                return;
            }
            notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j, long j2) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j, j2);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th);
            }
        }
    }

    static final class CauseHolder {
        final Throwable cause;

        CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    protected StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb.append("(success)");
        } else if (obj == UNCANCELLABLE) {
            sb.append("(uncancellable)");
        } else if (obj instanceof CauseHolder) {
            sb.append("(failure: ");
            sb.append(((CauseHolder) obj).cause);
            sb.append(')');
        } else if (obj != null) {
            sb.append("(success: ");
            sb.append(obj);
            sb.append(')');
        } else {
            sb.append("(incomplete)");
        }
        return sb;
    }

    final class LateListeners extends ArrayDeque<GenericFutureListener<?>> implements Runnable {
        private static final long serialVersionUID = -687137418080392244L;

        LateListeners() {
            super(2);
        }

        @Override // java.lang.Runnable
        public final void run() {
            EventExecutor eventExecutorExecutor = DefaultPromise.this.executor();
            if (DefaultPromise.this.listeners != null && eventExecutorExecutor != ImmediateEventExecutor.INSTANCE) {
                DefaultPromise.execute(eventExecutorExecutor, this);
                return;
            }
            while (true) {
                GenericFutureListener<?> genericFutureListenerPoll = poll();
                if (genericFutureListenerPoll == null) {
                    return;
                } else {
                    DefaultPromise.notifyListener0(DefaultPromise.this, genericFutureListenerPoll);
                }
            }
        }
    }

    final class LateListenerNotifier implements Runnable {
        private GenericFutureListener<?> l;

        LateListenerNotifier(GenericFutureListener<?> genericFutureListener) {
            this.l = genericFutureListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LateListeners lateListeners = DefaultPromise.this.lateListeners;
            if (this.l != null) {
                if (lateListeners == null) {
                    DefaultPromise defaultPromise = DefaultPromise.this;
                    LateListeners lateListeners2 = new LateListeners();
                    defaultPromise.lateListeners = lateListeners2;
                    lateListeners = lateListeners2;
                }
                lateListeners.add(this.l);
                this.l = null;
            }
            lateListeners.run();
        }
    }
}
