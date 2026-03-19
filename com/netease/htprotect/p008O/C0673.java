package com.netease.htprotect.p008O;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* renamed from: com.netease.htprotect.〇O.〇〇, reason: contains not printable characters */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0673 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m714O8oO888(Context context) {
        String string;
        String str;
        try {
            string = Settings.Global.getString(context.getContentResolver(), "oaid");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(string) && string.length() == 32) {
            return string;
        }
        Object systemService = context.getSystemService("ovum_msaserver");
        if (systemService != null && (str = (String) systemService.getClass().getDeclaredMethod("getOaid", new Class[0]).invoke(systemService, new Object[0])) != null) {
            if (str.length() == 32) {
                return str;
            }
        }
        return null;
    }
}
