package com.android.gdt.qone.w;

import android.os.SystemClock;
import com.android.gdt.oaid2.IVendorCallback;
import com.android.gdt.qone.ag.h;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements IVendorCallback {
    public final /* synthetic */ h a;
    public final /* synthetic */ c b;

    public b(c cVar, h hVar) {
        this.b = cVar;
        this.a = hVar;
    }

    @Override // com.android.gdt.oaid2.IVendorCallback
    public final void onResult(boolean z, String str, String str2) {
        this.b.h = str2;
        int i = (str2 == null || str2.isEmpty()) ? 0 : 1;
        if (i != 0) {
            this.b.c = SystemClock.elapsedRealtime() - this.b.b;
        }
        h hVar = this.a;
        int i2 = i ^ 1;
        synchronized (hVar.b.b) {
            if (!hVar.b.c) {
                hVar.a.a(i2);
                hVar.b.c = true;
            }
        }
    }
}
