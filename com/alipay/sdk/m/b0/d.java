package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        if (!com.alipay.sdk.m.z.a.a(str)) {
            if (!com.alipay.sdk.m.z.a.a(str2) && context != null) {
                try {
                    String strA = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
                    HashMap map = new HashMap();
                    map.put(str2, strA);
                    e.a(context, str, map);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
