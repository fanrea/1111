package com.netease.htprotect.p001OO8;

import android.content.Context;
import com.netease.htprotect.p000O8oO888.O8oO888;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class Oo0 implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Context f32O8oO888;

    Oo0(Context context) {
        this.f32O8oO888 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String unused = oO.f47Ooo = O8oO888.m478O8oO888(this.f32O8oO888);
        if (oO.f45O8oO888 != null) {
            oO.f45O8oO888.countDown();
        }
    }
}
