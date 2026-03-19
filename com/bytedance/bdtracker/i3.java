package com.bytedance.bdtracker;

import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.oneid.IDBindResult;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class i3 implements Runnable {
    public final /* synthetic */ IDBindCallback a;
    public final /* synthetic */ IDBindResult b;

    public i3(IDBindCallback iDBindCallback, IDBindResult iDBindResult) {
        this.a = iDBindCallback;
        this.b = iDBindResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSuccess(this.b);
    }
}
