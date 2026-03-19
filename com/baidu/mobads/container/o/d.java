package com.baidu.mobads.container.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cd;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static volatile d a;
    private final Map<String, a> b = Collections.synchronizedMap(new b(10));
    private final Map<String, a> c = Collections.synchronizedMap(new b(10));

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(Context context, String str, int i, boolean z, boolean z2, String str2, String str3, String str4) {
        a aVarB;
        if (com.baidu.mobads.container.h.a.a().D() && (aVarB = b(context, str, i, z, z2, str2, str3, str4)) != null) {
            com.baidu.mobads.container.d.b.a().a(aVarB, 1L, TimeUnit.SECONDS);
        }
    }

    private a b(Context context, String str, int i, boolean z, boolean z2, String str2, String str3, String str4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 1 || i == 2) {
            a aVar = this.b.get(str);
            if (aVar == null) {
                try {
                    jCurrentTimeMillis = context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
                } catch (Throwable th) {
                    com.baidu.mobads.container.l.g.e(th.getMessage());
                }
                a aVar2 = new a(context, str, z2, jCurrentTimeMillis, z, i, str2, str3, str4);
                this.b.put(str, aVar2);
                return aVar2;
            }
            if (aVar.d == 2) {
                aVar.d = i;
            }
            if (!aVar.e) {
                aVar.e = z;
            }
            if (!aVar.f) {
                aVar.f = z2;
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.g = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                aVar.h = str3;
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            aVar.i = str4;
            return null;
        }
        if (this.c.get(str) != null) {
            return null;
        }
        a aVar3 = new a(context, str, z2, jCurrentTimeMillis, z, i, str2, str3, str4);
        this.c.put(str, aVar3);
        return aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, long j, int i, boolean z, boolean z2, String str2, String str3, String str4) {
        try {
            HashMap map = new HashMap();
            String str5 = "0";
            if (i == 1 || i == 2) {
                map.put("from", z ? "1" : "2");
            } else {
                map.put("from", "0");
            }
            map.put("eventtime", j + "");
            if (z) {
                str5 = z2 ? "2" : "1";
            }
            map.put("dltype", str5);
            map.put("eventtype", i + "");
            map.put("pk", str);
            map.put("qk", str2);
            map.put(com.baidu.mobads.container.components.h.b.e.b, str3);
            map.put("adid", str4);
            cd.a(context, 1, (HashMap<String, String>) map, true);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(th.getMessage());
        }
    }

    private static class a extends com.baidu.mobads.container.d.a {
        private final Context a;
        private final String b;
        private final long c;
        private int d;
        private boolean e;
        private boolean f;
        private String g;
        private String h;
        private String i;

        public a(Context context, String str, boolean z, long j, boolean z2, int i, String str2, String str3, String str4) {
            this.a = context;
            this.b = str;
            this.f = z;
            this.c = j;
            this.e = z2;
            this.d = i;
            this.g = str2;
            this.h = str3;
            this.i = str4;
        }

        @Override // com.baidu.mobads.container.d.a
        protected Object a() {
            d.a().a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            if (this.d == 1 || this.d == 2) {
                d.a().b.remove(this.b);
                return null;
            }
            d.a().c.remove(this.b);
            return null;
        }
    }

    private static class b<K, V> extends LinkedHashMap<K, V> {
        private final int a;

        public b(int i) {
            super(i, 0.75f, true);
            this.a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.a;
        }
    }
}
