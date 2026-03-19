package com.bytedance.sdk.component.gb.hc.hc.b;

import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends HandlerThread {
    private u d;

    public c() {
        super("csj_openlog");
    }

    public void d(u uVar) {
        this.d = uVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        u uVar = this.d;
        if (uVar != null) {
            uVar.b();
        }
    }
}
