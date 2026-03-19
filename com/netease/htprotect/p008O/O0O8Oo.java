package com.netease.htprotect.p008O;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* renamed from: com.netease.htprotect.〇O.O〇0O8Oo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O0O8Oo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m659O8oO888(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string) && string.length() == 36) {
                if (!"00000000-0000-0000-0000-000000000000".equals(string)) {
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
