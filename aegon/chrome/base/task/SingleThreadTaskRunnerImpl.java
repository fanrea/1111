package aegon.chrome.base.task;

import aegon.chrome.base.annotations.JNINamespace;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Handler mHandler;
    private final boolean mPostTaskAtFrontOfQueue;

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits taskTraits, boolean z) {
        super(taskTraits, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = handler;
        this.mPostTaskAtFrontOfQueue = z;
    }

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits taskTraits) {
        this(handler, taskTraits, false);
    }

    @Override // aegon.chrome.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        synchronized (this.mLock) {
            if (this.mNativeTaskRunnerAndroid != 0) {
                return nativeBelongsToCurrentThread(this.mNativeTaskRunnerAndroid);
            }
            Handler handler = this.mHandler;
            return handler != null && handler.getLooper().getThread() == Thread.currentThread();
        }
    }

    @Override // aegon.chrome.base.task.TaskRunnerImpl
    protected void schedulePreNativeTask() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        if (this.mPostTaskAtFrontOfQueue) {
            postAtFrontOfQueue();
        } else {
            handler.post(this.mRunPreNativeTaskClosure);
        }
    }

    private void postAtFrontOfQueue() {
        if (Build.VERSION.SDK_INT >= 21) {
            Message messageObtain = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
            messageObtain.setAsynchronous(true);
            this.mHandler.sendMessageAtFrontOfQueue(messageObtain);
            return;
        }
        this.mHandler.postAtFrontOfQueue(this.mRunPreNativeTaskClosure);
    }
}
