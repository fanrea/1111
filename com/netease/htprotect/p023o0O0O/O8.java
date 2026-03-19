package com.netease.htprotect.p023o0O0O;

import android.app.Application;
import com.netease.htprotect.p023o0O0O.Ooo;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O8 implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Ooo.O8oO888 f602O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ Application f603Ooo;

    O8(Ooo.O8oO888 o8oO888, Application application) {
        this.f602O8oO888 = o8oO888;
        this.f603Ooo = application;
    }

    @Override // java.lang.Runnable
    public final void run() {
        oO unused = Ooo.f609oO = new oO(this.f602O8oO888);
        synchronized (Ooo.class) {
            this.f603Ooo.unregisterActivityLifecycleCallbacks(Ooo.f609oO);
            this.f603Ooo.registerActivityLifecycleCallbacks(Ooo.f609oO);
        }
        Ooo.f610o0O0O.postDelayed(new o0o0(this.f602O8oO888), 60000L);
    }
}
