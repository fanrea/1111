package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.a.c.get(0);
                this.a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.b(this.a);
            throw th;
        }
        b.b(this.a);
    }
}
