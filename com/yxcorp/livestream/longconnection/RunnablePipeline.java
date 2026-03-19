package com.yxcorp.livestream.longconnection;

import android.os.SystemClock;
import com.kuaishou.common.async.Async;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class RunnablePipeline {
    static ExecutorService sExecutorService = Async.getCacheThreadPoolExecutor();
    volatile boolean mIsStopped;
    final Queue<Runnable> mRunnables = new LinkedBlockingQueue();
    final Queue<TimerRunnable> mTimerRunnables = new LinkedBlockingQueue();
    volatile Status mStatus = Status.IDLE;
    Runnable mInitRunnable = new Runnable() { // from class: com.yxcorp.livestream.longconnection.RunnablePipeline.1
        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (RunnablePipeline.this.mStatus == Status.WAIT) {
                RunnablePipeline.this.mStatus = Status.RUNNING;
            }
            while (RunnablePipeline.this.mStatus == Status.RUNNING && !RunnablePipeline.this.mIsStopped) {
                Runnable runnablePoll = RunnablePipeline.this.mRunnables.poll();
                if (runnablePoll == null) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                } else {
                    runnablePoll.run();
                }
                synchronized (RunnablePipeline.this.mTimerRunnables) {
                    Iterator<TimerRunnable> it = RunnablePipeline.this.mTimerRunnables.iterator();
                    while (it.hasNext()) {
                        TimerRunnable next = it.next();
                        if (SystemClock.elapsedRealtime() >= next.mTime) {
                            it.remove();
                            next.run();
                        }
                    }
                }
            }
            RunnablePipeline.this.mStatus = Status.IDLE;
        }
    };

    public enum Status {
        IDLE,
        WAIT,
        RUNNING
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public Future start() {
        if (this.mIsStopped || this.mStatus != Status.IDLE) {
            throw new IllegalStateException("Should not start a RunnablePipeline twice");
        }
        this.mStatus = Status.WAIT;
        return sExecutorService.submit(this.mInitRunnable);
    }

    public void post(Runnable runnable) {
        this.mRunnables.add(runnable);
    }

    public void postDelayed(Runnable runnable, long j) {
        postAtTime(runnable, SystemClock.elapsedRealtime() + j);
    }

    public void postAtTime(Runnable runnable, long j) {
        synchronized (this.mTimerRunnables) {
            this.mTimerRunnables.add(new TimerRunnable(runnable, j));
        }
    }

    public void remove(Runnable runnable) {
        this.mRunnables.remove(runnable);
        synchronized (this.mTimerRunnables) {
            Iterator<TimerRunnable> it = this.mTimerRunnables.iterator();
            while (it.hasNext()) {
                if (runnable == it.next().mActualRunnable) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void clear() {
        this.mRunnables.clear();
        this.mTimerRunnables.clear();
    }

    public void quit() {
        this.mIsStopped = true;
    }

    static class TimerRunnable implements Runnable {
        Runnable mActualRunnable;
        long mTime;

        TimerRunnable(Runnable runnable, long j) {
            this.mTime = j;
            this.mActualRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mActualRunnable.run();
        }
    }
}
