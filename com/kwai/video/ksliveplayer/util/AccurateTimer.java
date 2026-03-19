package com.kwai.video.ksliveplayer.util;

import android.os.SystemClock;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AccurateTimer<T> {
    private ScheduledThreadPoolExecutor mExecutor;
    private long mHistoryElapse;
    private long mInterval;
    private long mStartTime = 0;
    private Runnable mRunnable = new Runnable() { // from class: com.kwai.video.ksliveplayer.util.AccurateTimer.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                AccurateTimer.this.run(AccurateTimer.this.getElapse(), AccurateTimer.this.prepareData(AccurateTimer.this.getElapse()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    protected T prepareData(long j) {
        return null;
    }

    protected void run(long j, T t) {
    }

    public AccurateTimer(long j) {
        this.mInterval = j;
    }

    private void buildExecutor() {
        this.mExecutor = new ScheduledThreadPoolExecutor(1, new DefaultThreadFactory("accurate-timer"));
        this.mExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.mExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
    }

    public void start() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.mExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.remove(this.mRunnable);
            this.mExecutor.shutdown();
        }
        buildExecutor();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mExecutor.scheduleAtFixedRate(this.mRunnable, 50L, this.mInterval, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        this.mStartTime = 0L;
        this.mHistoryElapse = 0L;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.mExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.remove(this.mRunnable);
            this.mExecutor.shutdown();
            this.mExecutor = null;
        }
    }

    public void pause() {
        this.mHistoryElapse += SystemClock.elapsedRealtime() - this.mStartTime;
        this.mStartTime = 0L;
    }

    public void resume() {
        if (this.mStartTime == 0) {
            this.mStartTime = SystemClock.elapsedRealtime();
        }
    }

    public boolean isAlive() {
        return this.mExecutor != null;
    }

    public long getElapse() {
        if (this.mStartTime == 0) {
            return this.mHistoryElapse;
        }
        return (SystemClock.elapsedRealtime() - this.mStartTime) + this.mHistoryElapse;
    }
}
