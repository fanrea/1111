package com.kwad.sdk.live.audience.net;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.live.audience.net.KSLiveHttpTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLiveHttpTaskManager {
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final List<KSLiveHttpTask<?>> mTaskCache = new ArrayList();

    public final void release() {
        cancelAllTask();
        this.mUiHandler.removeCallbacksAndMessages(null);
    }

    public final <T> void executeTask(KSLiveHttpTask<T> kSLiveHttpTask) {
        executeTask((KSLiveHttpTask) kSLiveHttpTask, false);
    }

    public final <T> void executeTask(KSLiveHttpTask<T> kSLiveHttpTask, boolean z) {
        executeTask(kSLiveHttpTask, null, z);
    }

    public final <T> void executeTask(KSLiveHttpTask<T> kSLiveHttpTask, KSLiveTaskListener<T> kSLiveTaskListener) {
        executeTask(kSLiveHttpTask, kSLiveTaskListener, true);
    }

    public final <T> void executeTask(final KSLiveHttpTask<T> kSLiveHttpTask, final KSLiveTaskListener<T> kSLiveTaskListener, boolean z) {
        kSLiveHttpTask.setListener(new KSLiveHttpTask.Listener<T>() { // from class: com.kwad.sdk.live.audience.net.KSLiveHttpTaskManager.1
            @Override // com.kwad.sdk.live.audience.net.KSLiveHttpTask.Listener
            public void onTaskFinished(T t, Throwable th) {
                KSLiveHttpTaskManager.this.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.live.audience.net.KSLiveHttpTaskManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KSLiveHttpTaskManager.this.mTaskCache.remove(kSLiveHttpTask);
                    }
                });
                KSLiveTaskListener kSLiveTaskListener2 = kSLiveTaskListener;
                if (kSLiveTaskListener2 == null) {
                    return;
                }
                if (t != null) {
                    KSLiveHttpTaskManager.this.runOnUiThread(new UiTask(t, kSLiveTaskListener2));
                } else if (th != null) {
                    KSLiveHttpTaskManager.this.runOnUiThread(new UiTask(th, kSLiveTaskListener2));
                }
            }
        });
        if (z) {
            addToAutoCancel(kSLiveHttpTask);
        }
        KSLiveTaskExecutor.execute(kSLiveHttpTask);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (runnable != null) {
            this.mUiHandler.post(runnable);
        }
    }

    public final void addToAutoCancel(KSLiveHttpTask<?> kSLiveHttpTask) {
        if (kSLiveHttpTask != null) {
            this.mTaskCache.add(kSLiveHttpTask);
        }
    }

    public final void cancelTask(KSLiveHttpTask<?> kSLiveHttpTask) {
        if (kSLiveHttpTask != null) {
            this.mTaskCache.remove(kSLiveHttpTask);
            KSLiveTaskExecutor.cancel(kSLiveHttpTask);
        }
    }

    public final void cancelAllTask() {
        if (this.mTaskCache.isEmpty()) {
            return;
        }
        Iterator<KSLiveHttpTask<?>> it = this.mTaskCache.iterator();
        while (it.hasNext()) {
            KSLiveTaskExecutor.cancel(it.next());
        }
        this.mTaskCache.clear();
    }

    static class UiTask<T> implements Runnable {
        private T mData;
        private Throwable mError;
        private KSLiveTaskListener<T> mListener;

        public UiTask(T t, KSLiveTaskListener<T> kSLiveTaskListener) {
            this.mData = t;
            this.mListener = kSLiveTaskListener;
        }

        public UiTask(Throwable th, KSLiveTaskListener<T> kSLiveTaskListener) {
            this.mError = th;
            this.mListener = kSLiveTaskListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mData != null) {
                    this.mListener.onSuccess(this.mData);
                } else if (this.mError != null) {
                    this.mListener.onError(this.mError);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
