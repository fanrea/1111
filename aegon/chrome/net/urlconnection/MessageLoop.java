package aegon.chrome.net.urlconnection;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private long mThreadId = -1;
    private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue();

    MessageLoop() {
    }

    private boolean calledOnValidThread() {
        long j = this.mThreadId;
        if (j != -1) {
            return j == Thread.currentThread().getId();
        }
        this.mThreadId = Thread.currentThread().getId();
        return true;
    }

    private Runnable take(boolean z, long j) throws InterruptedException, InterruptedIOException {
        Runnable runnablePoll;
        try {
            if (!z) {
                runnablePoll = this.mQueue.take();
            } else {
                runnablePoll = this.mQueue.poll(j, TimeUnit.NANOSECONDS);
            }
            if (runnablePoll != null) {
                return runnablePoll;
            }
            throw new SocketTimeoutException();
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }

    public void loop() throws InterruptedIOException {
        loop(0);
    }

    public void loop(int i) throws InterruptedIOException {
        long jNanoTime = System.nanoTime();
        long jConvert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed) {
            InterruptedIOException interruptedIOException = this.mPriorInterruptedIOException;
            if (interruptedIOException != null) {
                throw interruptedIOException;
            }
            throw this.mPriorRuntimeException;
        }
        if (this.mLoopRunning) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.mLoopRunning = true;
        while (this.mLoopRunning) {
            if (i == 0) {
                try {
                    take(false, 0L).run();
                } catch (InterruptedIOException e) {
                    this.mLoopRunning = false;
                    this.mLoopFailed = true;
                    this.mPriorInterruptedIOException = e;
                    throw e;
                } catch (RuntimeException e2) {
                    this.mLoopRunning = false;
                    this.mLoopFailed = true;
                    this.mPriorRuntimeException = e2;
                    throw e2;
                }
            } else {
                take(true, (jConvert - System.nanoTime()) + jNanoTime).run();
            }
        }
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws InterruptedException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.mQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(e);
        }
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }
}
