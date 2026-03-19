package io.netty.util.internal.chmv8;

import io.netty.util.internal.chmv8.ForkJoinPool;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ForkJoinTask<V> implements Serializable, Future<V> {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    private static final int EXCEPTION_MAP_CAPACITY = 32;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;
    private static final long STATUS;
    private static final Unsafe U;
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;
    private static final ReentrantLock exceptionTableLock = new ReentrantLock();
    private static final ReferenceQueue<Object> exceptionTableRefQueue = new ReferenceQueue<>();
    private static final ExceptionNode[] exceptionTable = new ExceptionNode[32];

    protected abstract boolean exec();

    public abstract V getRawResult();

    void internalPropagateException(Throwable th) {
    }

    protected abstract void setRawResult(V v);

    private int setCompletion(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    final int doExec() {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        try {
            return exec() ? setCompletion(-268435456) : i;
        } catch (Throwable th) {
            return setExceptionalCompletion(th);
        }
    }

    final boolean trySetSignal() {
        int i = this.status;
        return i >= 0 && U.compareAndSwapInt(this, STATUS, i, i | 65536);
    }

    private int externalAwaitDone() {
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        int iDoExec = this.status;
        if (iDoExec < 0) {
            return iDoExec;
        }
        if (forkJoinPool != null) {
            if (this instanceof CountedCompleter) {
                iDoExec = forkJoinPool.externalHelpComplete((CountedCompleter) this);
            } else if (forkJoinPool.tryExternalUnpush(this)) {
                iDoExec = doExec();
            }
        }
        if (iDoExec < 0) {
            return iDoExec;
        }
        int i = this.status;
        if (i < 0) {
            return i;
        }
        boolean z = false;
        int i2 = i;
        do {
            if (U.compareAndSwapInt(this, STATUS, i2, i2 | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    } else {
                        notifyAll();
                    }
                }
            }
            i2 = this.status;
        } while (i2 >= 0);
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i2;
    }

    private int externalInterruptibleAwaitDone() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.status >= 0 && forkJoinPool != null) {
            if (this instanceof CountedCompleter) {
                forkJoinPool.externalHelpComplete((CountedCompleter) this);
            } else if (forkJoinPool.tryExternalUnpush(this)) {
                doExec();
            }
        }
        while (true) {
            int i = this.status;
            if (i < 0) {
                return i;
            }
            if (U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        wait();
                    } else {
                        notifyAll();
                    }
                }
            }
        }
    }

    private int doJoin() {
        int iDoExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof ForkJoinWorkerThread)) {
            return externalAwaitDone();
        }
        ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
        ForkJoinPool.WorkQueue workQueue = forkJoinWorkerThread.workQueue;
        return (!workQueue.tryUnpush(this) || (iDoExec = doExec()) >= 0) ? forkJoinWorkerThread.pool.awaitJoin(workQueue, this) : iDoExec;
    }

    private int doInvoke() {
        int iDoExec = doExec();
        if (iDoExec < 0) {
            return iDoExec;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof ForkJoinWorkerThread)) {
            return externalAwaitDone();
        }
        ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
        return forkJoinWorkerThread.pool.awaitJoin(forkJoinWorkerThread.workQueue, this);
    }

    static final class ExceptionNode extends WeakReference<ForkJoinTask<?>> {
        final Throwable ex;
        ExceptionNode next;
        final long thrower;

        ExceptionNode(ForkJoinTask<?> forkJoinTask, Throwable th, ExceptionNode exceptionNode) {
            super(forkJoinTask, ForkJoinTask.exceptionTableRefQueue);
            this.ex = th;
            this.next = exceptionNode;
            this.thrower = Thread.currentThread().getId();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r2[r0] = new io.netty.util.internal.chmv8.ForkJoinTask.ExceptionNode(r5, r6, r2[r0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int recordExceptionalCompletion(java.lang.Throwable r6) {
        /*
            r5 = this;
            int r0 = r5.status
            if (r0 < 0) goto L3c
            int r0 = java.lang.System.identityHashCode(r5)
            java.util.concurrent.locks.ReentrantLock r1 = io.netty.util.internal.chmv8.ForkJoinTask.exceptionTableLock
            r1.lock()
            expungeStaleExceptions()     // Catch: java.lang.Throwable -> L37
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode[] r2 = io.netty.util.internal.chmv8.ForkJoinTask.exceptionTable     // Catch: java.lang.Throwable -> L37
            int r3 = r2.length     // Catch: java.lang.Throwable -> L37
            int r3 = r3 + (-1)
            r0 = r0 & r3
            r3 = r2[r0]     // Catch: java.lang.Throwable -> L37
        L18:
            if (r3 != 0) goto L24
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode r3 = new io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode     // Catch: java.lang.Throwable -> L37
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L37
            r3.<init>(r5, r6, r4)     // Catch: java.lang.Throwable -> L37
            r2[r0] = r3     // Catch: java.lang.Throwable -> L37
            goto L2d
        L24:
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L37
            if (r4 == r5) goto L2d
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode r3 = r3.next     // Catch: java.lang.Throwable -> L37
            goto L18
        L2d:
            r1.unlock()
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r5.setCompletion(r6)
            goto L3c
        L37:
            r6 = move-exception
            r1.unlock()
            throw r6
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinTask.recordExceptionalCompletion(java.lang.Throwable):int");
    }

    private int setExceptionalCompletion(Throwable th) {
        int iRecordExceptionalCompletion = recordExceptionalCompletion(th);
        if (((-268435456) & iRecordExceptionalCompletion) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return iRecordExceptionalCompletion;
    }

    static final void cancelIgnoringExceptions(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null || forkJoinTask.status < 0) {
            return;
        }
        try {
            forkJoinTask.cancel(false);
        } catch (Throwable unused) {
        }
    }

    private void clearExceptionalCompletion() {
        int iIdentityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            int length = iIdentityHashCode & (exceptionNodeArr.length - 1);
            ExceptionNode exceptionNode = exceptionNodeArr[length];
            ExceptionNode exceptionNode2 = null;
            while (true) {
                if (exceptionNode == null) {
                    break;
                }
                ExceptionNode exceptionNode3 = exceptionNode.next;
                if (exceptionNode.get() != this) {
                    exceptionNode2 = exceptionNode;
                    exceptionNode = exceptionNode3;
                } else if (exceptionNode2 == null) {
                    exceptionNodeArr[length] = exceptionNode3;
                } else {
                    exceptionNode2.next = exceptionNode3;
                }
            }
            expungeStaleExceptions();
            this.status = 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    private Throwable getThrowableException() {
        Throwable th;
        if ((this.status & (-268435456)) != Integer.MIN_VALUE) {
            return null;
        }
        int iIdentityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode exceptionNode = exceptionTable[iIdentityHashCode & (r3.length - 1)];
            while (exceptionNode != null) {
                if (exceptionNode.get() == this) {
                    break;
                }
                exceptionNode = exceptionNode.next;
            }
            if (exceptionNode == null || (th = exceptionNode.ex) == null) {
                return null;
            }
            return th;
        } finally {
            reentrantLock.unlock();
        }
    }

    private static void expungeStaleExceptions() {
        while (true) {
            Reference<? extends Object> referencePoll = exceptionTableRefQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof ExceptionNode) {
                ForkJoinTask forkJoinTask = (ForkJoinTask) ((ExceptionNode) referencePoll).get();
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int iIdentityHashCode = System.identityHashCode(forkJoinTask) & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[iIdentityHashCode];
                ExceptionNode exceptionNode2 = null;
                while (true) {
                    if (exceptionNode != null) {
                        ExceptionNode exceptionNode3 = exceptionNode.next;
                        if (exceptionNode != referencePoll) {
                            exceptionNode2 = exceptionNode;
                            exceptionNode = exceptionNode3;
                        } else if (exceptionNode2 == null) {
                            exceptionNodeArr[iIdentityHashCode] = exceptionNode3;
                        } else {
                            exceptionNode2.next = exceptionNode3;
                        }
                    }
                }
            }
        }
    }

    static final void helpExpungeStaleExceptions() {
        ReentrantLock reentrantLock = exceptionTableLock;
        if (reentrantLock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    static void rethrow(Throwable th) {
        if (th != null) {
            uncheckedThrow(th);
        }
    }

    static <T extends Throwable> void uncheckedThrow(Throwable th) throws Throwable {
        throw th;
    }

    private void reportException(int i) {
        if (i == CANCELLED) {
            throw new CancellationException();
        }
        if (i == Integer.MIN_VALUE) {
            rethrow(getThrowableException());
        }
    }

    public final ForkJoinTask<V> fork() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            ((ForkJoinWorkerThread) threadCurrentThread).workQueue.push(this);
        } else {
            ForkJoinPool.common.externalPush(this);
        }
        return this;
    }

    public final V join() {
        int iDoJoin = doJoin() & (-268435456);
        if (iDoJoin != -268435456) {
            reportException(iDoJoin);
        }
        return getRawResult();
    }

    public final V invoke() {
        int iDoInvoke = doInvoke() & (-268435456);
        if (iDoInvoke != -268435456) {
            reportException(iDoInvoke);
        }
        return getRawResult();
    }

    public static void invokeAll(ForkJoinTask<?> forkJoinTask, ForkJoinTask<?> forkJoinTask2) {
        forkJoinTask2.fork();
        int iDoInvoke = forkJoinTask.doInvoke() & (-268435456);
        if (iDoInvoke != -268435456) {
            forkJoinTask.reportException(iDoInvoke);
        }
        int iDoJoin = forkJoinTask2.doJoin() & (-268435456);
        if (iDoJoin != -268435456) {
            forkJoinTask2.reportException(iDoJoin);
        }
    }

    public static void invokeAll(ForkJoinTask<?>... forkJoinTaskArr) {
        int length = forkJoinTaskArr.length - 1;
        Throwable exception = null;
        for (int i = length; i >= 0; i--) {
            ForkJoinTask<?> forkJoinTask = forkJoinTaskArr[i];
            if (forkJoinTask == null) {
                if (exception == null) {
                    exception = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.doInvoke() < -268435456 && exception == null) {
                exception = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= length; i2++) {
            ForkJoinTask<?> forkJoinTask2 = forkJoinTaskArr[i2];
            if (forkJoinTask2 != null) {
                if (exception != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.doJoin() < -268435456) {
                    exception = forkJoinTask2.getException();
                }
            }
        }
        if (exception != null) {
            rethrow(exception);
        }
    }

    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> collection) {
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            invokeAll((ForkJoinTask<?>[]) collection.toArray(new ForkJoinTask[collection.size()]));
            return collection;
        }
        List list = (List) collection;
        int size = list.size() - 1;
        Throwable exception = null;
        for (int i = size; i >= 0; i--) {
            ForkJoinTask forkJoinTask = (ForkJoinTask) list.get(i);
            if (forkJoinTask == null) {
                if (exception == null) {
                    exception = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.doInvoke() < -268435456 && exception == null) {
                exception = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= size; i2++) {
            ForkJoinTask forkJoinTask2 = (ForkJoinTask) list.get(i2);
            if (forkJoinTask2 != null) {
                if (exception != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.doJoin() < -268435456) {
                    exception = forkJoinTask2.getException();
                }
            }
        }
        if (exception != null) {
            rethrow(exception);
        }
        return collection;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (setCompletion(CANCELLED) & (-268435456)) == CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & (-268435456)) == CANCELLED;
    }

    public final boolean isCompletedAbnormally() {
        return this.status < -268435456;
    }

    public final boolean isCompletedNormally() {
        return (this.status & (-268435456)) == -268435456;
    }

    public final Throwable getException() {
        int i = this.status & (-268435456);
        if (i >= -268435456) {
            return null;
        }
        return i == CANCELLED ? new CancellationException() : getThrowableException();
    }

    public void completeExceptionally(Throwable th) {
        if (!(th instanceof RuntimeException) && !(th instanceof Error)) {
            th = new RuntimeException(th);
        }
        setExceptionalCompletion(th);
    }

    public void complete(V v) {
        try {
            setRawResult(v);
            setCompletion(-268435456);
        } catch (Throwable th) {
            setExceptionalCompletion(th);
        }
    }

    public final void quietlyComplete() {
        setCompletion(-268435456);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException {
        Throwable throwableException;
        int iDoJoin = (Thread.currentThread() instanceof ForkJoinWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & (-268435456);
        if (iDoJoin == CANCELLED) {
            throw new CancellationException();
        }
        if (iDoJoin == Integer.MIN_VALUE && (throwableException = getThrowableException()) != null) {
            throw new ExecutionException(throwableException);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws Throwable {
        ForkJoinPool forkJoinPool;
        ForkJoinPool.WorkQueue workQueue;
        boolean z;
        int i;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        long nanos = timeUnit.toNanos(j);
        int i2 = this.status;
        if (i2 >= 0 && nanos > 0) {
            long jNanoTime = System.nanoTime() + nanos;
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread instanceof ForkJoinWorkerThread) {
                ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
                ForkJoinPool forkJoinPool2 = forkJoinWorkerThread.pool;
                ForkJoinPool.WorkQueue workQueue2 = forkJoinWorkerThread.workQueue;
                forkJoinPool2.helpJoinOnce(workQueue2, this);
                workQueue = workQueue2;
                forkJoinPool = forkJoinPool2;
            } else {
                ForkJoinPool forkJoinPool3 = ForkJoinPool.common;
                if (forkJoinPool3 != null) {
                    if (this instanceof CountedCompleter) {
                        forkJoinPool3.externalHelpComplete((CountedCompleter) this);
                    } else if (forkJoinPool3.tryExternalUnpush(this)) {
                        doExec();
                    }
                }
                forkJoinPool = null;
                workQueue = null;
            }
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                try {
                    int i3 = this.status;
                    if (i3 < 0) {
                        z = z2;
                        i2 = i3;
                        break;
                    }
                    if (workQueue != null && workQueue.qlock < 0) {
                        cancelIgnoringExceptions(this);
                    } else if (!z2) {
                        if (forkJoinPool == null || forkJoinPool.tryCompensate(forkJoinPool.ctl)) {
                            z2 = true;
                        }
                    } else {
                        long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
                        if (millis > 0) {
                            z = z2;
                            try {
                                if (U.compareAndSwapInt(this, STATUS, i3, i3 | 65536)) {
                                    synchronized (this) {
                                        if (this.status >= 0) {
                                            try {
                                                wait(millis);
                                            } catch (InterruptedException unused) {
                                                if (forkJoinPool == null) {
                                                    z3 = true;
                                                }
                                            }
                                        } else {
                                            notifyAll();
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (forkJoinPool != null && z) {
                                    forkJoinPool.incrementActiveCount();
                                }
                                throw th;
                            }
                        } else {
                            z = z2;
                        }
                        i = this.status;
                        if (i < 0 || z3) {
                            break;
                        }
                        long jNanoTime2 = jNanoTime - System.nanoTime();
                        if (jNanoTime2 <= 0) {
                            break;
                        }
                        z2 = z;
                        nanos = jNanoTime2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = z2;
                }
            }
            i2 = i;
            if (forkJoinPool != null && z) {
                forkJoinPool.incrementActiveCount();
            }
            if (z3) {
                throw new InterruptedException();
            }
        }
        int i4 = i2 & (-268435456);
        if (i4 != -268435456) {
            if (i4 == CANCELLED) {
                throw new CancellationException();
            }
            if (i4 != Integer.MIN_VALUE) {
                throw new TimeoutException();
            }
            Throwable throwableException = getThrowableException();
            if (throwableException != null) {
                throw new ExecutionException(throwableException);
            }
        }
        return getRawResult();
    }

    public final void quietlyJoin() {
        doJoin();
    }

    public final void quietlyInvoke() {
        doInvoke();
    }

    public static void helpQuiesce() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
            forkJoinWorkerThread.pool.helpQuiescePool(forkJoinWorkerThread.workQueue);
        } else {
            ForkJoinPool.quiesceCommonPool();
        }
    }

    public void reinitialize() {
        if ((this.status & (-268435456)) == Integer.MIN_VALUE) {
            clearExceptionalCompletion();
        } else {
            this.status = 0;
        }
    }

    public static ForkJoinPool getPool() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) threadCurrentThread).pool;
        }
        return null;
    }

    public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    public boolean tryUnfork() {
        Thread threadCurrentThread = Thread.currentThread();
        return threadCurrentThread instanceof ForkJoinWorkerThread ? ((ForkJoinWorkerThread) threadCurrentThread).workQueue.tryUnpush(this) : ForkJoinPool.common.tryExternalUnpush(this);
    }

    public static int getQueuedTaskCount() {
        ForkJoinPool.WorkQueue workQueueCommonSubmitterQueue;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            workQueueCommonSubmitterQueue = ((ForkJoinWorkerThread) threadCurrentThread).workQueue;
        } else {
            workQueueCommonSubmitterQueue = ForkJoinPool.commonSubmitterQueue();
        }
        if (workQueueCommonSubmitterQueue == null) {
            return 0;
        }
        return workQueueCommonSubmitterQueue.queueSize();
    }

    public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.getSurplusQueuedTaskCount();
    }

    protected static ForkJoinTask<?> peekNextLocalTask() {
        ForkJoinPool.WorkQueue workQueueCommonSubmitterQueue;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            workQueueCommonSubmitterQueue = ((ForkJoinWorkerThread) threadCurrentThread).workQueue;
        } else {
            workQueueCommonSubmitterQueue = ForkJoinPool.commonSubmitterQueue();
        }
        if (workQueueCommonSubmitterQueue == null) {
            return null;
        }
        return workQueueCommonSubmitterQueue.peek();
    }

    protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) threadCurrentThread).workQueue.nextLocalTask();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollTask() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof ForkJoinWorkerThread)) {
            return null;
        }
        ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
        return forkJoinWorkerThread.pool.nextTaskFor(forkJoinWorkerThread.workQueue);
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public final short setForkJoinTaskTag(short s) {
        Unsafe unsafe;
        long j;
        int i;
        do {
            unsafe = U;
            j = STATUS;
            i = this.status;
        } while (!unsafe.compareAndSwapInt(this, j, i, ((-65536) & i) | (65535 & s)));
        return (short) i;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i, (65535 & s2) | ((-65536) & i)));
        return true;
    }

    static final class AdaptedRunnable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        AdaptedRunnable(Runnable runnable, T t) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
            this.result = t;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }
    }

    static final class AdaptedRunnableAction extends ForkJoinTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r1) {
        }

        AdaptedRunnableAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }
    }

    static final class RunnableExecuteAction extends ForkJoinTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r1) {
        }

        RunnableExecuteAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        final void internalPropagateException(Throwable th) {
            rethrow(th);
        }
    }

    static final class AdaptedCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        AdaptedCallable(Callable<? extends T> callable) {
            if (callable == null) {
                throw new NullPointerException();
            }
            this.callable = callable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (Error e) {
                throw e;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }
    }

    public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T t) {
        return new AdaptedRunnable(runnable, t);
    }

    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable(callable);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        if (object != null) {
            setExceptionalCompletion((Throwable) object);
        }
    }

    static {
        try {
            U = getUnsafe();
            STATUS = U.objectFieldOffset(ForkJoinTask.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ForkJoinTask.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final Unsafe run() throws IllegalAccessException, IllegalArgumentException {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }
}
