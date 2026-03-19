package com.bytedance.bdtracker;

import android.app.Activity;
import com.bytedance.applog.exposure.ViewExposureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/exposure/task/ViewExposureTask;", "", "manager", "Lcom/bytedance/applog/exposure/ViewExposureManager;", "(Lcom/bytedance/applog/exposure/ViewExposureManager;)V", "checkStrategy", "Lcom/bytedance/applog/exposure/task/BaseCheckExposureStrategy;", "getCheckStrategy", "()Lcom/bytedance/applog/exposure/task/BaseCheckExposureStrategy;", "setCheckStrategy", "(Lcom/bytedance/applog/exposure/task/BaseCheckExposureStrategy;)V", "checkTask", "Ljava/lang/Runnable;", "check", "", "updateExposureCheckStrategy", "exposureCheckType", "Lcom/bytedance/applog/exposure/ExposureCheckType;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class a1 {
    public final Runnable a;
    public w0 b;
    public final ViewExposureManager c;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Activity currActivity = a1.this.c.getCurrActivity();
            if (currActivity != null) {
                a1.this.c.checkViewExposureFromActivity$agent_liteChinaRelease(currActivity);
            }
        }
    }

    public a1(ViewExposureManager viewExposureManager) {
        Intrinsics.checkParameterIsNotNull(viewExposureManager, "manager");
        this.c = viewExposureManager;
        a aVar = new a();
        this.a = aVar;
        this.b = new x0(aVar);
    }

    public final void a(r0 r0Var) {
        this.b = (r0Var != null && z0.a[r0Var.ordinal()] == 1) ? new y0(this.a) : new x0(this.a);
    }
}
