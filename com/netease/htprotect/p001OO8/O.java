package com.netease.htprotect.p001OO8;

import android.content.Context;
import com.netease.htprotect.p008O.O8oO888;

/* renamed from: com.netease.htprotect.OO〇8.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Context f33O8oO888;

    O(Context context) {
        this.f33O8oO888 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            String unused = oO.f46O8 = O8oO888.m635O8oO888(this.f33O8oO888);
            if (oO.f45O8oO888 == null) {
                return;
            }
        } catch (Exception unused2) {
            if (oO.f45O8oO888 == null) {
                return;
            }
        } catch (Throwable th) {
            if (oO.f45O8oO888 != null) {
                oO.f45O8oO888.countDown();
            }
            throw th;
        }
        oO.f45O8oO888.countDown();
    }
}
