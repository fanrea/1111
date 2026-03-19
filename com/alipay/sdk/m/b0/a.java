package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String strA;
        synchronized (a.class) {
            String strB = null;
            if (context != null) {
                try {
                    if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2)) {
                        try {
                            strA = e.a(context, str, str2, "");
                        } catch (Throwable unused) {
                        }
                        if (com.alipay.sdk.m.z.a.a(strA)) {
                            return null;
                        }
                        strB = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), strA);
                        return strB;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2) || context == null) {
                return;
            }
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
