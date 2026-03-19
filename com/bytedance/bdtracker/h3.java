package com.bytedance.bdtracker;

import com.bytedance.applog.oneid.IDBindCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h3 implements Runnable {
    public final /* synthetic */ IDBindCallback a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public h3(IDBindCallback iDBindCallback, int i, String str) {
        this.a = iDBindCallback;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onFail(this.b, this.c);
    }
}
