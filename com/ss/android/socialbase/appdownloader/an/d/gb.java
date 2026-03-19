package com.ss.android.socialbase.appdownloader.an.d;

import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb extends Exception {
    protected int b;
    protected Throwable d;
    protected int hc;

    public gb(String str, h hVar, Throwable th) {
        super((str == null ? "" : str + " ") + (hVar == null ? "" : "(position:" + hVar.c() + ") ") + (th != null ? "caused by: " + th : ""));
        this.hc = -1;
        this.b = -1;
        if (hVar != null) {
            this.hc = hVar.b();
            this.b = hVar.an();
        }
        this.d = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.d == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            mq.d(this.d);
        }
    }
}
