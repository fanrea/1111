package com.duoyou.task.sdk.xutils.common.task;

import android.os.Looper;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.TaskController;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.x;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class TaskControllerImpl implements TaskController {
    private static volatile TaskController instance;

    private TaskControllerImpl() {
    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (TaskController.class) {
                if (instance == null) {
                    instance = new TaskControllerImpl();
                }
            }
        }
        x.Ext.setTaskController(instance);
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public <T> AbsTask<T> start(AbsTask<T> absTask) {
        TaskProxy taskProxy;
        if (absTask instanceof TaskProxy) {
            taskProxy = (TaskProxy) absTask;
        } else {
            taskProxy = new TaskProxy(absTask);
        }
        try {
            taskProxy.doBackground();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        return taskProxy;
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public <T> T startSync(AbsTask<T> absTask) {
        T tDoBackground = null;
        try {
            try {
                absTask.onWaiting();
                absTask.onStarted();
                tDoBackground = absTask.doBackground();
                absTask.onSuccess(tDoBackground);
            } catch (Callback.CancelledException e) {
                absTask.onCancelled(e);
            } catch (Throwable th) {
                absTask.onError(th, false);
                throw th;
            }
            return tDoBackground;
        } finally {
            absTask.onFinished();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public <T extends AbsTask<?>> Callback.Cancelable startTasks(final Callback.GroupCallback<T> groupCallback, final T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        final Runnable runnable = new Runnable(tArr, groupCallback) { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.1
            private final AtomicInteger count = new AtomicInteger(0);
            private final int total;
            public final /* synthetic */ Callback.GroupCallback val$groupCallback;
            public final /* synthetic */ AbsTask[] val$tasks;

            {
                this.val$tasks = tArr;
                this.val$groupCallback = groupCallback;
                this.total = tArr.length;
            }

            @Override // java.lang.Runnable
            public void run() {
                Callback.GroupCallback groupCallback2;
                if (this.count.incrementAndGet() != this.total || (groupCallback2 = this.val$groupCallback) == null) {
                    return;
                }
                try {
                    groupCallback2.onAllFinished();
                } catch (Throwable th) {
                    try {
                        this.val$groupCallback.onError(null, th, true);
                    } catch (Throwable th2) {
                        LogUtil.e(th2.getMessage(), th2);
                    }
                }
            }
        };
        for (final T t : tArr) {
            start(new TaskProxy(t) { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.2
                @Override // com.duoyou.task.sdk.xutils.common.task.TaskProxy, com.duoyou.task.sdk.xutils.common.task.AbsTask
                public void onSuccess(Object obj) {
                    super.onSuccess(obj);
                    TaskControllerImpl.this.post(new Runnable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            Callback.GroupCallback groupCallback2 = groupCallback;
                            if (groupCallback2 != null) {
                                try {
                                    groupCallback2.onSuccess(t);
                                } catch (Throwable th) {
                                    try {
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        groupCallback.onError(t, th, true);
                                    } catch (Throwable th2) {
                                        LogUtil.e(th2.getMessage(), th2);
                                    }
                                }
                            }
                        }
                    });
                }

                @Override // com.duoyou.task.sdk.xutils.common.task.TaskProxy, com.duoyou.task.sdk.xutils.common.task.AbsTask
                public void onCancelled(final Callback.CancelledException cancelledException) {
                    super.onCancelled(cancelledException);
                    TaskControllerImpl.this.post(new Runnable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            Callback.GroupCallback groupCallback2 = groupCallback;
                            if (groupCallback2 != null) {
                                try {
                                    groupCallback2.onCancelled(t, cancelledException);
                                } catch (Throwable th) {
                                    try {
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        groupCallback.onError(t, th, true);
                                    } catch (Throwable th2) {
                                        LogUtil.e(th2.getMessage(), th2);
                                    }
                                }
                            }
                        }
                    });
                }

                @Override // com.duoyou.task.sdk.xutils.common.task.TaskProxy, com.duoyou.task.sdk.xutils.common.task.AbsTask
                public void onError(final Throwable th, final boolean z) {
                    super.onError(th, z);
                    TaskControllerImpl.this.post(new Runnable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            Callback.GroupCallback groupCallback2 = groupCallback;
                            if (groupCallback2 != null) {
                                try {
                                    groupCallback2.onError(t, th, z);
                                } catch (Throwable th2) {
                                    LogUtil.e(th2.getMessage(), th2);
                                }
                            }
                        }
                    });
                }

                @Override // com.duoyou.task.sdk.xutils.common.task.TaskProxy, com.duoyou.task.sdk.xutils.common.task.AbsTask
                public void onFinished() {
                    super.onFinished();
                    TaskControllerImpl.this.post(new Runnable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                Callback.GroupCallback groupCallback2 = groupCallback;
                                if (groupCallback2 != null) {
                                    groupCallback2.onFinished(t);
                                }
                            } finally {
                                try {
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        }
                    });
                }
            });
        }
        return new Callback.Cancelable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl.3
            @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
            public void cancel() {
                for (AbsTask absTask : tArr) {
                    absTask.cancel();
                }
            }

            @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
            public boolean isCancelled() {
                boolean z = true;
                for (AbsTask absTask : tArr) {
                    if (!absTask.isCancelled()) {
                        z = false;
                    }
                }
                return z;
            }
        };
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public void autoPost(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            TaskProxy.sHandler.post(runnable);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public void post(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        TaskProxy.sHandler.post(runnable);
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public void postDelayed(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        TaskProxy.sHandler.postDelayed(runnable, j);
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public void run(Runnable runnable) {
        PriorityExecutor priorityExecutor = TaskProxy.sDefaultExecutor;
        if (!priorityExecutor.isBusy()) {
            priorityExecutor.execute(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.TaskController
    public void removeCallbacks(Runnable runnable) {
        TaskProxy.sHandler.removeCallbacks(runnable);
    }
}
