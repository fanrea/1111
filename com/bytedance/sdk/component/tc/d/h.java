package com.bytedance.sdk.component.tc.d;

import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.component.tc.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h extends Thread {
    private final Thread b;
    private volatile Thread d;
    private volatile boolean hc;

    public h(Thread thread) {
        this.b = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.d != null) {
            this.d.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.d != null) {
            return this.d.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.hc) {
            return;
        }
        this.hc = true;
        mk.hc.tc().execute(new com.bytedance.sdk.component.tc.b.b(new tt(this.b.getName()) { // from class: com.bytedance.sdk.component.tc.d.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (mk.hc.e()) {
                    h.this.d();
                } else {
                    h.this.hc();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            hc hcVarB = mk.hc.b();
            String name2 = this.b.getName();
            if (hcVarB != null) {
                name2 = hcVarB.d(name2);
            }
            threadCurrentThread.setName(name2);
            this.d = threadCurrentThread;
            threadCurrentThread.setPriority(this.b.getPriority());
            this.b.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc() {
        Thread threadCurrentThread = Thread.currentThread();
        this.d = threadCurrentThread;
        threadCurrentThread.setPriority(this.b.getPriority());
        this.b.run();
    }
}
