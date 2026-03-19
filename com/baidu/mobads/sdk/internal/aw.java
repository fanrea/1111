package com.baidu.mobads.sdk.internal;

import android.util.Log;
import com.baidu.mobads.sdk.internal.az;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class aw extends az.a {
    public static final String a = "debug";

    @Override // com.baidu.mobads.sdk.internal.az.a
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected boolean a(String str, int i) {
        return "bqt_ad_tag".equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i, String str, String str2, Throwable th) {
        a(i, str, str2);
    }

    private static void a(int i, String str, String str2) {
        try {
            if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
