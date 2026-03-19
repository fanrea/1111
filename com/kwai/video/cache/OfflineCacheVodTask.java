package com.kwai.video.cache;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class OfflineCacheVodTask {
    public static final int TASK_FAIL_REASON_CANCEL = 5;
    public static final int TASK_FAIL_REASON_CREATE_TASK_FAIL = 4;
    public static final int TASK_FAIL_REASON_OPEN_DATE_SOURCE = 2;
    public static final int TASK_FAIL_REASON_READ_FAIL = 3;
    public static final int TASK_FAIL_REASON_WRITE_FILE = 1;
    public static final int TASK_SUCCESS = 0;
    private long nativeTask = 0;
    private OfflineCacheVodTaskListener taskListener;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OfflineCacheVodTaskListener {
        void onComplete(int i);
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    OfflineCacheVodTask() {
    }

    public synchronized void start(OfflineCacheVodTaskListener offlineCacheVodTaskListener) {
        this.taskListener = offlineCacheVodTaskListener;
        nativeRun(this.nativeTask);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.kwai.video.cache.OfflineCacheVodTask$1] */
    public synchronized void release() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.OfflineCacheVodTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                OfflineCacheVodTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    public synchronized void cancel() {
        release();
    }

    private void onComplete(int i) {
        OfflineCacheVodTaskListener offlineCacheVodTaskListener = this.taskListener;
        if (offlineCacheVodTaskListener != null) {
            offlineCacheVodTaskListener.onComplete(i);
        }
    }

    synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }
}
