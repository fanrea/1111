package com.bytedance.sdk.component.tc.c;

import com.bytedance.sdk.component.tc.d.h;
import com.bytedance.sdk.component.tc.mk;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends Thread {
    private h proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        h hVar = this.proxy;
        if (hVar != null) {
            hVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        h hVar = this.proxy;
        return hVar != null ? hVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new h(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.tc.c.d.d("PThread");
            mk.hc.mq().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.super.start();
                }
            }, mk.hc.c(), TimeUnit.MILLISECONDS);
        }
    }

    protected boolean isProxyEnable() {
        return mk.hc.hc(1);
    }

    public b() {
    }

    public b(Runnable runnable) {
        super(runnable);
    }

    public b(String str) {
        super(str);
    }

    public b(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public b(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public b(Runnable runnable, String str) {
        super(runnable, str);
    }

    public b(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public b(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}
