package com.bytedance.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class x0 extends w0 {
    public final Runnable b;

    public x0(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "checkTask");
        this.b = runnable;
    }

    @Override // com.bytedance.bdtracker.w0
    public void a() {
        this.a.removeCallbacks(this.b);
        this.a.postDelayed(this.b, 100L);
    }
}
