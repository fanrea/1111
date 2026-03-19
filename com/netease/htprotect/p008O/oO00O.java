package com.netease.htprotect.p008O;

import android.os.IBinder;

/* renamed from: com.netease.htprotect.〇O.〇oO00O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class oO00O implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ IBinder f244O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ O8O00oo f245Ooo;

    oO00O(O8O00oo o8O00oo, IBinder iBinder) {
        this.f245Ooo = o8O00oo;
        this.f244O8oO888 = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f245Ooo.f237Ooo.offer(this.f244O8oO888);
        } catch (Throwable unused) {
        }
    }
}
