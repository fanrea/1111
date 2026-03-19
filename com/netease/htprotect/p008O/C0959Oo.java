package com.netease.htprotect.p008O;

import android.content.Context;
import android.provider.Settings;

/* renamed from: com.netease.htprotect.〇O.O〇〇〇o, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0959Oo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m670O8oO888(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "oaid");
        } catch (Exception unused) {
            return null;
        }
    }
}
