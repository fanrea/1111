package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Random;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class o00 {
    private static final vx a;
    private static final int b;
    private static final int c;
    private static final boolean d;
    private static final boolean e;
    private static final boolean f;
    private static final int g;
    private static final boolean h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    private static final int n;
    private static final HashSet<Integer> o;
    private static final HashSet<Integer> p;
    private static final HashSet<Integer> q;

    static {
        vx vxVarF = r1.d().f();
        a = vxVarF;
        int iNextInt = new Random(System.currentTimeMillis()).nextInt(10000);
        b = iNextInt;
        c = vxVarF.a("maxSingleSize", 1024);
        d = iNextInt < vxVarF.a("perfRate", 10000);
        e = iNextInt < vxVarF.a("eventRate", 10000);
        f = vxVarF.a("eventInstant", 0) == 1;
        g = vxVarF.a("maxCount", 30);
        h = vxVarF.a("perfInstant", 0) == 1;
        i = vxVarF.a("perfPeriod", 600);
        j = vxVarF.a("eventPeriod", 600);
        k = vxVarF.a("perfBatchCount", 30);
        l = vxVarF.a("eventBatchCount", 30);
        m = vxVarF.a("perfNetPer", 30);
        n = vxVarF.a("eventNetPer", 30);
        o = g();
        p = f();
        q = a("ntrpf");
    }

    static int c() {
        return g;
    }

    static int d() {
        return k;
    }

    static int e() {
        return i;
    }

    private static HashSet<Integer> f() {
        HashSet<Integer> hashSetA = a("ntrpe");
        hashSetA.addAll(a("sprpe"));
        return hashSetA;
    }

    private static HashSet<Integer> g() {
        return a("skrrd");
    }

    static boolean h() {
        return f;
    }

    static boolean i() {
        return (r1.d().c().p().d() & n) > 0;
    }

    static boolean j() {
        return h;
    }

    static boolean k() {
        return (r1.d().c().p().d() & m) > 0;
    }

    static boolean a(boolean z, int i2) {
        if (!z) {
            HashSet<Integer> hashSet = o;
            if (hashSet.size() <= 0 || !hashSet.contains(Integer.valueOf(i2))) {
                return false;
            }
        }
        return true;
    }

    static boolean b(int i2) {
        if (i2 != 0 && d) {
            HashSet<Integer> hashSet = q;
            if (hashSet.size() == 0 || !hashSet.contains(Integer.valueOf(i2))) {
                return true;
            }
        }
        return false;
    }

    static int b() {
        return j;
    }

    static boolean a(int i2) {
        if (i2 != 0 && e) {
            HashSet<Integer> hashSet = p;
            if (hashSet.size() == 0 || !hashSet.contains(Integer.valueOf(i2))) {
                return true;
            }
        }
        return false;
    }

    private static HashSet<Integer> a(String str) {
        String[] strArrSplit;
        HashSet<Integer> hashSet = new HashSet<>();
        String strC = r1.d().f().c(str);
        if (!TextUtils.isEmpty(strC) && (strArrSplit = strC.split(",")) != null && strArrSplit.length > 0) {
            try {
                for (String str2 : strArrSplit) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    static int a() {
        return l;
    }
}
