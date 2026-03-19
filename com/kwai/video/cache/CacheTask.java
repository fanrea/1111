package com.kwai.video.cache;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CacheTask {
    private long nativeTask;
    private CacheTaskListener taskListener;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface CacheTaskListener {
        void onCancelled();

        void onFailed(int i);

        void onProgress(long j, long j2);

        void onSuccessful();
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    CacheTask() {
    }

    synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }

    public synchronized void run(CacheTaskListener cacheTaskListener) {
        this.taskListener = cacheTaskListener;
        nativeRun(this.nativeTask);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.kwai.video.cache.CacheTask$1] */
    public synchronized void releaseAsync() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.CacheTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CacheTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    private void onSuccessFul() {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onSuccessful();
        }
    }

    private void onFailed(int i) {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onFailed(i);
        }
    }

    private void onCancelled() {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onCancelled();
        }
    }

    private void onProgress(long j, long j2) {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onProgress(j, j2);
        }
    }
}
