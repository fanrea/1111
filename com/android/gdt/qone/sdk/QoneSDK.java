package com.android.gdt.qone.sdk;

import android.text.TextUtils;
import com.android.gdt.qone.a.e;
import com.android.gdt.qone.ak.o;
import com.android.gdt.qone.w.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class QoneSDK {
    public static volatile e a;

    public static IQoneSDK getInstance(String str) {
        o oVar;
        if (a == null) {
            synchronized (o.class) {
                ConcurrentHashMap concurrentHashMap = o.j;
                oVar = (o) concurrentHashMap.get(str);
                if (oVar == null) {
                    oVar = new o(str);
                    concurrentHashMap.put(str, oVar);
                    a.a(str);
                }
            }
            a = new e(oVar, str);
        }
        return a;
    }

    public static void setMainAppKey(String str) {
        a.a(str);
    }

    public static void setSoFullPath(String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(a.b)) {
                a.b = str;
            }
        }
    }
}
