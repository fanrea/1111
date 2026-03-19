package com.duoyou.task.sdk.xutils.common.task;

import android.os.Looper;
import com.duoyou.task.sdk.xutils.common.Callback;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class AbsTask<ResultType> implements Callback.Cancelable {
    private final Callback.Cancelable cancelHandler;
    private volatile boolean isCancelled;
    private ResultType result;
    private volatile State state;
    private TaskProxy taskProxy;

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

    public boolean isCancelFast() {
        return false;
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

    public AbsTask() {
        this(null);
    }

    public AbsTask(Callback.Cancelable cancelable) {
        this.taskProxy = null;
        this.isCancelled = false;
        this.state = State.IDLE;
        this.cancelHandler = cancelable;
    }

    public final void update(int i, Object... objArr) {
        TaskProxy taskProxy = this.taskProxy;
        if (taskProxy != null) {
            taskProxy.onUpdate(i, objArr);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
    public final void cancel() {
        if (this.isCancelled) {
            return;
        }
        synchronized (this) {
            if (this.isCancelled) {
                return;
            }
            this.isCancelled = true;
            cancelWorks();
            Callback.Cancelable cancelable = this.cancelHandler;
            if (cancelable != null && !cancelable.isCancelled()) {
                this.cancelHandler.cancel();
            }
            if (this.state == State.WAITING || (this.state == State.STARTED && isCancelFast())) {
                TaskProxy taskProxy = this.taskProxy;
                if (taskProxy != null) {
                    taskProxy.onCancelled(new Callback.CancelledException("cancelled by user"));
                    this.taskProxy.onFinished();
                } else if (this instanceof TaskProxy) {
                    onCancelled(new Callback.CancelledException("cancelled by user"));
                    onFinished();
                }
            }
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
    public final boolean isCancelled() {
        Callback.Cancelable cancelable;
        return this.isCancelled || this.state == State.CANCELLED || ((cancelable = this.cancelHandler) != null && cancelable.isCancelled());
    }

    public final boolean isFinished() {
        return this.state.value() > State.STARTED.value();
    }

    public final State getState() {
        return this.state;
    }

    public final ResultType getResult() {
        return this.result;
    }

    public void setState(State state) {
        this.state = state;
    }

    public final void setTaskProxy(TaskProxy taskProxy) {
        this.taskProxy = taskProxy;
    }

    public final void setResult(ResultType resulttype) {
        this.result = resulttype;
    }

    public enum State {
        IDLE(0),
        WAITING(1),
        STARTED(2),
        SUCCESS(3),
        CANCELLED(4),
        ERROR(5);

        private final int value;

        State(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }
}
