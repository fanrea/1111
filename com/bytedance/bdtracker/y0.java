package com.bytedance.bdtracker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/exposure/task/ThrottleCheckExposureStrategy;", "Lcom/bytedance/applog/exposure/task/BaseCheckExposureStrategy;", "checkTask", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "isCheckFinish", "", "check", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class y0 extends w0 {
    public volatile boolean b;
    public final Runnable c;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y0.this.c.run();
            y0.this.b = true;
        }
    }

    public y0(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "checkTask");
        this.c = runnable;
        this.b = true;
    }

    @Override // com.bytedance.bdtracker.w0
    public void a() {
        if (this.b) {
            this.b = false;
            this.a.removeCallbacks(this.c);
            this.a.postDelayed(new a(), 500L);
        }
    }
}
