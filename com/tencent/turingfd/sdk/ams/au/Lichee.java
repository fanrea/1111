package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.sigmob.sdk.base.mta.PointType;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Lichee {
    public static final Lichee g = new Lichee();
    public static final Set<Integer> h;
    public Foxnut d;
    public Kiwifruit e;
    public final Set<Integer> a = new HashSet();
    public final Set<Integer> b = new HashSet();
    public final Object c = new Object();
    public final Cassiopeia f = new Cdo(this);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Lichee$do, reason: invalid class name */
    public class Cdo implements Cassiopeia {
        public Cdo(Lichee lichee) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(6);
        hashSet.add(3);
        hashSet.add(32);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(40);
        hashSet.add(43);
        hashSet.add(19);
        hashSet.add(36);
        hashSet.add(45);
        hashSet.add(136);
        hashSet.add(143);
        hashSet.add(144);
        hashSet.add(10002);
        hashSet.add(10003);
        int i = Casaba.a;
        if (i == 105668 || i == 105928 || i == 108168) {
            hashSet.add(18);
        }
        h = Collections.unmodifiableSet(hashSet);
    }

    public long a(Context context) {
        long jCurrentTimeMillis;
        long j = 0;
        if (Lemon.f.d()) {
            return 0L;
        }
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            b(context);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } catch (Throwable unused) {
        }
        try {
            b();
            return jCurrentTimeMillis;
        } catch (Throwable unused2) {
            j = jCurrentTimeMillis;
            return j;
        }
    }

    public final void b() {
        Map<Integer, Integer> mapEmptyMap;
        try {
            Cprivate cprivateB = Lemon.f.b();
            if (cprivateB == null || (mapEmptyMap = cprivateB.e) == null) {
                mapEmptyMap = Collections.emptyMap();
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Map.Entry<Integer, Integer> entry : mapEmptyMap.entrySet()) {
                if (entry.getValue().intValue() == 0) {
                    hashSet.add(entry.getKey());
                } else {
                    hashSet2.add(entry.getKey());
                }
            }
            synchronized (this.b) {
                this.b.clear();
                this.b.addAll(h);
                this.b.addAll(hashSet);
                this.b.removeAll(hashSet2);
                synchronized (this.a) {
                    this.b.addAll(this.a);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final byte[] a(Context context, boolean z) {
        byte[] bArr = new byte[0];
        HashMap map = new HashMap();
        StringBuilder sbA = Bennet.a("");
        sbA.append(Casaba.a);
        map.put("1", sbA.toString());
        Foxnut foxnut = this.d;
        map.put(PointType.ANTI_SPAM, TextUtils.isEmpty(foxnut.q) ? "" : foxnut.q);
        Cprivate cprivateB = Lemon.f.b();
        if (cprivateB != null) {
            map.put("2026", String.valueOf(cprivateB.a));
            map.put("2027", String.valueOf(cprivateB.c));
        }
        map.put("207", Hickory.l.a(context).a);
        if (z) {
            map.put("264", Cdefault.a());
        } else {
            map.put("264", "PPNA");
        }
        try {
            SparseArray<Object> sparseArrayE90_BD4FE23C352252DC = TNative$aa.e90_BD4FE23C352252DC(new SparseArray(), context, map, Ginkgo.g);
            return Sagittarius.b(sparseArrayE90_BD4FE23C352252DC) != 0 ? bArr : Sagittarius.a(sparseArrayE90_BD4FE23C352252DC);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            java.lang.Object r1 = r10.c     // Catch: java.lang.Throwable -> L88
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L88
            com.tencent.turingfd.sdk.ams.au.Lemon r2 = com.tencent.turingfd.sdk.ams.au.Lemon.f     // Catch: java.lang.Throwable -> L85
            boolean r3 = r2.d()     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L39
            com.tencent.turingfd.sdk.ams.au.Kiwifruit r3 = r10.e     // Catch: java.lang.Throwable -> L85
            java.lang.String r4 = "501"
            long r3 = r3.a(r11, r4)     // Catch: java.lang.Throwable -> L85
            com.tencent.turingfd.sdk.ams.au.private r5 = r2.b()     // Catch: java.lang.Throwable -> L85
            if (r5 == 0) goto L23
            long r5 = r5.f     // Catch: java.lang.Throwable -> L85
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L26
        L23:
            r5 = 57600(0xe100, double:2.8458E-319)
        L26:
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L85
            long r7 = r7 - r3
            long r3 = java.lang.Math.abs(r7)     // Catch: java.lang.Throwable -> L85
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L39
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            return
        L39:
            com.tencent.turingfd.sdk.ams.au.Foxnut r3 = r10.d     // Catch: java.lang.Throwable -> L85
            com.tencent.turingfd.sdk.ams.au.Centaurus r3 = r3.c()     // Catch: java.lang.Throwable -> L85
            boolean r3 = r3.a()     // Catch: java.lang.Throwable -> L85
            byte[] r6 = r10.a(r11, r3)     // Catch: java.lang.Throwable -> L85
            int r4 = r6.length     // Catch: java.lang.Throwable -> L85
            if (r4 != 0) goto L4c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            return
        L4c:
            com.tencent.turingfd.sdk.ams.au.Loquat r4 = com.tencent.turingfd.sdk.ams.au.Loquat.b     // Catch: java.lang.Throwable -> L85
            r5 = 4
            r7 = 8119(0x1fb7, float:1.1377E-41)
            r8 = 18119(0x46c7, float:2.539E-41)
            com.tencent.turingfd.sdk.ams.au.Cassiopeia r9 = r10.f     // Catch: java.lang.Throwable -> L85
            com.tencent.turingfd.sdk.ams.au.Mangosteen r4 = r4.a(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L85
            byte[] r4 = r4.d     // Catch: java.lang.Throwable -> L85
            com.tencent.turingfd.sdk.ams.au.private r4 = r10.a(r4)     // Catch: java.lang.Throwable -> L85
            if (r4 != 0) goto L63
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            return
        L63:
            r2.a(r4, r3)     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L83
            com.tencent.turingfd.sdk.ams.au.Kiwifruit r2 = r10.e     // Catch: java.lang.Throwable -> L85
            r2.getClass()     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L85
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L85
            r3.append(r4)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = "501"
            r4 = 1
            r2.a(r11, r3, r0, r4)     // Catch: java.lang.Throwable -> L85
        L83:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            goto L88
        L85:
            r11 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            throw r11     // Catch: java.lang.Throwable -> L88
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Lichee.b(android.content.Context):void");
    }

    public final Cprivate a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        int i = Ginkgo.g;
        if (i == 1) {
            try {
                bArr = Sagittarius.a(TNative$aa.f90_BD4FE23C352252DC(new SparseArray(), bArr, i));
            } catch (Throwable unused) {
                return null;
            }
        } else if (i != 0) {
            bArr = bArr2;
        }
        try {
            Cantaloupe cantaloupe = new Cantaloupe();
            cantaloupe.a(new Draco(bArr));
            int i2 = cantaloupe.a;
            if (i2 < 0) {
                return null;
            }
            if (i2 == 1) {
                return new Cprivate();
            }
            Cprivate cprivate = cantaloupe.b;
            if (cprivate == null) {
                return new Cprivate();
            }
            Log.e("D" + Casaba.a, "s:" + cprivate.a + ",v:" + cprivate.c);
            for (Map.Entry<Integer, Integer> entry : cprivate.e.entrySet()) {
            }
            Map<String, String> map = cprivate.g;
            if (map != null) {
                for (String str : map.keySet()) {
                }
            }
            return cprivate;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean a(int i) {
        boolean z;
        synchronized (this.b) {
            z = !this.b.contains(Integer.valueOf(i));
        }
        return z;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.b) {
            for (Integer num : this.b) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
