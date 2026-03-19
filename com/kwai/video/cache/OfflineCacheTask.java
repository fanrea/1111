package com.kwai.video.cache;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class OfflineCacheTask {
    private long nativeTask = 0;
    private OfflineCacheTaskListener taskListener;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OfflineCacheTaskListener {
        void onCancelled();

        void onFailed(int i);

        void onProgress(long j, long j2);

        void onStarted(long j, long j2, long j3);

        void onStopped(long j, long j2, String str);

        void onSuccessful();
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    OfflineCacheTask() {
    }

    synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }

    public synchronized void run(OfflineCacheTaskListener offlineCacheTaskListener) {
        this.taskListener = offlineCacheTaskListener;
        nativeRun(this.nativeTask);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.kwai.video.cache.OfflineCacheTask$1] */
    public synchronized void releaseAsync() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.OfflineCacheTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                OfflineCacheTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    private void onSuccessFul() {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onSuccessful();
        }
    }

    private void onFailed(int i) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onFailed(i);
        }
    }

    private void onCancelled() {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onCancelled();
        }
    }

    private void onProgress(long j, long j2) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onProgress(j, j2);
        }
    }

    private void onStopped(long j, long j2, String str) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onStopped(j, j2, str);
        }
    }

    private void onStarted(long j, long j2, long j3) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onStarted(j, j2, j3);
        }
    }
}
