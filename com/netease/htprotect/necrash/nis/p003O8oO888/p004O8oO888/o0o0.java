package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final String f106O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private final Ooo.O8oO888 f107O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final Map f108Ooo;

    public o0o0(Map map, String str, Ooo.O8oO888 o8oO888) {
        this.f108Ooo = map;
        this.f106O8oO888 = str;
        this.f107O8 = o8oO888;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (TextUtils.isEmpty(this.f106O8oO888) || this.f108Ooo == null || this.f107O8 == null || Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            Ooo.m594O8oO888(this.f106O8oO888, true, false, Ooo.m589O8oO888(this.f108Ooo, "utf-8"), null, null, new oO(this));
        } catch (UnsupportedEncodingException e) {
            o8o0.m579O8("EncodingException" + e.getMessage());
        }
    }
}
