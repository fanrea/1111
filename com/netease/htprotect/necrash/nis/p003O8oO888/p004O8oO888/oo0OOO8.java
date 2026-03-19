package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import java.util.Map;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.oo0〇OO〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oo0OOO8 implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final String f98O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private final Ooo.O8oO888 f99O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final Map f100Ooo;

    private oo0OOO8(Map map, String str, Ooo.O8oO888 o8oO888) {
        this.f100Ooo = map;
        this.f98O8oO888 = str;
        this.f99O8 = o8oO888;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        if (TextUtils.isEmpty(this.f98O8oO888) || (map = this.f100Ooo) == null || this.f99O8 == null) {
            return;
        }
        Ooo.m593O8oO888(this.f98O8oO888, map, new O80Oo0O(this));
    }
}
