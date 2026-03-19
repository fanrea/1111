package com.bytedance.sdk.djx.core.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class MainTask {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private boolean mCanceled;
    private ThreadPoolExecutor mExecutor;
    protected boolean mIsAsync;
    private final List<MainTask> mPredecessorTaskList;
    private final List<MainTask> mSuccessorTaskList;
    private final List<MainTask> mUndoPredecessorTaskList;
    public Boolean result;

    public void onPredecessorTaskDone(MainTask mainTask) {
    }

    public void onTaskDone() {
    }

    public void onTaskStart() {
    }

    protected abstract Boolean run();

    public MainTask(MainTask... mainTaskArr) {
        this(false, null, mainTaskArr);
    }

    public MainTask(boolean z, ThreadPoolExecutor threadPoolExecutor, MainTask... mainTaskArr) {
        this.result = null;
        this.mIsAsync = false;
        this.mCanceled = false;
        this.mExecutor = null;
        this.mPredecessorTaskList = new ArrayList();
        this.mSuccessorTaskList = new ArrayList();
        this.mUndoPredecessorTaskList = new ArrayList();
        this.mIsAsync = z;
        this.mExecutor = threadPoolExecutor;
        for (MainTask mainTask : mainTaskArr) {
            this.mPredecessorTaskList.add(mainTask);
            this.mUndoPredecessorTaskList.add(mainTask);
            mainTask.mSuccessorTaskList.add(this);
        }
    }

    public void start() {
        if (!this.mCanceled && this.result == null) {
            onTaskStart();
            if (this.mIsAsync) {
                this.mExecutor.execute(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.util.MainTask.1
                    public void run() {
                        Boolean boolRun = MainTask.this.run();
                        if (boolRun != null) {
                            MainTask.this.markTaskDone(boolRun.booleanValue(), true);
                        }
                    }
                });
                return;
            }
            Boolean boolRun = run();
            if (boolRun != null) {
                markTaskDone(boolRun.booleanValue(), false);
            }
        }
    }

    protected void markTaskDone(final boolean z, boolean z2) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.util.MainTask.2
            @Override // java.lang.Runnable
            public void run() {
                MainTask.this.result = Boolean.valueOf(z);
                MainTask.this.onTaskDone();
                MainTask.this.notifySuccessorTasks();
            }
        };
        if (z2) {
            sHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccessorTasks() {
        if (this.mCanceled) {
            return;
        }
        Iterator<MainTask> it = this.mSuccessorTaskList.iterator();
        while (it.hasNext()) {
            it.next().markPredecessorTaskDone(this);
        }
    }

    private void markPredecessorTaskDone(MainTask mainTask) {
        onPredecessorTaskDone(mainTask);
        Boolean bool = mainTask.result;
        if (Boolean.TRUE.equals(bool)) {
            if (this.mUndoPredecessorTaskList.remove(mainTask) && this.mUndoPredecessorTaskList.isEmpty()) {
                start();
                return;
            }
            return;
        }
        if (Boolean.FALSE.equals(bool)) {
            this.result = false;
            notifySuccessorTasks();
        }
    }

    public void reset() {
        this.result = null;
        this.mCanceled = false;
        this.mUndoPredecessorTaskList.clear();
        this.mUndoPredecessorTaskList.addAll(this.mPredecessorTaskList);
    }

    public void cancel() {
        this.mCanceled = true;
    }

    public static class Trigger extends MainTask {
        public Trigger() {
            super(new MainTask[0]);
        }

        @Override // com.bytedance.sdk.djx.core.util.MainTask
        protected Boolean run() {
            return true;
        }
    }
}
