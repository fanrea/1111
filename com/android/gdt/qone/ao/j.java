package com.android.gdt.qone.ao;

import com.android.gdt.qone.sdk.S.DataFormatter;
import com.android.gdt.qone.sdk.S.SpreadValue;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class j {
    public static final String f = com.android.gdt.qone.ae.b.a();
    public String a;
    public String b;
    public String c;
    public com.android.gdt.qone.u.d d;
    public final DataFormatter e;

    public j() {
        DataFormatter dataFormatterA = new c().a();
        this.e = dataFormatterA;
        com.android.gdt.qone.af.c.b("SpreadQM", "%s%s load current cache size: %s", this.a, this.b, Integer.valueOf(dataFormatterA.a().size()));
    }

    public final synchronized boolean a(HashMap map, String str, String str2) {
        boolean z;
        HashMap mapA = this.e.a();
        z = false;
        for (Map.Entry entry : map.entrySet()) {
            if (!mapA.containsKey(entry.getKey())) {
                ((SpreadValue) entry.getValue()).c(str);
                ((SpreadValue) entry.getValue()).d(str2);
                ((SpreadValue) entry.getValue()).b(System.currentTimeMillis());
                mapA.put(entry.getKey(), entry.getValue());
            } else if (mapA.get(entry.getKey()) != null && !((SpreadValue) mapA.get(entry.getKey())).equals(entry.getValue())) {
                String str3 = (String) entry.getKey();
                SpreadValue spreadValue = (SpreadValue) mapA.get(str3);
                spreadValue.e(((SpreadValue) entry.getValue()).f());
                spreadValue.a(((SpreadValue) entry.getValue()).a());
                spreadValue.f(((SpreadValue) entry.getValue()).g());
                spreadValue.g(((SpreadValue) entry.getValue()).h());
                spreadValue.c(str);
                spreadValue.d(str2);
                spreadValue.b(System.currentTimeMillis());
                mapA.put(str3, spreadValue);
            }
            z = true;
        }
        com.android.gdt.qone.af.c.b("SpreadQM", "update data,from:appKey:%s  source:%s  updateResult:%b", str, str2, Boolean.valueOf(z));
        if (z) {
            this.e.a(mapA);
            com.android.gdt.qone.ad.b.a.a(true);
            new c().a(this.e);
        }
        return z;
    }
}
