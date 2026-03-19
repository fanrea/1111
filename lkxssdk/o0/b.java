package lkxssdk.o0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.task.AbsTask;
import com.lingku.xuanshang.xutils.common.task.Priority;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.x;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b<ResultType> extends AbsTask<ResultType> {
    public static final c f = new c();
    public static final PriorityExecutor g = new PriorityExecutor(true);
    public final AbsTask<ResultType> h;
    public final Executor i;
    public final Handler j;
    public volatile boolean k;
    public volatile boolean l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                } catch (Callback.CancelledException e) {
                    b.this.onCancelled(e);
                } catch (Throwable th) {
                    b.this.onError(th, false);
                }
                if (b.this.k || b.this.isCancelled()) {
                    throw new Callback.CancelledException("");
                }
                b.this.onStarted();
                if (b.this.isCancelled()) {
                    throw new Callback.CancelledException("");
                }
                AbsTask<ResultType> absTask = b.this.h;
                absTask.e = absTask.doBackground();
                b bVar = b.this;
                bVar.e = bVar.h.getResult();
                if (b.this.isCancelled()) {
                    throw new Callback.CancelledException("");
                }
                b bVar2 = b.this;
                bVar2.onSuccess(bVar2.h.getResult());
            } finally {
                b.this.onFinished();
            }
        }
    }

    /* renamed from: lkxssdk.o0.b$b, reason: collision with other inner class name */
    public static class C0845b {
        public final b a;
        public final Object[] b;

        public C0845b(b bVar, Object... objArr) {
            this.a = bVar;
            this.b = objArr;
        }
    }

    public static final class c extends Handler {
        public static final /* synthetic */ boolean a = true;

        public c() {
            super(Looper.getMainLooper());
        }

        public c(Looper looper) {
            super(looper);
        }

        public /* synthetic */ c(Looper looper, a aVar) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] objArr;
            Object obj = message.obj;
            if (obj == null) {
                throw new IllegalArgumentException("msg must not be null");
            }
            b bVar = null;
            if (obj instanceof b) {
                bVar = (b) obj;
                objArr = null;
            } else if (obj instanceof C0845b) {
                C0845b c0845b = (C0845b) obj;
                bVar = c0845b.a;
                objArr = c0845b.b;
            } else {
                objArr = null;
            }
            if (bVar == null) {
                throw new RuntimeException("msg.obj not instanceof TaskProxy");
            }
            try {
                switch (message.what) {
                    case 1000000001:
                        bVar.h.onWaiting();
                        return;
                    case 1000000002:
                        bVar.h.onStarted();
                        return;
                    case 1000000003:
                        bVar.h.onSuccess(bVar.getResult());
                        return;
                    case 1000000004:
                        if (!a && objArr == null) {
                            throw new AssertionError();
                        }
                        Throwable th = (Throwable) objArr[0];
                        LogUtil.d(th.getMessage(), th);
                        bVar.h.onError(th, false);
                        return;
                    case 1000000005:
                        bVar.h.onUpdate(message.arg1, objArr);
                        return;
                    case 1000000006:
                        if (bVar.k) {
                            return;
                        }
                        bVar.k = true;
                        if (!a && objArr == null) {
                            throw new AssertionError();
                        }
                        bVar.h.onCancelled((Callback.CancelledException) objArr[0]);
                        return;
                    case 1000000007:
                        if (bVar.l) {
                            return;
                        }
                        bVar.l = true;
                        bVar.h.onFinished();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th2) {
                bVar.a(AbsTask.State.ERROR);
                if (message.what != 1000000004) {
                    bVar.h.onError(th2, true);
                } else if (x.isDebug()) {
                    throw new RuntimeException(th2);
                }
            }
        }
    }

    public b(AbsTask<ResultType> absTask) {
        super(absTask);
        this.k = false;
        this.l = false;
        this.h = absTask;
        absTask.a(this);
        a aVar = null;
        a((b) null);
        Looper looperCustomLooper = absTask.customLooper();
        if (looperCustomLooper != null) {
            this.j = new c(looperCustomLooper, aVar);
        } else {
            this.j = f;
        }
        Executor executor = absTask.getExecutor();
        this.i = executor == null ? g : executor;
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public final void a(AbsTask.State state) {
        this.d = state;
        this.h.a(state);
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public final ResultType doBackground() {
        onWaiting();
        this.i.execute(new lkxssdk.o0.a(this.h.getPriority(), new a()));
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public final Executor getExecutor() {
        return this.i;
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public final Priority getPriority() {
        return this.h.getPriority();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onCancelled(Callback.CancelledException cancelledException) {
        a(AbsTask.State.CANCELLED);
        this.j.obtainMessage(1000000006, new C0845b(this, cancelledException)).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onError(Throwable th, boolean z) {
        a(AbsTask.State.ERROR);
        this.j.obtainMessage(1000000004, new C0845b(this, th)).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onFinished() {
        this.j.obtainMessage(1000000007, this).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onStarted() {
        a(AbsTask.State.STARTED);
        this.j.obtainMessage(1000000002, this).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onSuccess(ResultType resulttype) {
        a(AbsTask.State.SUCCESS);
        this.j.obtainMessage(1000000003, this).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onUpdate(int i, Object... objArr) {
        this.j.obtainMessage(1000000005, i, i, new C0845b(this, objArr)).sendToTarget();
    }

    @Override // com.lingku.xuanshang.xutils.common.task.AbsTask
    public void onWaiting() {
        a(AbsTask.State.WAITING);
        this.j.obtainMessage(1000000001, this).sendToTarget();
    }
}
