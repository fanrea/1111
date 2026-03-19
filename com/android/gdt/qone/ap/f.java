package com.android.gdt.qone.ap;

import android.text.TextUtils;
import com.android.gdt.qone.ak.n;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class f {
    public static final /* synthetic */ int a = 0;

    static {
        new ConcurrentHashMap();
    }

    public static com.android.gdt.qone.ak.b a(String str) {
        if (str == null || str.isEmpty() || com.android.gdt.qone.ar.d.h().a() == null) {
            return null;
        }
        return com.android.gdt.qone.ak.c.a(str).b;
    }

    public static com.android.gdt.qone.ak.b b(String str) throws IOException {
        String[] strArr = new String[1];
        boolean zA = new com.android.gdt.qone.x.b().a("lccNoCN", new d(strArr, str), 2);
        com.android.gdt.qone.af.c.b("[appInfo]", "appKey:%s query readable lock state %b", str, Boolean.valueOf(zA));
        if (!zA) {
            strArr[0] = com.android.gdt.qone.an.a.a.a(str);
        }
        String str2 = strArr[0];
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        com.android.gdt.qone.ak.b bVar = new com.android.gdt.qone.ak.b(com.android.gdt.qone.ak.d.a.a(str2), com.android.gdt.qone.ak.d.b.a(str2), str);
        return bVar.c() ? new com.android.gdt.qone.ak.b(com.android.gdt.qone.ak.d.c.a(str2), com.android.gdt.qone.ak.d.d.a(str2), str) : bVar;
    }

    public static void a(n nVar) {
        com.android.gdt.qone.v.a.a().a(TimeUnit.HOURS.toMillis(24L) + TimeUnit.SECONDS.toMillis(5L), nVar);
    }
}
