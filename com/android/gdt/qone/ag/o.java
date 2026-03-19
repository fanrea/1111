package com.android.gdt.qone.ag;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class o {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public final String a;
    public final Object b = new Object();
    public boolean c = false;

    public o(String str) {
        this.a = str;
    }

    public static synchronized o a(String str) {
        o oVar;
        ConcurrentHashMap concurrentHashMap = d;
        oVar = (o) concurrentHashMap.get(str);
        if (oVar == null) {
            oVar = new o(str);
            concurrentHashMap.put(str, oVar);
        }
        return oVar;
    }

    public final String b() {
        String str = com.android.gdt.qone.at.a.a(this.a).a.k;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.android.gdt.qone.av.a aVar = com.android.gdt.qone.at.a.a(this.a).a;
        return (aVar.d && aVar.e) ? p.a().a(6, new a()) : "";
    }

    public final String c() {
        return !com.android.gdt.qone.at.a.a(this.a).a.e ? "" : p.a().a(11, new m());
    }

    public final String a() {
        String str = com.android.gdt.qone.at.a.a(this.a).a.j;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.android.gdt.qone.av.a aVar = com.android.gdt.qone.at.a.a(this.a).a;
        return (aVar.b && aVar.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.i, aVar.l).booleanValue()) ? p.a().a(3, new k()) : "";
    }
}
