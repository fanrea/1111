package com.permissionx.guolindev.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestChain.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\tJ\r\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/permissionx/guolindev/request/RequestChain;", "", "()V", "headTask", "Lcom/permissionx/guolindev/request/BaseTask;", "tailTask", "addTaskToChain", "", "task", "addTaskToChain$permissionx_release", "runTask", "runTask$permissionx_release", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class RequestChain {
    private BaseTask headTask;
    private BaseTask tailTask;

    public final void addTaskToChain$permissionx_release(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.headTask == null) {
            this.headTask = task;
        }
        BaseTask baseTask = this.tailTask;
        if (baseTask != null) {
            baseTask.next = task;
        }
        this.tailTask = task;
    }

    public final void runTask$permissionx_release() {
        BaseTask baseTask = this.headTask;
        if (baseTask != null) {
            baseTask.request();
        }
    }
}
