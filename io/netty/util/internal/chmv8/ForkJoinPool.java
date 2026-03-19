package io.netty.util.internal.chmv8;

import androidx.core.location.LocationRequestCompat;
import io.netty.util.internal.ThreadLocalRandom;
import io.netty.util.internal.chmv8.ForkJoinTask;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ForkJoinPool extends AbstractExecutorService {
    private static final int ABASE;
    private static final long AC_MASK = -281474976710656L;
    private static final int AC_SHIFT = 48;
    private static final long AC_UNIT = 281474976710656L;
    private static final int ASHIFT;
    private static final long CTL;
    private static final int EC_SHIFT = 16;
    private static final int EVENMASK = 65534;
    private static final int E_MASK = Integer.MAX_VALUE;
    private static final int E_SEQ = 65536;
    private static final long FAST_IDLE_TIMEOUT = 200000000;
    static final int FIFO_QUEUE = 1;
    private static final long IDLE_TIMEOUT = 2000000000;
    private static final long INDEXSEED;
    private static final int INT_SIGN = Integer.MIN_VALUE;
    static final int LIFO_QUEUE = 0;
    private static final int MAX_CAP = 32767;
    private static final int MAX_HELP = 64;
    private static final long PARKBLOCKER;
    private static final long PLOCK;
    private static final int PL_LOCK = 2;
    private static final int PL_SIGNAL = 1;
    private static final int PL_SPINS = 256;
    private static final long QBASE;
    private static final long QLOCK;
    private static final int SEED_INCREMENT = 1640531527;
    static final int SHARED_QUEUE = -1;
    private static final int SHORT_SIGN = 32768;
    private static final int SHUTDOWN = Integer.MIN_VALUE;
    private static final int SMASK = 65535;
    private static final int SQMASK = 126;
    private static final long STEALCOUNT;
    private static final long STOP_BIT = 2147483648L;
    private static final int ST_SHIFT = 31;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    private static final long TIMEOUT_SLOP = 2000000;
    private static final Unsafe U;
    private static final int UAC_MASK = -65536;
    private static final int UAC_SHIFT = 16;
    private static final int UAC_UNIT = 65536;
    private static final int UTC_MASK = 65535;
    private static final int UTC_SHIFT = 0;
    private static final int UTC_UNIT = 1;
    static final ForkJoinPool common;
    static final int commonParallelism;
    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
    private static final RuntimePermission modifyThreadPermission;
    private static int poolNumberSequence;
    static final ThreadLocal<Submitter> submitters;
    volatile long ctl;
    final ForkJoinWorkerThreadFactory factory;
    volatile int indexSeed;
    final short mode;
    volatile long pad00;
    volatile long pad01;
    volatile long pad02;
    volatile long pad03;
    volatile long pad04;
    volatile long pad05;
    volatile long pad06;
    volatile Object pad10;
    volatile Object pad11;
    volatile Object pad12;
    volatile Object pad13;
    volatile Object pad14;
    volatile Object pad15;
    volatile Object pad16;
    volatile Object pad17;
    volatile Object pad18;
    volatile Object pad19;
    volatile Object pad1a;
    volatile Object pad1b;
    final short parallelism;
    volatile int plock;
    volatile long stealCount;
    final Thread.UncaughtExceptionHandler ueh;
    WorkQueue[] workQueues;
    final String workerNamePrefix;

    public interface ForkJoinWorkerThreadFactory {
        ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool);
    }

    public interface ManagedBlocker {
        boolean block();

        boolean isReleasable();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    private static void checkPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
    }

    static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        DefaultForkJoinWorkerThreadFactory() {
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
            return new ForkJoinWorkerThread(forkJoinPool);
        }
    }

    static final class EmptyTask extends ForkJoinTask<Void> {
        private static final long serialVersionUID = -7721805057305804111L;

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r1) {
        }

        EmptyTask() {
            this.status = -268435456;
        }
    }

    static final class WorkQueue {
        private static final int ABASE;
        private static final int ASHIFT;
        static final int INITIAL_QUEUE_CAPACITY = 8192;
        static final int MAXIMUM_QUEUE_CAPACITY = 67108864;
        private static final long QBASE;
        private static final long QLOCK;
        private static final Unsafe U;
        ForkJoinTask<?>[] array;
        volatile ForkJoinTask<?> currentJoin;
        ForkJoinTask<?> currentSteal;
        volatile int eventCount;
        int hint;
        final short mode;
        int nextWait;
        int nsteals;
        final ForkJoinWorkerThread owner;
        volatile long pad00;
        volatile long pad01;
        volatile long pad02;
        volatile long pad03;
        volatile long pad04;
        volatile long pad05;
        volatile long pad06;
        volatile Object pad10;
        volatile Object pad11;
        volatile Object pad12;
        volatile Object pad13;
        volatile Object pad14;
        volatile Object pad15;
        volatile Object pad16;
        volatile Object pad17;
        volatile Object pad18;
        volatile Object pad19;
        volatile Object pad1a;
        volatile Object pad1b;
        volatile Object pad1c;
        volatile Object pad1d;
        volatile Thread parker;
        final ForkJoinPool pool;
        short poolIndex;
        volatile int qlock;
        int top = 4096;
        volatile int base = 4096;

        WorkQueue(ForkJoinPool forkJoinPool, ForkJoinWorkerThread forkJoinWorkerThread, int i, int i2) {
            this.pool = forkJoinPool;
            this.owner = forkJoinWorkerThread;
            this.mode = (short) i;
            this.hint = i2;
        }

        final int queueSize() {
            int i = this.base - this.top;
            if (i >= 0) {
                return 0;
            }
            return -i;
        }

        final boolean isEmpty() {
            int length;
            int i = this.base - this.top;
            if (i < 0) {
                if (i != -1) {
                    return false;
                }
                ForkJoinTask<?>[] forkJoinTaskArr = this.array;
                if (forkJoinTaskArr != null && (length = forkJoinTaskArr.length - 1) >= 0 && U.getObject(forkJoinTaskArr, (((r1 - 1) & length) << ASHIFT) + ABASE) != null) {
                    return false;
                }
            }
            return true;
        }

        final void push(ForkJoinTask<?> forkJoinTask) {
            int i = this.top;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr != null) {
                int length = forkJoinTaskArr.length - 1;
                U.putOrderedObject(forkJoinTaskArr, ((length & i) << ASHIFT) + ABASE, forkJoinTask);
                int i2 = i + 1;
                this.top = i2;
                int i3 = i2 - this.base;
                if (i3 <= 2) {
                    ForkJoinPool forkJoinPool = this.pool;
                    forkJoinPool.signalWork(forkJoinPool.workQueues, this);
                } else if (i3 >= length) {
                    growArray();
                }
            }
        }

        final ForkJoinTask<?>[] growArray() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            int length2 = forkJoinTaskArr != null ? forkJoinTaskArr.length << 1 : 8192;
            if (length2 > 67108864) {
                throw new RejectedExecutionException("Queue capacity exceeded");
            }
            ForkJoinTask<?>[] forkJoinTaskArr2 = new ForkJoinTask[length2];
            this.array = forkJoinTaskArr2;
            if (forkJoinTaskArr != null && forkJoinTaskArr.length - 1 >= 0) {
                int i = this.top;
                int i2 = this.base;
                if (i - i2 > 0) {
                    int i3 = length2 - 1;
                    int i4 = i2;
                    do {
                        int i5 = ASHIFT;
                        int i6 = ABASE;
                        int i7 = ((i4 & i3) << i5) + i6;
                        long j = ((i4 & length) << i5) + i6;
                        ForkJoinTask forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, j);
                        if (forkJoinTask != null && U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                            U.putObjectVolatile(forkJoinTaskArr2, i7, forkJoinTask);
                        }
                        i4++;
                    } while (i4 != i);
                }
            }
            return forkJoinTaskArr2;
        }

        final ForkJoinTask<?> pop() {
            int length;
            int i;
            long j;
            ForkJoinTask<?> forkJoinTask;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || forkJoinTaskArr.length - 1 < 0) {
                return null;
            }
            do {
                i = this.top - 1;
                if (i - this.base < 0) {
                    return null;
                }
                j = ((length & i) << ASHIFT) + ABASE;
                forkJoinTask = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                if (forkJoinTask == null) {
                    return null;
                }
            } while (!U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null));
            this.top = i;
            return forkJoinTask;
        }

        final ForkJoinTask<?> pollAt(int i) {
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null) {
                return null;
            }
            long length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
            ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length);
            if (forkJoinTask == null || this.base != i || !U.compareAndSwapObject(forkJoinTaskArr, length, forkJoinTask, (Object) null)) {
                return null;
            }
            U.putOrderedInt(this, QBASE, i + 1);
            return forkJoinTask;
        }

        final ForkJoinTask<?> poll() {
            ForkJoinTask<?>[] forkJoinTaskArr;
            while (true) {
                int i = this.base;
                if (i - this.top >= 0 || (forkJoinTaskArr = this.array) == null) {
                    return null;
                }
                long length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length);
                if (forkJoinTask != null) {
                    if (U.compareAndSwapObject(forkJoinTaskArr, length, forkJoinTask, (Object) null)) {
                        U.putOrderedInt(this, QBASE, i + 1);
                        return forkJoinTask;
                    }
                } else if (this.base != i) {
                    continue;
                } else {
                    if (i + 1 == this.top) {
                        return null;
                    }
                    Thread.yield();
                }
            }
        }

        final ForkJoinTask<?> nextLocalTask() {
            return this.mode == 0 ? pop() : poll();
        }

        final ForkJoinTask<?> peek() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || forkJoinTaskArr.length - 1 < 0) {
                return null;
            }
            return (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, ((length & (this.mode == 0 ? this.top - 1 : this.base)) << ASHIFT) + ABASE);
        }

        final boolean tryUnpush(ForkJoinTask<?> forkJoinTask) {
            int i;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (i = this.top) == this.base) {
                return false;
            }
            int i2 = i - 1;
            if (!U.compareAndSwapObject(forkJoinTaskArr, (((forkJoinTaskArr.length - 1) & i2) << ASHIFT) + ABASE, forkJoinTask, (Object) null)) {
                return false;
            }
            this.top = i2;
            return true;
        }

        final void cancelAll() {
            ForkJoinTask.cancelIgnoringExceptions(this.currentJoin);
            ForkJoinTask.cancelIgnoringExceptions(this.currentSteal);
            while (true) {
                ForkJoinTask<?> forkJoinTaskPoll = poll();
                if (forkJoinTaskPoll == null) {
                    return;
                } else {
                    ForkJoinTask.cancelIgnoringExceptions(forkJoinTaskPoll);
                }
            }
        }

        final void pollAndExecAll() {
            while (true) {
                ForkJoinTask<?> forkJoinTaskPoll = poll();
                if (forkJoinTaskPoll == null) {
                    return;
                } else {
                    forkJoinTaskPoll.doExec();
                }
            }
        }

        final void runTask(ForkJoinTask<?> forkJoinTask) {
            this.currentSteal = forkJoinTask;
            if (forkJoinTask == null) {
                return;
            }
            forkJoinTask.doExec();
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            short s = this.mode;
            this.nsteals++;
            this.currentSteal = null;
            if (s != 0) {
                pollAndExecAll();
                return;
            }
            if (forkJoinTaskArr == null) {
                return;
            }
            int length = forkJoinTaskArr.length - 1;
            while (true) {
                int i = this.top - 1;
                if (i - this.base < 0) {
                    return;
                }
                long j = ((length & i) << ASHIFT) + ABASE;
                ForkJoinTask forkJoinTask2 = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                if (forkJoinTask2 == null) {
                    return;
                }
                if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask2, (Object) null)) {
                    this.top = i;
                    forkJoinTask2.doExec();
                }
            }
        }

        final boolean tryRemoveAndExec(ForkJoinTask<?> forkJoinTask) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i;
            int i2;
            boolean zCompareAndSwapObject = false;
            if (forkJoinTask == null || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            boolean z = true;
            int length = forkJoinTaskArr.length - 1;
            if (length < 0 || (i = (i = this.top) - (i2 = this.base)) <= 0) {
                return false;
            }
            boolean z2 = true;
            while (true) {
                int i3 = i - 1;
                long j = ((i3 & length) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask2 = (ForkJoinTask) U.getObject(forkJoinTaskArr, j);
                if (forkJoinTask2 == null) {
                    break;
                }
                if (forkJoinTask2 == forkJoinTask) {
                    if (i3 + 1 == this.top) {
                        if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                            this.top = i3;
                            zCompareAndSwapObject = true;
                        }
                    } else if (this.base == i2) {
                        zCompareAndSwapObject = U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, new EmptyTask());
                    }
                } else {
                    if (forkJoinTask2.status >= 0) {
                        z2 = false;
                    } else if (i3 + 1 == this.top) {
                        if (U.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask2, (Object) null)) {
                            this.top = i3;
                        }
                    }
                    int i4 = i4 - 1;
                    if (i4 != 0) {
                        i = i3;
                    } else if (!z2 && this.base == i2) {
                        z = false;
                    }
                }
            }
            if (zCompareAndSwapObject) {
                forkJoinTask.doExec();
            }
            return z;
        }

        final boolean pollAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i = this.base;
            if (i - this.top >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            long length = (((forkJoinTaskArr.length - 1) & i) << ASHIFT) + ABASE;
            Object objectVolatile = U.getObjectVolatile(forkJoinTaskArr, length);
            if (objectVolatile == null) {
                return true;
            }
            if (!(objectVolatile instanceof CountedCompleter)) {
                return false;
            }
            CountedCompleter<?> countedCompleter2 = (CountedCompleter) objectVolatile;
            CountedCompleter<?> countedCompleter3 = countedCompleter2;
            while (countedCompleter3 != countedCompleter) {
                countedCompleter3 = countedCompleter3.completer;
                if (countedCompleter3 == null) {
                    return false;
                }
            }
            if (this.base == i && U.compareAndSwapObject(forkJoinTaskArr, length, countedCompleter2, (Object) null)) {
                U.putOrderedInt(this, QBASE, i + 1);
                countedCompleter2.doExec();
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final boolean externalPopAndExecCC(io.netty.util.internal.chmv8.CountedCompleter<?> r18) {
            /*
                r17 = this;
                r6 = r17
                int r0 = r6.base
                int r7 = r6.top
                int r0 = r0 - r7
                r8 = 0
                if (r0 >= 0) goto L65
                io.netty.util.internal.chmv8.ForkJoinTask<?>[] r10 = r6.array
                if (r10 == 0) goto L65
                int r0 = r10.length
                r15 = 1
                int r0 = r0 - r15
                int r14 = r7 + (-1)
                r0 = r0 & r14
                int r1 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.ASHIFT
                int r0 = r0 << r1
                int r1 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.ABASE
                int r0 = r0 + r1
                long r11 = (long) r0
                sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.U
                java.lang.Object r0 = r0.getObject(r10, r11)
                boolean r1 = r0 instanceof io.netty.util.internal.chmv8.CountedCompleter
                if (r1 == 0) goto L65
                r16 = r0
                io.netty.util.internal.chmv8.CountedCompleter r16 = (io.netty.util.internal.chmv8.CountedCompleter) r16
                r0 = r18
                r1 = r16
            L2d:
                if (r1 != r0) goto L5d
                sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.U
                long r2 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.QLOCK
                r4 = 0
                r5 = 1
                r1 = r17
                boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
                if (r0 == 0) goto L5c
                int r0 = r6.top
                if (r0 != r7) goto L5a
                io.netty.util.internal.chmv8.ForkJoinTask<?>[] r0 = r6.array
                if (r0 != r10) goto L5a
                sun.misc.Unsafe r9 = io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.U
                r0 = 0
                r13 = r16
                r2 = r14
                r14 = r0
                boolean r0 = r9.compareAndSwapObject(r10, r11, r13, r14)
                if (r0 == 0) goto L5a
                r6.top = r2
                r6.qlock = r8
                r16.doExec()
                goto L5c
            L5a:
                r6.qlock = r8
            L5c:
                return r15
            L5d:
                r2 = r14
                io.netty.util.internal.chmv8.CountedCompleter<?> r1 = r1.completer
                if (r1 != 0) goto L63
                goto L65
            L63:
                r14 = r2
                goto L2d
            L65:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue.externalPopAndExecCC(io.netty.util.internal.chmv8.CountedCompleter):boolean");
        }

        final boolean internalPopAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i = this.base;
            int i2 = this.top;
            if (i - i2 >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            int i3 = i2 - 1;
            long length = (((forkJoinTaskArr.length - 1) & i3) << ASHIFT) + ABASE;
            Object object = U.getObject(forkJoinTaskArr, length);
            if (!(object instanceof CountedCompleter)) {
                return false;
            }
            CountedCompleter<?> countedCompleter2 = (CountedCompleter) object;
            CountedCompleter<?> countedCompleter3 = countedCompleter2;
            while (countedCompleter3 != countedCompleter) {
                countedCompleter3 = countedCompleter3.completer;
                if (countedCompleter3 == null) {
                    return false;
                }
            }
            if (U.compareAndSwapObject(forkJoinTaskArr, length, countedCompleter2, (Object) null)) {
                this.top = i3;
                countedCompleter2.doExec();
            }
            return true;
        }

        final boolean isApparentlyUnblocked() {
            ForkJoinWorkerThread forkJoinWorkerThread;
            Thread.State state;
            return (this.eventCount < 0 || (forkJoinWorkerThread = this.owner) == null || (state = forkJoinWorkerThread.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) ? false : true;
        }

        static {
            try {
                U = ForkJoinPool.getUnsafe();
                QBASE = U.objectFieldOffset(WorkQueue.class.getDeclaredField("base"));
                QLOCK = U.objectFieldOffset(WorkQueue.class.getDeclaredField("qlock"));
                ABASE = U.arrayBaseOffset(ForkJoinTask[].class);
                int iArrayIndexScale = U.arrayIndexScale(ForkJoinTask[].class);
                if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                    throw new Error("data type scale not a power of two");
                }
                ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    private static final synchronized int nextPoolId() {
        int i;
        i = poolNumberSequence + 1;
        poolNumberSequence = i;
        return i;
    }

    private int acquirePlock() {
        int i = 256;
        while (true) {
            int i2 = this.plock;
            if ((i2 & 2) == 0) {
                int i3 = i2 + 2;
                if (U.compareAndSwapInt(this, PLOCK, i2, i3)) {
                    return i3;
                }
            }
            if (i >= 0) {
                if (ThreadLocalRandom.current().nextInt() >= 0) {
                    i--;
                }
            } else if (U.compareAndSwapInt(this, PLOCK, i2, i2 | 1)) {
                synchronized (this) {
                    if ((this.plock & 1) != 0) {
                        try {
                            try {
                                wait();
                            } catch (SecurityException unused) {
                            }
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        notifyAll();
                    }
                }
            } else {
                continue;
            }
        }
    }

    private void releasePlock(int i) {
        this.plock = i;
        synchronized (this) {
            notifyAll();
        }
    }

    private void tryAddWorker() {
        long j;
        int i;
        int i2;
        ForkJoinWorkerThread forkJoinWorkerThreadNewThread;
        do {
            j = this.ctl;
            i = (int) (j >>> 32);
            if (i >= 0 || (32768 & i) == 0 || (i2 = (int) j) < 0) {
                return;
            }
        } while (!U.compareAndSwapLong(this, CTL, j, ((((i + 65536) & (-65536)) | ((i + 1) & 65535)) << 32) | i2));
        Throwable th = null;
        try {
            ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
            if (forkJoinWorkerThreadFactory != null) {
                forkJoinWorkerThreadNewThread = forkJoinWorkerThreadFactory.newThread(this);
                if (forkJoinWorkerThreadNewThread != null) {
                    try {
                        forkJoinWorkerThreadNewThread.start();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } else {
                forkJoinWorkerThreadNewThread = null;
            }
        } catch (Throwable th3) {
            forkJoinWorkerThreadNewThread = null;
            th = th3;
        }
        deregisterWorker(forkJoinWorkerThreadNewThread, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue registerWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread r13) {
        /*
            r12 = this;
            r0 = 1
            r13.setDaemon(r0)
            java.lang.Thread$UncaughtExceptionHandler r1 = r12.ueh
            if (r1 == 0) goto Lb
            r13.setUncaughtExceptionHandler(r1)
        Lb:
            sun.misc.Unsafe r2 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r4 = io.netty.util.internal.chmv8.ForkJoinPool.INDEXSEED
            int r6 = r12.indexSeed
            r1 = 1640531527(0x61c88647, float:4.6237806E20)
            int r1 = r1 + r6
            r3 = r12
            r7 = r1
            boolean r2 = r2.compareAndSwapInt(r3, r4, r6, r7)
            if (r2 == 0) goto Lb
            if (r1 == 0) goto Lb
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue r2 = new io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue
            short r3 = r12.mode
            r2.<init>(r12, r13, r3, r1)
            int r8 = r12.plock
            r3 = r8 & 2
            if (r3 != 0) goto L3a
            sun.misc.Unsafe r4 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r6 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            int r3 = r8 + 2
            r5 = r12
            r9 = r3
            boolean r4 = r4.compareAndSwapInt(r5, r6, r8, r9)
            if (r4 != 0) goto L3e
        L3a:
            int r3 = r12.acquirePlock()
        L3e:
            r8 = r3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r8
            int r4 = r8 + 2
            r5 = 2147483647(0x7fffffff, float:NaN)
            r4 = r4 & r5
            r3 = r3 | r4
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r4 = r12.workQueues     // Catch: java.lang.Throwable -> La4
            if (r4 == 0) goto L83
            int r5 = r4.length     // Catch: java.lang.Throwable -> La4
            int r6 = r5 + (-1)
            int r1 = r1 << r0
            r1 = r1 | r0
            r1 = r1 & r6
            r7 = r4[r1]     // Catch: java.lang.Throwable -> La4
            if (r7 == 0) goto L7c
            r7 = 4
            r9 = 2
            if (r5 > r7) goto L5c
            goto L63
        L5c:
            int r7 = r5 >>> 1
            r10 = 65534(0xfffe, float:9.1833E-41)
            r7 = r7 & r10
            int r9 = r9 + r7
        L63:
            r7 = 0
            r10 = r5
        L65:
            r5 = 0
        L66:
            int r1 = r1 + r9
            r1 = r1 & r6
            r11 = r4[r1]     // Catch: java.lang.Throwable -> La4
            if (r11 == 0) goto L7c
            int r5 = r5 + r0
            if (r5 < r10) goto L66
            int r10 = r10 << 1
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r10)     // Catch: java.lang.Throwable -> La4
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r4 = (io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue[]) r4     // Catch: java.lang.Throwable -> La4
            r12.workQueues = r4     // Catch: java.lang.Throwable -> La4
            int r6 = r10 + (-1)
            goto L65
        L7c:
            short r5 = (short) r1     // Catch: java.lang.Throwable -> La4
            r2.poolIndex = r5     // Catch: java.lang.Throwable -> La4
            r2.eventCount = r1     // Catch: java.lang.Throwable -> La4
            r4[r1] = r2     // Catch: java.lang.Throwable -> La4
        L83:
            sun.misc.Unsafe r4 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r6 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            r5 = r12
            r9 = r3
            boolean r1 = r4.compareAndSwapInt(r5, r6, r8, r9)
            if (r1 != 0) goto L92
            r12.releasePlock(r3)
        L92:
            java.lang.String r1 = r12.workerNamePrefix
            short r3 = r2.poolIndex
            int r0 = r3 >>> 1
            java.lang.String r0 = java.lang.Integer.toString(r0)
            java.lang.String r0 = r1.concat(r0)
            r13.setName(r0)
            return r2
        La4:
            r13 = move-exception
            sun.misc.Unsafe r4 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r6 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            r5 = r12
            r9 = r3
            boolean r0 = r4.compareAndSwapInt(r5, r6, r8, r9)
            if (r0 != 0) goto Lb4
            r12.releasePlock(r3)
        Lb4:
            goto Lb6
        Lb5:
            throw r13
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.registerWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread):io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void deregisterWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread r18, java.lang.Throwable r19) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.deregisterWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread, java.lang.Throwable):void");
    }

    static final class Submitter {
        int seed;

        Submitter(int i) {
            this.seed = i;
        }
    }

    final void externalPush(ForkJoinTask<?> forkJoinTask) {
        int length;
        int length2;
        int i;
        int i2;
        Submitter submitter = submitters.get();
        int i3 = this.plock;
        WorkQueue[] workQueueArr = this.workQueues;
        if (submitter != null && i3 > 0 && workQueueArr != null && (length = workQueueArr.length - 1) >= 0) {
            int i4 = submitter.seed;
            WorkQueue workQueue = workQueueArr[length & i4 & 126];
            if (workQueue != null && i4 != 0 && U.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
                ForkJoinTask<?>[] forkJoinTaskArr = workQueue.array;
                if (forkJoinTaskArr != null && (length2 = forkJoinTaskArr.length - 1) > (i2 = (i = workQueue.top) - workQueue.base)) {
                    U.putOrderedObject(forkJoinTaskArr, ((length2 & i) << ASHIFT) + ABASE, forkJoinTask);
                    workQueue.top = i + 1;
                    workQueue.qlock = 0;
                    if (i2 <= 1) {
                        signalWork(workQueueArr, workQueue);
                        return;
                    }
                    return;
                }
                workQueue.qlock = 0;
            }
        }
        fullExternalPush(forkJoinTask);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[Catch: all -> 0x00a6, TryCatch #0 {all -> 0x00a6, blocks: (B:29:0x0077, B:33:0x0085, B:31:0x007f), top: B:92:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085 A[Catch: all -> 0x00a6, PHI: r2
  0x0085: PHI (r2v13 io.netty.util.internal.chmv8.ForkJoinTask<?>[]) = (r2v12 io.netty.util.internal.chmv8.ForkJoinTask<?>[]), (r2v14 io.netty.util.internal.chmv8.ForkJoinTask<?>[]) binds: [B:30:0x007d, B:32:0x0083] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x00a6, blocks: (B:29:0x0077, B:33:0x0085, B:31:0x007f), top: B:92:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fullExternalPush(io.netty.util.internal.chmv8.ForkJoinTask<?> r20) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.fullExternalPush(io.netty.util.internal.chmv8.ForkJoinTask):void");
    }

    final void incrementActiveCount() {
        Unsafe unsafe;
        long j;
        long j2;
        do {
            unsafe = U;
            j = CTL;
            j2 = this.ctl;
        } while (!unsafe.compareAndSwapLong(this, j, j2, (281474976710655L & j2) | ((AC_MASK & j2) + AC_UNIT)));
    }

    final void signalWork(WorkQueue[] workQueueArr, WorkQueue workQueue) {
        int i;
        WorkQueue workQueue2;
        while (true) {
            long j = this.ctl;
            int i2 = (int) (j >>> 32);
            if (i2 >= 0) {
                return;
            }
            int i3 = (int) j;
            if (i3 <= 0) {
                if (((short) i2) < 0) {
                    tryAddWorker();
                    return;
                }
                return;
            }
            if (workQueueArr == null || workQueueArr.length <= (i = 65535 & i3) || (workQueue2 = workQueueArr[i]) == null) {
                return;
            }
            long j2 = (workQueue2.nextWait & Integer.MAX_VALUE) | ((i2 + 65536) << 32);
            int i4 = (65536 + i3) & Integer.MAX_VALUE;
            if (workQueue2.eventCount == (i3 | Integer.MIN_VALUE) && U.compareAndSwapLong(this, CTL, j, j2)) {
                workQueue2.eventCount = i4;
                Thread thread = workQueue2.parker;
                if (thread != null) {
                    U.unpark(thread);
                    return;
                }
                return;
            }
            if (workQueue != null && workQueue.base >= workQueue.top) {
                return;
            }
        }
    }

    final void runWorker(WorkQueue workQueue) {
        workQueue.growArray();
        int i = workQueue.hint;
        while (scan(workQueue, i) == 0) {
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >>> 17);
            i = i3 ^ (i3 << 5);
        }
    }

    private final int scan(WorkQueue workQueue, int i) {
        int length;
        ForkJoinTask<?>[] forkJoinTaskArr;
        long j = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null || workQueueArr.length - 1 < 0 || workQueue == null) {
            return 0;
        }
        int i2 = length + length + 1;
        int i3 = workQueue.eventCount;
        do {
            WorkQueue workQueue2 = workQueueArr[(i - i2) & length];
            if (workQueue2 != null) {
                int i4 = workQueue2.base;
                if (i4 - workQueue2.top < 0 && (forkJoinTaskArr = workQueue2.array) != null) {
                    long length2 = (((forkJoinTaskArr.length - 1) & i4) << ASHIFT) + ABASE;
                    ForkJoinTask<?> forkJoinTask = (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, length2);
                    if (forkJoinTask == null) {
                        return 0;
                    }
                    if (i3 < 0) {
                        helpRelease(j, workQueueArr, workQueue, workQueue2, i4);
                        return 0;
                    }
                    if (workQueue2.base != i4 || !U.compareAndSwapObject(forkJoinTaskArr, length2, forkJoinTask, (Object) null)) {
                        return 0;
                    }
                    int i5 = i4 + 1;
                    U.putOrderedInt(workQueue2, QBASE, i5);
                    if (i5 - workQueue2.top < 0) {
                        signalWork(workQueueArr, workQueue2);
                    }
                    workQueue.runTask(forkJoinTask);
                    return 0;
                }
            }
            i2--;
        } while (i2 >= 0);
        int i6 = (int) j;
        if ((i3 | i6) < 0) {
            return awaitWork(workQueue, j, i3);
        }
        if (this.ctl != j) {
            return 0;
        }
        long j2 = (j - AC_UNIT) & (-4294967296L);
        workQueue.nextWait = i6;
        workQueue.eventCount = Integer.MIN_VALUE | i3;
        if (U.compareAndSwapLong(this, CTL, j, j2 | i3)) {
            return 0;
        }
        workQueue.eventCount = i3;
        return 0;
    }

    private final int awaitWork(WorkQueue workQueue, long j, int i) {
        long j2;
        long jNanoTime;
        Unsafe unsafe;
        long j3;
        long j4;
        int i2 = workQueue.qlock;
        if (i2 >= 0 && workQueue.eventCount == i && this.ctl == j && !Thread.interrupted()) {
            int i3 = (int) j;
            int i4 = (int) (j >>> 32);
            int i5 = (i4 >> 16) + this.parallelism;
            if (i3 < 0 || (i5 <= 0 && tryTerminate(false, false))) {
                workQueue.qlock = -1;
                return -1;
            }
            int i6 = workQueue.nsteals;
            if (i6 != 0) {
                workQueue.nsteals = 0;
                do {
                    unsafe = U;
                    j3 = STEALCOUNT;
                    j4 = this.stealCount;
                } while (!unsafe.compareAndSwapLong(this, j3, j4, i6 + j4));
            } else {
                long j5 = (i5 > 0 || i != (i3 | Integer.MIN_VALUE)) ? 0L : ((65536 + i4) << 32) | (workQueue.nextWait & Integer.MAX_VALUE);
                if (j5 != 0) {
                    j2 = (-((short) i4)) < 0 ? FAST_IDLE_TIMEOUT : (r1 + 1) * IDLE_TIMEOUT;
                    jNanoTime = (System.nanoTime() + j2) - TIMEOUT_SLOP;
                } else {
                    j2 = 0;
                    jNanoTime = 0;
                }
                if (workQueue.eventCount == i) {
                    long j6 = j5;
                    if (this.ctl == j) {
                        Thread threadCurrentThread = Thread.currentThread();
                        U.putObject(threadCurrentThread, PARKBLOCKER, this);
                        workQueue.parker = threadCurrentThread;
                        if (workQueue.eventCount == i && this.ctl == j) {
                            U.park(false, j2);
                        }
                        workQueue.parker = null;
                        U.putObject(threadCurrentThread, PARKBLOCKER, (Object) null);
                        if (j2 != 0 && this.ctl == j && jNanoTime - System.nanoTime() <= 0 && U.compareAndSwapLong(this, CTL, j, j6)) {
                            workQueue.qlock = -1;
                            return -1;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private final void helpRelease(long j, WorkQueue[] workQueueArr, WorkQueue workQueue, WorkQueue workQueue2, int i) {
        int i2;
        int i3;
        WorkQueue workQueue3;
        if (workQueue == null || workQueue.eventCount >= 0 || (i2 = (int) j) <= 0 || workQueueArr == null || workQueueArr.length <= (i3 = 65535 & i2) || (workQueue3 = workQueueArr[i3]) == null) {
            return;
        }
        if (this.ctl == j) {
            long j2 = (workQueue3.nextWait & Integer.MAX_VALUE) | ((((int) (j >>> 32)) + 65536) << 32);
            int i4 = (65536 + i2) & Integer.MAX_VALUE;
            if (workQueue2 != null && workQueue2.base == i && workQueue.eventCount < 0 && workQueue3.eventCount == (Integer.MIN_VALUE | i2) && U.compareAndSwapLong(this, CTL, j, j2)) {
                workQueue3.eventCount = i4;
                Thread thread = workQueue3.parker;
                if (thread != null) {
                    U.unpark(thread);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b1, code lost:
    
        return 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int tryHelpStealer(io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue r19, io.netty.util.internal.chmv8.ForkJoinTask<?> r20) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.tryHelpStealer(io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue, io.netty.util.internal.chmv8.ForkJoinTask):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[PHI: r4
  0x003b: PHI (r4v2 long) = (r4v1 long), (r4v4 long), (r4v1 long) binds: [B:12:0x001e, B:23:0x003a, B:18:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int helpComplete(io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue r11, io.netty.util.internal.chmv8.CountedCompleter<?> r12) {
        /*
            r10 = this;
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r0 = r10.workQueues
            if (r0 == 0) goto L3f
            int r1 = r0.length
            int r1 = r1 + (-1)
            if (r1 < 0) goto L3f
            if (r11 == 0) goto L3f
            if (r12 == 0) goto L3f
            short r2 = r11.poolIndex
            int r3 = r1 + r1
            int r3 = r3 + 1
            r4 = 0
            r6 = r3
        L16:
            int r7 = r12.status
            if (r7 < 0) goto L40
            boolean r7 = r11.internalPopAndExecCC(r12)
            if (r7 != 0) goto L3b
            int r7 = r12.status
            if (r7 < 0) goto L40
            r8 = r2 & r1
            r8 = r0[r8]
            if (r8 == 0) goto L30
            boolean r8 = r8.pollAndExecCC(r12)
            if (r8 != 0) goto L3b
        L30:
            int r6 = r6 + (-1)
            if (r6 >= 0) goto L3c
            long r8 = r10.ctl
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 == 0) goto L40
            r4 = r8
        L3b:
            r6 = r3
        L3c:
            int r2 = r2 + 2
            goto L16
        L3f:
            r7 = 0
        L40:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.helpComplete(io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue, io.netty.util.internal.chmv8.CountedCompleter):int");
    }

    final boolean tryCompensate(long j) {
        int length;
        ForkJoinWorkerThread forkJoinWorkerThreadNewThread;
        WorkQueue[] workQueueArr = this.workQueues;
        short s = this.parallelism;
        int i = (int) j;
        if (workQueueArr == null || (length = workQueueArr.length - 1) < 0 || i < 0 || this.ctl != j) {
            return false;
        }
        WorkQueue workQueue = workQueueArr[length & i];
        if (i != 0 && workQueue != null) {
            long j2 = (workQueue.nextWait & Integer.MAX_VALUE) | ((-4294967296L) & j);
            int i2 = (65536 + i) & Integer.MAX_VALUE;
            if (workQueue.eventCount != (i | Integer.MIN_VALUE) || !U.compareAndSwapLong(this, CTL, j, j2)) {
                return false;
            }
            workQueue.eventCount = i2;
            Thread thread = workQueue.parker;
            if (thread != null) {
                U.unpark(thread);
            }
            return true;
        }
        short s2 = (short) (j >>> 32);
        if (s2 >= 0 && ((int) (j >> 48)) + s > 1) {
            return U.compareAndSwapLong(this, CTL, j, ((j - AC_UNIT) & AC_MASK) | (281474976710655L & j));
        }
        if (s2 + s >= MAX_CAP) {
            return false;
        }
        if (!U.compareAndSwapLong(this, CTL, j, ((4294967296L + j) & TC_MASK) | ((-281470681743361L) & j))) {
            return false;
        }
        Throwable th = null;
        try {
            ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
            if (forkJoinWorkerThreadFactory != null) {
                forkJoinWorkerThreadNewThread = forkJoinWorkerThreadFactory.newThread(this);
                if (forkJoinWorkerThreadNewThread != null) {
                    try {
                        forkJoinWorkerThreadNewThread.start();
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        deregisterWorker(forkJoinWorkerThreadNewThread, th);
                        return false;
                    }
                }
            } else {
                forkJoinWorkerThreadNewThread = null;
            }
        } catch (Throwable th3) {
            th = th3;
            forkJoinWorkerThreadNewThread = null;
        }
        deregisterWorker(forkJoinWorkerThreadNewThread, th);
        return false;
    }

    final int awaitJoin(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        Unsafe unsafe;
        long j;
        long j2;
        if (forkJoinTask == null) {
            return 0;
        }
        int iTryHelpStealer = forkJoinTask.status;
        if (iTryHelpStealer < 0 || workQueue == null) {
            return iTryHelpStealer;
        }
        ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
        workQueue.currentJoin = forkJoinTask;
        while (workQueue.tryRemoveAndExec(forkJoinTask) && (iTryHelpStealer = forkJoinTask.status) >= 0) {
        }
        if (iTryHelpStealer >= 0 && (forkJoinTask instanceof CountedCompleter)) {
            iTryHelpStealer = helpComplete(workQueue, (CountedCompleter) forkJoinTask);
        }
        long j3 = 0;
        while (iTryHelpStealer >= 0) {
            iTryHelpStealer = forkJoinTask.status;
            if (iTryHelpStealer < 0) {
                break;
            }
            iTryHelpStealer = tryHelpStealer(workQueue, forkJoinTask);
            if (iTryHelpStealer == 0 && (iTryHelpStealer = forkJoinTask.status) >= 0) {
                if (!tryCompensate(j3)) {
                    j3 = this.ctl;
                } else {
                    if (forkJoinTask.trySetSignal() && (iTryHelpStealer = forkJoinTask.status) >= 0) {
                        synchronized (forkJoinTask) {
                            if (forkJoinTask.status >= 0) {
                                try {
                                    forkJoinTask.wait();
                                } catch (InterruptedException unused) {
                                }
                            } else {
                                forkJoinTask.notifyAll();
                            }
                        }
                    }
                    int i = iTryHelpStealer;
                    do {
                        unsafe = U;
                        j = CTL;
                        j2 = this.ctl;
                    } while (!unsafe.compareAndSwapLong(this, j, j2, (281474976710655L & j2) | ((AC_MASK & j2) + AC_UNIT)));
                    iTryHelpStealer = i;
                }
            }
        }
        workQueue.currentJoin = forkJoinTask2;
        return iTryHelpStealer;
    }

    final void helpJoinOnce(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        int i;
        if (workQueue == null || forkJoinTask == null || (i = forkJoinTask.status) < 0) {
            return;
        }
        ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
        workQueue.currentJoin = forkJoinTask;
        while (workQueue.tryRemoveAndExec(forkJoinTask) && (i = forkJoinTask.status) >= 0) {
        }
        if (i >= 0) {
            if (forkJoinTask instanceof CountedCompleter) {
                helpComplete(workQueue, (CountedCompleter) forkJoinTask);
            }
            while (forkJoinTask.status >= 0 && tryHelpStealer(workQueue, forkJoinTask) > 0) {
            }
        }
        workQueue.currentJoin = forkJoinTask2;
    }

    private WorkQueue findNonEmptyStealQueue() {
        int i;
        int length;
        int iNextInt = ThreadLocalRandom.current().nextInt();
        do {
            i = this.plock;
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null && workQueueArr.length - 1 >= 0) {
                for (int i2 = (length + 1) << 2; i2 >= 0; i2--) {
                    WorkQueue workQueue = workQueueArr[(((iNextInt - i2) << 1) | 1) & length];
                    if (workQueue != null && workQueue.base - workQueue.top < 0) {
                        return workQueue;
                    }
                }
            }
        } while (this.plock != i);
        return null;
    }

    final void helpQuiescePool(WorkQueue workQueue) {
        ForkJoinTask<?> forkJoinTaskPollAt;
        Unsafe unsafe;
        long j;
        long j2;
        ForkJoinTask<?> forkJoinTask = workQueue.currentSteal;
        boolean z = true;
        while (true) {
            ForkJoinTask<?> forkJoinTaskNextLocalTask = workQueue.nextLocalTask();
            if (forkJoinTaskNextLocalTask != null) {
                forkJoinTaskNextLocalTask.doExec();
            } else {
                WorkQueue workQueueFindNonEmptyStealQueue = findNonEmptyStealQueue();
                if (workQueueFindNonEmptyStealQueue != null) {
                    if (!z) {
                        do {
                            unsafe = U;
                            j = CTL;
                            j2 = this.ctl;
                        } while (!unsafe.compareAndSwapLong(this, j, j2, (j2 & 281474976710655L) | ((j2 & AC_MASK) + AC_UNIT)));
                        z = true;
                    }
                    int i = workQueueFindNonEmptyStealQueue.base;
                    if (i - workQueueFindNonEmptyStealQueue.top < 0 && (forkJoinTaskPollAt = workQueueFindNonEmptyStealQueue.pollAt(i)) != null) {
                        workQueue.currentSteal = forkJoinTaskPollAt;
                        forkJoinTaskPollAt.doExec();
                        workQueue.currentSteal = forkJoinTask;
                    }
                } else if (z) {
                    long j3 = this.ctl;
                    long j4 = ((j3 & AC_MASK) - AC_UNIT) | (j3 & 281474976710655L);
                    if (((int) (j4 >> 48)) + this.parallelism == 0) {
                        return;
                    }
                    if (U.compareAndSwapLong(this, CTL, j3, j4)) {
                        z = false;
                    }
                } else {
                    long j5 = this.ctl;
                    if (((int) (j5 >> 48)) + this.parallelism <= 0 && U.compareAndSwapLong(this, CTL, j5, (j5 & 281474976710655L) | ((j5 & AC_MASK) + AC_UNIT))) {
                        return;
                    }
                }
            }
        }
    }

    final ForkJoinTask<?> nextTaskFor(WorkQueue workQueue) {
        ForkJoinTask<?> forkJoinTaskPollAt;
        while (true) {
            ForkJoinTask<?> forkJoinTaskNextLocalTask = workQueue.nextLocalTask();
            if (forkJoinTaskNextLocalTask != null) {
                return forkJoinTaskNextLocalTask;
            }
            WorkQueue workQueueFindNonEmptyStealQueue = findNonEmptyStealQueue();
            if (workQueueFindNonEmptyStealQueue == null) {
                return null;
            }
            int i = workQueueFindNonEmptyStealQueue.base;
            if (i - workQueueFindNonEmptyStealQueue.top < 0 && (forkJoinTaskPollAt = workQueueFindNonEmptyStealQueue.pollAt(i)) != null) {
                return forkJoinTaskPollAt;
            }
        }
    }

    static int getSurplusQueuedTaskCount() {
        Thread threadCurrentThread = Thread.currentThread();
        int i = 0;
        if (!(threadCurrentThread instanceof ForkJoinWorkerThread)) {
            return 0;
        }
        ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
        ForkJoinPool forkJoinPool = forkJoinWorkerThread.pool;
        short s = forkJoinPool.parallelism;
        WorkQueue workQueue = forkJoinWorkerThread.workQueue;
        int i2 = workQueue.top - workQueue.base;
        int i3 = ((int) (forkJoinPool.ctl >> 48)) + s;
        int i4 = s >>> 1;
        if (i3 <= i4) {
            int i5 = i4 >>> 1;
            if (i3 > i5) {
                i = 1;
            } else {
                int i6 = i5 >>> 1;
                i = i3 > i6 ? 2 : i3 > (i6 >>> 1) ? 4 : 8;
            }
        }
        return i2 - i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tryTerminate(boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.tryTerminate(boolean, boolean):boolean");
    }

    static WorkQueue commonSubmitterQueue() {
        ForkJoinPool forkJoinPool;
        WorkQueue[] workQueueArr;
        int length;
        Submitter submitter = submitters.get();
        if (submitter == null || (forkJoinPool = common) == null || (workQueueArr = forkJoinPool.workQueues) == null || workQueueArr.length - 1 < 0) {
            return null;
        }
        return workQueueArr[submitter.seed & length & 126];
    }

    final boolean tryExternalUnpush(ForkJoinTask<?> forkJoinTask) {
        WorkQueue workQueue;
        ForkJoinTask<?>[] forkJoinTaskArr;
        Submitter submitter = submitters.get();
        WorkQueue[] workQueueArr = this.workQueues;
        if (submitter == null || workQueueArr == null) {
            return false;
        }
        boolean z = true;
        int length = workQueueArr.length - 1;
        if (length < 0 || (workQueue = workQueueArr[submitter.seed & length & 126]) == null) {
            return false;
        }
        int i = workQueue.base;
        int i2 = workQueue.top;
        if (i == i2 || (forkJoinTaskArr = workQueue.array) == null) {
            return false;
        }
        int i3 = i2 - 1;
        long length2 = (((forkJoinTaskArr.length - 1) & i3) << ASHIFT) + ABASE;
        if (U.getObject(forkJoinTaskArr, length2) != forkJoinTask || !U.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
            return false;
        }
        if (workQueue.top == i2 && workQueue.array == forkJoinTaskArr && U.compareAndSwapObject(forkJoinTaskArr, length2, forkJoinTask, (Object) null)) {
            workQueue.top = i3;
        } else {
            z = false;
        }
        workQueue.qlock = 0;
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d A[PHI: r5
  0x004d: PHI (r5v2 long) = (r5v1 long), (r5v4 long), (r5v1 long) binds: [B:14:0x0030, B:25:0x004c, B:20:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int externalHelpComplete(io.netty.util.internal.chmv8.CountedCompleter<?> r12) {
        /*
            r11 = this;
            java.lang.ThreadLocal<io.netty.util.internal.chmv8.ForkJoinPool$Submitter> r0 = io.netty.util.internal.chmv8.ForkJoinPool.submitters
            java.lang.Object r0 = r0.get()
            io.netty.util.internal.chmv8.ForkJoinPool$Submitter r0 = (io.netty.util.internal.chmv8.ForkJoinPool.Submitter) r0
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r1 = r11.workQueues
            if (r0 == 0) goto L51
            if (r1 == 0) goto L51
            int r2 = r1.length
            int r2 = r2 + (-1)
            if (r2 < 0) goto L51
            int r0 = r0.seed
            r3 = r0 & r2
            r3 = r3 & 126(0x7e, float:1.77E-43)
            r3 = r1[r3]
            if (r3 == 0) goto L51
            if (r12 == 0) goto L51
            int r4 = r2 + r2
            int r4 = r4 + 1
            r5 = 0
            r0 = r0 | 1
            r7 = r4
        L28:
            int r8 = r12.status
            if (r8 < 0) goto L52
            boolean r8 = r3.externalPopAndExecCC(r12)
            if (r8 != 0) goto L4d
            int r8 = r12.status
            if (r8 < 0) goto L52
            r9 = r0 & r2
            r9 = r1[r9]
            if (r9 == 0) goto L42
            boolean r9 = r9.pollAndExecCC(r12)
            if (r9 != 0) goto L4d
        L42:
            int r7 = r7 + (-1)
            if (r7 >= 0) goto L4e
            long r9 = r11.ctl
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L52
            r5 = r9
        L4d:
            r7 = r4
        L4e:
            int r0 = r0 + 2
            goto L28
        L51:
            r8 = 0
        L52:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.externalHelpComplete(io.netty.util.internal.chmv8.CountedCompleter):int");
    }

    public ForkJoinPool() {
        this(Math.min(MAX_CAP, Runtime.getRuntime().availableProcessors()), defaultForkJoinWorkerThreadFactory, null, false);
    }

    public ForkJoinPool(int i) {
        this(i, defaultForkJoinWorkerThreadFactory, null, false);
    }

    public ForkJoinPool(int i, ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this(checkParallelism(i), checkFactory(forkJoinWorkerThreadFactory), uncaughtExceptionHandler, z ? 1 : 0, "ForkJoinPool-" + nextPoolId() + "-worker-");
        checkPermission();
    }

    private static int checkParallelism(int i) {
        if (i <= 0 || i > MAX_CAP) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    private static ForkJoinWorkerThreadFactory checkFactory(ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) {
        if (forkJoinWorkerThreadFactory != null) {
            return forkJoinWorkerThreadFactory;
        }
        throw new NullPointerException();
    }

    private ForkJoinPool(int i, ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, int i2, String str) {
        this.workerNamePrefix = str;
        this.factory = forkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.mode = (short) i2;
        this.parallelism = (short) i;
        long j = -i;
        this.ctl = ((j << 32) & TC_MASK) | ((j << 48) & AC_MASK);
    }

    public static ForkJoinPool commonPool() {
        return common;
    }

    public <T> T invoke(ForkJoinTask<T> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
        return forkJoinTask.join();
    }

    public void execute(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ForkJoinTask<?> runnableExecuteAction;
        if (runnable == 0) {
            throw new NullPointerException();
        }
        if (runnable instanceof ForkJoinTask) {
            runnableExecuteAction = (ForkJoinTask) runnable;
        } else {
            runnableExecuteAction = new ForkJoinTask.RunnableExecuteAction(runnable);
        }
        externalPush(runnableExecuteAction);
    }

    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> forkJoinTask) {
        if (forkJoinTask == null) {
            throw new NullPointerException();
        }
        externalPush(forkJoinTask);
        return forkJoinTask;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Callable<T> callable) {
        ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
        externalPush(adaptedCallable);
        return adaptedCallable;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Runnable runnable, T t) {
        ForkJoinTask.AdaptedRunnable adaptedRunnable = new ForkJoinTask.AdaptedRunnable(runnable, t);
        externalPush(adaptedRunnable);
        return adaptedRunnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ForkJoinTask<?> submit(Runnable runnable) {
        ForkJoinTask<?> adaptedRunnableAction;
        if (runnable == 0) {
            throw new NullPointerException();
        }
        if (runnable instanceof ForkJoinTask) {
            adaptedRunnableAction = (ForkJoinTask) runnable;
        } else {
            adaptedRunnableAction = new ForkJoinTask.AdaptedRunnableAction(runnable);
        }
        externalPush(adaptedRunnableAction);
        return adaptedRunnableAction;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            Iterator<? extends Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(it.next());
                arrayList.add(adaptedCallable);
                externalPush(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ForkJoinTask) arrayList.get(i)).quietlyJoin();
            }
            return arrayList;
        } catch (Throwable th) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Future) arrayList.get(i2)).cancel(false);
            }
            throw th;
        }
    }

    public ForkJoinWorkerThreadFactory getFactory() {
        return this.factory;
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.ueh;
    }

    public int getParallelism() {
        short s = this.parallelism;
        if (s > 0) {
            return s;
        }
        return 1;
    }

    public static int getCommonPoolParallelism() {
        return commonParallelism;
    }

    public int getPoolSize() {
        return this.parallelism + ((short) (this.ctl >>> 32));
    }

    public boolean getAsyncMode() {
        return this.mode == 1;
    }

    public int getRunningThreadCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        int i = 0;
        if (workQueueArr != null) {
            for (int i2 = 1; i2 < workQueueArr.length; i2 += 2) {
                WorkQueue workQueue = workQueueArr[i2];
                if (workQueue != null && workQueue.isApparentlyUnblocked()) {
                    i++;
                }
            }
        }
        return i;
    }

    public int getActiveThreadCount() {
        int i = this.parallelism + ((int) (this.ctl >> 48));
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    public boolean isQuiescent() {
        return this.parallelism + ((int) (this.ctl >> 48)) <= 0;
    }

    public long getStealCount() {
        long j = this.stealCount;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i = 1; i < workQueueArr.length; i += 2) {
                if (workQueueArr[i] != null) {
                    j += r4.nsteals;
                }
            }
        }
        return j;
    }

    public long getQueuedTaskCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        long jQueueSize = 0;
        if (workQueueArr != null) {
            for (int i = 1; i < workQueueArr.length; i += 2) {
                if (workQueueArr[i] != null) {
                    jQueueSize += r4.queueSize();
                }
            }
        }
        return jQueueSize;
    }

    public int getQueuedSubmissionCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return 0;
        }
        int iQueueSize = 0;
        for (int i = 0; i < workQueueArr.length; i += 2) {
            WorkQueue workQueue = workQueueArr[i];
            if (workQueue != null) {
                iQueueSize += workQueue.queueSize();
            }
        }
        return iQueueSize;
    }

    public boolean hasQueuedSubmissions() {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i = 0; i < workQueueArr.length; i += 2) {
                WorkQueue workQueue = workQueueArr[i];
                if (workQueue != null && !workQueue.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected ForkJoinTask<?> pollSubmission() {
        ForkJoinTask<?> forkJoinTaskPoll;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return null;
        }
        for (int i = 0; i < workQueueArr.length; i += 2) {
            WorkQueue workQueue = workQueueArr[i];
            if (workQueue != null && (forkJoinTaskPoll = workQueue.poll()) != null) {
                return forkJoinTaskPoll;
            }
        }
        return null;
    }

    protected int drainTasksTo(Collection<? super ForkJoinTask<?>> collection) {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return 0;
        }
        int i = 0;
        for (WorkQueue workQueue : workQueueArr) {
            if (workQueue != null) {
                while (true) {
                    ForkJoinTask<?> forkJoinTaskPoll = workQueue.poll();
                    if (forkJoinTaskPoll != null) {
                        collection.add(forkJoinTaskPoll);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public String toString() {
        int i;
        long j;
        long j2;
        String str;
        long j3 = this.stealCount;
        long j4 = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        long j5 = j3;
        if (workQueueArr != null) {
            i = 0;
            j = 0;
            j2 = 0;
            for (int i2 = 0; i2 < workQueueArr.length; i2++) {
                WorkQueue workQueue = workQueueArr[i2];
                if (workQueue != null) {
                    int iQueueSize = workQueue.queueSize();
                    if ((i2 & 1) == 0) {
                        j2 += iQueueSize;
                    } else {
                        j += iQueueSize;
                        j5 += workQueue.nsteals;
                        if (workQueue.isApparentlyUnblocked()) {
                            i++;
                        }
                    }
                }
            }
        } else {
            i = 0;
            j = 0;
            j2 = 0;
        }
        short s = this.parallelism;
        int i3 = ((short) (j4 >>> 32)) + s;
        int i4 = s + ((int) (j4 >> 48));
        if (i4 < 0) {
            i4 = 0;
        }
        if ((j4 & 2147483648L) != 0) {
            str = i3 == 0 ? "Terminated" : "Terminating";
        } else {
            str = this.plock < 0 ? "Shutting down" : "Running";
        }
        return super.toString() + "[" + str + ", parallelism = " + ((int) s) + ", size = " + i3 + ", active = " + i4 + ", running = " + i + ", steals = " + j5 + ", tasks = " + j + ", submissions = " + j2 + "]";
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return Collections.emptyList();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        long j = this.ctl;
        return (2147483648L & j) != 0 && ((short) ((int) (j >>> 32))) + this.parallelism <= 0;
    }

    public boolean isTerminating() {
        long j = this.ctl;
        return (2147483648L & j) != 0 && ((short) ((int) (j >>> 32))) + this.parallelism > 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.plock < 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this == common) {
            awaitQuiescence(j, timeUnit);
            return false;
        }
        long nanos = timeUnit.toNanos(j);
        if (isTerminated()) {
            return true;
        }
        if (nanos <= 0) {
            return false;
        }
        long jNanoTime = System.nanoTime() + nanos;
        synchronized (this) {
            while (!isTerminated()) {
                if (nanos <= 0) {
                    return false;
                }
                long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
                if (millis <= 0) {
                    millis = 1;
                }
                wait(millis);
                nanos = jNanoTime - System.nanoTime();
            }
            return true;
        }
    }

    public boolean awaitQuiescence(long j, TimeUnit timeUnit) {
        WorkQueue[] workQueueArr;
        int length;
        long nanos = timeUnit.toNanos(j);
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) threadCurrentThread;
            if (forkJoinWorkerThread.pool == this) {
                helpQuiescePool(forkJoinWorkerThread.workQueue);
                return true;
            }
        }
        long jNanoTime = System.nanoTime();
        boolean z = true;
        int i = 0;
        while (!isQuiescent() && (workQueueArr = this.workQueues) != null && (length = workQueueArr.length - 1) >= 0) {
            if (!z) {
                if (System.nanoTime() - jNanoTime > nanos) {
                    return false;
                }
                Thread.yield();
            }
            int i2 = (length + 1) << 2;
            while (true) {
                if (i2 < 0) {
                    z = false;
                    break;
                }
                int i3 = i + 1;
                WorkQueue workQueue = workQueueArr[i & length];
                if (workQueue != null) {
                    int i4 = workQueue.base;
                    if (i4 - workQueue.top < 0) {
                        ForkJoinTask<?> forkJoinTaskPollAt = workQueue.pollAt(i4);
                        if (forkJoinTaskPollAt != null) {
                            forkJoinTaskPollAt.doExec();
                        }
                        i = i3;
                        z = true;
                    }
                }
                i2--;
                i = i3;
            }
        }
        return true;
    }

    static void quiesceCommonPool() {
        common.awaitQuiescence(LocationRequestCompat.PASSIVE_INTERVAL, TimeUnit.NANOSECONDS);
    }

    public static void managedBlock(ManagedBlocker managedBlocker) {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof ForkJoinWorkerThread) {
            ForkJoinPool forkJoinPool = ((ForkJoinWorkerThread) threadCurrentThread).pool;
            while (!managedBlocker.isReleasable()) {
                if (forkJoinPool.tryCompensate(forkJoinPool.ctl)) {
                    while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
                        try {
                        } finally {
                            forkJoinPool.incrementActiveCount();
                        }
                    }
                    return;
                }
            }
            return;
        }
        while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ForkJoinTask.AdaptedRunnable(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable(callable);
    }

    static {
        try {
            U = getUnsafe();
            CTL = U.objectFieldOffset(ForkJoinPool.class.getDeclaredField("ctl"));
            STEALCOUNT = U.objectFieldOffset(ForkJoinPool.class.getDeclaredField("stealCount"));
            PLOCK = U.objectFieldOffset(ForkJoinPool.class.getDeclaredField("plock"));
            INDEXSEED = U.objectFieldOffset(ForkJoinPool.class.getDeclaredField("indexSeed"));
            PARKBLOCKER = U.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker"));
            QBASE = U.objectFieldOffset(WorkQueue.class.getDeclaredField("base"));
            QLOCK = U.objectFieldOffset(WorkQueue.class.getDeclaredField("qlock"));
            ABASE = U.arrayBaseOffset(ForkJoinTask[].class);
            int iArrayIndexScale = U.arrayIndexScale(ForkJoinTask[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
            submitters = new ThreadLocal<>();
            defaultForkJoinWorkerThreadFactory = new DefaultForkJoinWorkerThreadFactory();
            modifyThreadPermission = new RuntimePermission("modifyThread");
            ForkJoinPool forkJoinPool = (ForkJoinPool) AccessController.doPrivileged(new PrivilegedAction<ForkJoinPool>() { // from class: io.netty.util.internal.chmv8.ForkJoinPool.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public final ForkJoinPool run() {
                    return ForkJoinPool.makeCommonPool();
                }
            });
            common = forkJoinPool;
            short s = forkJoinPool.parallelism;
            if (s <= 0) {
                s = 1;
            }
            commonParallelism = s;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ForkJoinPool makeCommonPool() {
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = defaultForkJoinWorkerThreadFactory;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
        try {
            String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            String property2 = System.getProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            String property3 = System.getProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            iAvailableProcessors = property != null ? Integer.parseInt(property) : -1;
            if (property2 != null) {
                forkJoinWorkerThreadFactory = (ForkJoinWorkerThreadFactory) ClassLoader.getSystemClassLoader().loadClass(property2).newInstance();
            }
            if (property3 != null) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) ClassLoader.getSystemClassLoader().loadClass(property3).newInstance();
            }
        } catch (Exception unused) {
        }
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
        if (iAvailableProcessors < 0 && Runtime.getRuntime().availableProcessors() - 1 < 0) {
            iAvailableProcessors = 0;
        }
        return new ForkJoinPool(iAvailableProcessors > MAX_CAP ? MAX_CAP : iAvailableProcessors, forkJoinWorkerThreadFactory2, uncaughtExceptionHandler2, 0, "ForkJoinPool.commonPool-worker-");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ForkJoinPool.2
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
