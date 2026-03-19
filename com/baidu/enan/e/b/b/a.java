package com.baidu.enan.e.b.b;

import android.text.TextUtils;
import com.baidu.enan.e.d.c;
import com.baidu.enan.f.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a() {
        try {
            return a(b.a("c3RhdCAvc3lzdGVtL2J1aWxkLnByb3A="));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static String a(String str) {
        try {
            c.a aVarA = c.a(str, false);
            if (!TextUtils.isEmpty(aVarA.b)) {
                return aVarA.b;
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
        return "";
    }
}
