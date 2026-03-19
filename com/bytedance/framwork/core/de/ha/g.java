package com.bytedance.framwork.core.de.ha;

import android.util.Log;

/* compiled from: LogUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class g {
    public static void a(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        if (str2.length() <= 3072) {
            Log.d(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String strSubstring = str2.substring(0, 3072);
            str2 = str2.replace(strSubstring, "");
            Log.d(str, strSubstring);
        }
        Log.d(str, str2);
    }
}
