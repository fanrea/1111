package com.bytedance.sdk.component.tc.d;

import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.component.tc.tc;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements ThreadFactory {
    private final ThreadFactory d;
    private final int hc;

    public c(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.d = new tc(ILogConst.PLAY_SOURCE_DEFAULT);
        } else {
            this.d = threadFactory;
        }
        this.hc = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.d.newThread(runnable);
        return hc() ? new h(threadNewThread) : threadNewThread;
    }

    public final String d() {
        return this.d.getClass().getName();
    }

    protected boolean hc() {
        return mk.hc.hc(this.hc);
    }
}
