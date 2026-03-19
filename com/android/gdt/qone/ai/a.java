package com.android.gdt.qone.ai;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.android.gdt.qone.ae.g;
import com.android.gdt.qone.ag.o;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static void a(String str) {
        f fVarA = f.a();
        c cVarA = com.android.gdt.qone.r.b.a(fVarA);
        cVarA.a.put("6", "1005");
        o oVarA = o.a(str);
        HashMap map = new HashMap();
        Context contextA = com.android.gdt.qone.ar.d.h().a();
        map.put("a1", contextA == null ? "" : (String) g.a(ApplicationInfo.class.getName(), contextA.getApplicationInfo(), "primaryCpuAbi"));
        Context contextA2 = com.android.gdt.qone.ar.d.h().a();
        map.put("a2", contextA2 != null ? (String) g.a(ApplicationInfo.class.getName(), contextA2.getApplicationInfo(), "nativeLibraryDir") : "");
        map.put("a3", Build.CPU_ABI);
        map.put("a4", Build.CPU_ABI2);
        map.put("a5", oVarA.b());
        map.put("a6", Build.BRAND);
        map.put("a7", Build.VERSION.SDK);
        cVarA.a.put("7", new JSONObject(map).toString());
        fVarA.a(cVarA, com.alipay.sdk.m.x.c.d, str);
    }

    @com.android.gdt.qone.q.b
    public static int sendSoLoadError(String str) {
        f fVarA = f.a();
        c cVarA = com.android.gdt.qone.r.b.a(fVarA);
        cVarA.a.put("6", str);
        fVarA.a(cVarA, "L1", com.android.gdt.qone.w.a.a);
        return 0;
    }
}
