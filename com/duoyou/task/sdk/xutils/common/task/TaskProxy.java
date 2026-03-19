package com.duoyou.task.sdk.xutils.common.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.task.AbsTask;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.x;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskProxy<ResultType> extends AbsTask<ResultType> {
    private static final int MSG_WHAT_BASE = 1000000000;
    private static final int MSG_WHAT_ON_CANCEL = 1000000006;
    private static final int MSG_WHAT_ON_ERROR = 1000000004;
    private static final int MSG_WHAT_ON_FINISHED = 1000000007;
    private static final int MSG_WHAT_ON_START = 1000000002;
    private static final int MSG_WHAT_ON_SUCCESS = 1000000003;
    private static final int MSG_WHAT_ON_UPDATE = 1000000005;
    private static final int MSG_WHAT_ON_WAITING = 1000000001;
    private volatile boolean callOnCanceled;
    private volatile boolean callOnFinished;
    private final Executor executor;
    private final Handler handler;
    private final AbsTask<ResultType> task;
    public static final InternalHandler sHandler = new InternalHandler();
    public static final PriorityExecutor sDefaultExecutor = new PriorityExecutor(true);

    public TaskProxy(AbsTask<ResultType> absTask) {
        super(absTask);
        this.callOnCanceled = false;
        this.callOnFinished = false;
        this.task = absTask;
        absTask.setTaskProxy(this);
        setTaskProxy(null);
        Looper looperCustomLooper = absTask.customLooper();
        if (looperCustomLooper != null) {
            this.handler = new InternalHandler(looperCustomLooper);
        } else {
            this.handler = sHandler;
        }
        Executor executor = absTask.getExecutor();
        this.executor = executor == null ? sDefaultExecutor : executor;
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public final ResultType doBackground() {
        onWaiting();
        this.executor.execute(new PriorityRunnable(this.task.getPriority(), new Runnable() { // from class: com.duoyou.task.sdk.xutils.common.task.TaskProxy.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                    } catch (Callback.CancelledException e) {
                        TaskProxy.this.onCancelled(e);
                        return;
                    } catch (Throwable th) {
                        TaskProxy.this.onError(th, false);
                        return;
                    }
                    if (TaskProxy.this.callOnCanceled || TaskProxy.this.isCancelled()) {
                        throw new Callback.CancelledException("");
                    }
                    TaskProxy.this.onStarted();
                    if (!TaskProxy.this.isCancelled()) {
                        TaskProxy.this.task.setResult(TaskProxy.this.task.doBackground());
                        TaskProxy taskProxy = TaskProxy.this;
                        taskProxy.setResult(taskProxy.task.getResult());
                        if (TaskProxy.this.isCancelled()) {
                            throw new Callback.CancelledException("");
                        }
                        TaskProxy taskProxy2 = TaskProxy.this;
                        taskProxy2.onSuccess(taskProxy2.task.getResult());
                        return;
                    }
                    throw new Callback.CancelledException("");
                } finally {
                    TaskProxy.this.onFinished();
                }
            }
        }));
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onWaiting() {
        setState(AbsTask.State.WAITING);
        this.handler.obtainMessage(MSG_WHAT_ON_WAITING, this).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onStarted() {
        setState(AbsTask.State.STARTED);
        this.handler.obtainMessage(MSG_WHAT_ON_START, this).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onSuccess(ResultType resulttype) {
        setState(AbsTask.State.SUCCESS);
        this.handler.obtainMessage(MSG_WHAT_ON_SUCCESS, this).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onError(Throwable th, boolean z) {
        setState(AbsTask.State.ERROR);
        this.handler.obtainMessage(MSG_WHAT_ON_ERROR, new ArgsObj(this, th)).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onUpdate(int i, Object... objArr) {
        this.handler.obtainMessage(MSG_WHAT_ON_UPDATE, i, i, new ArgsObj(this, objArr)).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onCancelled(Callback.CancelledException cancelledException) {
        setState(AbsTask.State.CANCELLED);
        this.handler.obtainMessage(MSG_WHAT_ON_CANCEL, new ArgsObj(this, cancelledException)).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public void onFinished() {
        this.handler.obtainMessage(MSG_WHAT_ON_FINISHED, this).sendToTarget();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public final void setState(AbsTask.State state) {
        super.setState(state);
        this.task.setState(state);
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public final Priority getPriority() {
        return this.task.getPriority();
    }

    @Override // com.duoyou.task.sdk.xutils.common.task.AbsTask
    public final Executor getExecutor() {
        return this.executor;
    }

    public static class ArgsObj {
        public final Object[] args;
        public final TaskProxy taskProxy;

        public ArgsObj(TaskProxy taskProxy, Object... objArr) {
            this.taskProxy = taskProxy;
            this.args = objArr;
        }
    }

    public static final class InternalHandler extends Handler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        private InternalHandler() {
            super(Looper.getMainLooper());
        }

        private InternalHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] objArr;
            Object obj = message.obj;
            if (obj == null) {
                throw new IllegalArgumentException("msg must not be null");
            }
            TaskProxy taskProxy = null;
            if (obj instanceof TaskProxy) {
                taskProxy = (TaskProxy) obj;
                objArr = null;
            } else if (obj instanceof ArgsObj) {
                ArgsObj argsObj = (ArgsObj) obj;
                taskProxy = argsObj.taskProxy;
                objArr = argsObj.args;
            } else {
                objArr = null;
            }
            if (taskProxy != null) {
                try {
                    switch (message.what) {
                        case TaskProxy.MSG_WHAT_ON_WAITING /* 1000000001 */:
                            taskProxy.task.onWaiting();
                            break;
                        case TaskProxy.MSG_WHAT_ON_START /* 1000000002 */:
                            taskProxy.task.onStarted();
                            break;
                        case TaskProxy.MSG_WHAT_ON_SUCCESS /* 1000000003 */:
                            taskProxy.task.onSuccess(taskProxy.getResult());
                            break;
                        case TaskProxy.MSG_WHAT_ON_ERROR /* 1000000004 */:
                            Throwable th = (Throwable) objArr[0];
                            LogUtil.d(th.getMessage(), th);
                            taskProxy.task.onError(th, false);
                            break;
                        case TaskProxy.MSG_WHAT_ON_UPDATE /* 1000000005 */:
                            taskProxy.task.onUpdate(message.arg1, objArr);
                            break;
                        case TaskProxy.MSG_WHAT_ON_CANCEL /* 1000000006 */:
                            if (!taskProxy.callOnCanceled) {
                                taskProxy.callOnCanceled = true;
                                taskProxy.task.onCancelled((Callback.CancelledException) objArr[0]);
                                break;
                            } else {
                                return;
                            }
                        case TaskProxy.MSG_WHAT_ON_FINISHED /* 1000000007 */:
                            if (!taskProxy.callOnFinished) {
                                taskProxy.callOnFinished = true;
                                taskProxy.task.onFinished();
                                break;
                            } else {
                                return;
                            }
                    }
                    return;
                } catch (Throwable th2) {
                    taskProxy.setState(AbsTask.State.ERROR);
                    if (message.what != TaskProxy.MSG_WHAT_ON_ERROR) {
                        taskProxy.task.onError(th2, true);
                        return;
                    } else {
                        if (x.isDebug()) {
                            throw new RuntimeException(th2);
                        }
                        return;
                    }
                }
            }
            throw new RuntimeException("msg.obj not instanceof TaskProxy");
        }
    }
}
