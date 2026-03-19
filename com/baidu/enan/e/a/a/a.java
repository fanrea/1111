package com.baidu.enan.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.enan.f.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return a();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static String a() {
        String property;
        Throwable th;
        try {
            property = System.getProperty(b.a("aHR0cC5wcm94eUhvc3Q="));
        } catch (Throwable th2) {
            property = "";
            th = th2;
        }
        try {
            return TextUtils.isEmpty(property) ? "" : property;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.enan.f.a.a(th);
            return property;
        }
    }
}
