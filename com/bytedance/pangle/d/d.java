package com.bytedance.pangle.d;

import com.bytedance.pangle.u.u;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    Throwable d;
    private final CountDownLatch hc;

    /* renamed from: com.bytedance.pangle.d.d$d, reason: collision with other inner class name */
    public interface InterfaceC0251d {
        void d() throws Throwable;
    }

    private d(boolean z, InterfaceC0251d[] interfaceC0251dArr) {
        this.hc = new CountDownLatch(interfaceC0251dArr.length);
        for (final InterfaceC0251d interfaceC0251d : interfaceC0251dArr) {
            u.d(new Runnable() { // from class: com.bytedance.pangle.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0251d.d();
                    } catch (Throwable th) {
                        d.this.d = th;
                    }
                    d.this.hc.countDown();
                }
            }, z);
        }
    }

    public static void d(boolean z, InterfaceC0251d... interfaceC0251dArr) throws Throwable {
        new d(z, interfaceC0251dArr).d();
    }

    private void d() throws Throwable {
        try {
            this.hc.await();
            Throwable th = this.d;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
