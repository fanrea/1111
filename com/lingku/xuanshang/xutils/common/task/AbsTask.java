package com.lingku.xuanshang.xutils.common.task;

import android.os.Looper;
import com.lingku.xuanshang.xutils.common.Callback;
import java.util.concurrent.Executor;
import lkxssdk.o0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbsTask<ResultType> implements Callback.Cancelable {
    public b a;
    public final Callback.Cancelable b;
    public volatile boolean c;
    public volatile State d;
    public ResultType e;

    public enum State {
        IDLE(0),
        WAITING(1),
        STARTED(2),
        SUCCESS(3),
        CANCELLED(4),
        ERROR(5);

        public final int b;

        State(int i) {
            this.b = i;
        }

        public int value() {
            return this.b;
        }
    }

    public AbsTask() {
        this(null);
    }

    public AbsTask(Callback.Cancelable cancelable) {
        this.a = null;
        this.c = false;
        this.d = State.IDLE;
        this.b = cancelable;
    }

    public void a(State state) {
        this.d = state;
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
    public final void cancel() {
        if (this.c) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            this.c = true;
            cancelWorks();
            Callback.Cancelable cancelable = this.b;
            if (cancelable != null && !cancelable.isCancelled()) {
                this.b.cancel();
            }
            if (this.d == State.WAITING || (this.d == State.STARTED && isCancelFast())) {
                b bVar = this.a;
                if (bVar != null) {
                    bVar.onCancelled(new Callback.CancelledException("cancelled by user"));
                    this.a.onFinished();
                } else if (this instanceof b) {
                    onCancelled(new Callback.CancelledException("cancelled by user"));
                    onFinished();
                }
            }
        }
    }

    public void cancelWorks() {
    }

    public Looper customLooper() {
        return null;
    }

    public abstract ResultType doBackground();

    public Executor getExecutor() {
        return null;
    }

    public Priority getPriority() {
        return null;
    }

    public final ResultType getResult() {
        return this.e;
    }

    public final State getState() {
        return this.d;
    }

    public boolean isCancelFast() {
        return false;
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
    public final boolean isCancelled() {
        Callback.Cancelable cancelable;
        return this.c || this.d == State.CANCELLED || ((cancelable = this.b) != null && cancelable.isCancelled());
    }

    public final boolean isFinished() {
        return this.d.value() > State.STARTED.value();
    }

    public void onCancelled(Callback.CancelledException cancelledException) {
    }

    public abstract void onError(Throwable th, boolean z);

    public void onFinished() {
    }

    public void onStarted() {
    }

    public abstract void onSuccess(ResultType resulttype);

    public void onUpdate(int i, Object... objArr) {
    }

    public void onWaiting() {
    }

    public final void update(int i, Object... objArr) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.onUpdate(i, objArr);
        }
    }
}
