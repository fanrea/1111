package aegon.chrome.base.task;

import android.view.Choreographer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    @Override // aegon.chrome.base.task.TaskRunner
    public final void destroy() {
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public final void disableLifetimeCheck() {
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public final void initNativeTaskRunner() {
    }

    ChoreographerTaskRunner(Choreographer choreographer) {
        this.mChoreographer = choreographer;
    }

    @Override // aegon.chrome.base.task.SingleThreadTaskRunner
    public final boolean belongsToCurrentThread() {
        try {
            return this.mChoreographer == Choreographer.getInstance();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public final void postTask(final Runnable runnable) {
        this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: aegon.chrome.base.task.ChoreographerTaskRunner.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                runnable.run();
            }
        });
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public final void postDelayedTask(final Runnable runnable, long j) {
        this.mChoreographer.postFrameCallbackDelayed(new Choreographer.FrameCallback() { // from class: aegon.chrome.base.task.ChoreographerTaskRunner.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                runnable.run();
            }
        }, j);
    }
}
