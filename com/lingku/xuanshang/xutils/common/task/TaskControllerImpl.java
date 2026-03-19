package com.lingku.xuanshang.xutils.common.task;

import android.os.Looper;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.TaskController;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.x;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class TaskControllerImpl implements TaskController {
    public static volatile TaskController a;

    public class a implements Runnable {
        public final int a;
        public final AtomicInteger b = new AtomicInteger(0);
        public final /* synthetic */ AbsTask[] c;
        public final /* synthetic */ Callback.GroupCallback d;

        public a(TaskControllerImpl taskControllerImpl, AbsTask[] absTaskArr, Callback.GroupCallback groupCallback) {
            this.c = absTaskArr;
            this.d = groupCallback;
            this.a = absTaskArr.length;
        }

        @Override // java.lang.Runnable
        public void run() {
            Callback.GroupCallback groupCallback;
            if (this.b.incrementAndGet() != this.a || (groupCallback = this.d) == null) {
                return;
            }
            try {
                groupCallback.onAllFinished();
            } catch (Throwable th) {
                try {
                    this.d.onError(null, th, true);
                } catch (Throwable th2) {
                    LogUtil.e(th2.getMessage(), th2);
                }
            }
        }
    }

    public class b extends lkxssdk.o0.b {
        public final /* synthetic */ Callback.GroupCallback m;
        public final /* synthetic */ AbsTask n;
        public final /* synthetic */ Runnable o;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                Callback.GroupCallback groupCallback = bVar.m;
                if (groupCallback != null) {
                    try {
                        groupCallback.onSuccess(bVar.n);
                    } catch (Throwable th) {
                        try {
                            b bVar2 = b.this;
                            bVar2.m.onError(bVar2.n, th, true);
                        } catch (Throwable th2) {
                            LogUtil.e(th2.getMessage(), th2);
                        }
                    }
                }
            }
        }

        /* renamed from: com.lingku.xuanshang.xutils.common.task.TaskControllerImpl$b$b, reason: collision with other inner class name */
        public class RunnableC0659b implements Runnable {
            public final /* synthetic */ Callback.CancelledException a;

            public RunnableC0659b(Callback.CancelledException cancelledException) {
                this.a = cancelledException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                Callback.GroupCallback groupCallback = bVar.m;
                if (groupCallback != null) {
                    try {
                        groupCallback.onCancelled(bVar.n, this.a);
                    } catch (Throwable th) {
                        try {
                            b bVar2 = b.this;
                            bVar2.m.onError(bVar2.n, th, true);
                        } catch (Throwable th2) {
                            LogUtil.e(th2.getMessage(), th2);
                        }
                    }
                }
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ boolean b;

            public c(Throwable th, boolean z) {
                this.a = th;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                Callback.GroupCallback groupCallback = bVar.m;
                if (groupCallback != null) {
                    try {
                        groupCallback.onError(bVar.n, this.a, this.b);
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b bVar = b.this;
                    Callback.GroupCallback groupCallback = bVar.m;
                    if (groupCallback != null) {
                        groupCallback.onFinished(bVar.n);
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsTask absTask, Callback.GroupCallback groupCallback, AbsTask absTask2, Runnable runnable) {
            super(absTask);
            this.m = groupCallback;
            this.n = absTask2;
            this.o = runnable;
        }

        @Override // lkxssdk.o0.b, com.lingku.xuanshang.xutils.common.task.AbsTask
        public void onCancelled(Callback.CancelledException cancelledException) {
            super.onCancelled(cancelledException);
            TaskControllerImpl.this.post(new RunnableC0659b(cancelledException));
        }

        @Override // lkxssdk.o0.b, com.lingku.xuanshang.xutils.common.task.AbsTask
        public void onError(Throwable th, boolean z) {
            super.onError(th, z);
            TaskControllerImpl.this.post(new c(th, z));
        }

        @Override // lkxssdk.o0.b, com.lingku.xuanshang.xutils.common.task.AbsTask
        public void onFinished() {
            super.onFinished();
            TaskControllerImpl.this.post(new d());
        }

        @Override // lkxssdk.o0.b, com.lingku.xuanshang.xutils.common.task.AbsTask
        public void onSuccess(Object obj) {
            super.onSuccess(obj);
            TaskControllerImpl.this.post(new a());
        }
    }

    public class c implements Callback.Cancelable {
        public final /* synthetic */ AbsTask[] a;

        public c(TaskControllerImpl taskControllerImpl, AbsTask[] absTaskArr) {
            this.a = absTaskArr;
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
        public void cancel() {
            for (AbsTask absTask : this.a) {
                absTask.cancel();
            }
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
        public boolean isCancelled() {
            boolean z = true;
            for (AbsTask absTask : this.a) {
                if (!absTask.isCancelled()) {
                    z = false;
                }
            }
            return z;
        }
    }

    public static void registerInstance() {
        if (a == null) {
            synchronized (TaskController.class) {
                if (a == null) {
                    a = new TaskControllerImpl();
                }
            }
        }
        x.Ext.setTaskController(a);
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public void autoPost(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            lkxssdk.o0.b.f.post(runnable);
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public void post(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        lkxssdk.o0.b.f.post(runnable);
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public void postDelayed(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        lkxssdk.o0.b.f.postDelayed(runnable, j);
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public void removeCallbacks(Runnable runnable) {
        lkxssdk.o0.b.f.removeCallbacks(runnable);
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public void run(Runnable runnable) {
        PriorityExecutor priorityExecutor = lkxssdk.o0.b.g;
        if (priorityExecutor.isBusy()) {
            new Thread(runnable).start();
        } else {
            priorityExecutor.execute(runnable);
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public <T> AbsTask<T> start(AbsTask<T> absTask) {
        lkxssdk.o0.b bVar = absTask instanceof lkxssdk.o0.b ? (lkxssdk.o0.b) absTask : new lkxssdk.o0.b(absTask);
        try {
            bVar.doBackground();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        return bVar;
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public <T> T startSync(AbsTask<T> absTask) {
        T tDoBackground = null;
        try {
            try {
                try {
                    absTask.onWaiting();
                    absTask.onStarted();
                    tDoBackground = absTask.doBackground();
                    absTask.onSuccess(tDoBackground);
                } catch (Throwable th) {
                    absTask.onError(th, false);
                    throw th;
                }
            } catch (Callback.CancelledException e) {
                absTask.onCancelled(e);
            }
            absTask.onFinished();
            return tDoBackground;
        } catch (Throwable th2) {
            absTask.onFinished();
            throw th2;
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.TaskController
    public <T extends AbsTask<?>> Callback.Cancelable startTasks(Callback.GroupCallback<T> groupCallback, T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        a aVar = new a(this, tArr, groupCallback);
        for (T t : tArr) {
            start(new b(t, groupCallback, t, aVar));
        }
        return new c(this, tArr);
    }
}
