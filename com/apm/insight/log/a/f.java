package com.apm.insight.log.a;

import java.io.File;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class f {
    private static a a;

    public static void a(a aVar) {
        a = aVar;
        a.a(aVar == null ? 0L : aVar.e());
    }

    public static void a() {
        a.a(0L);
        a.a();
        a = null;
    }

    private static void a(int i, String str, String str2) {
        a aVar = a;
        if (aVar != null) {
            aVar.a(i, str, str2);
        }
    }

    public static void a(int i, String str, String str2, long j, long j2) {
        a aVar = a;
        if (aVar != null) {
            aVar.a(i, str, str2, j, j2);
        }
    }

    public static void b() {
        a aVar = a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void a(int i) {
        a aVar = a;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static void b(String str, String str2) {
        a(1, str, str2);
    }

    public static void c(String str, String str2) {
        a(2, str, str2);
    }

    public static void d(String str, String str2) {
        a(3, str, str2);
    }

    public static void e(String str, String str2) {
        a(4, str, str2);
    }

    public static File[] a(String str, String str2, long j, long j2) {
        a aVar = a;
        return aVar != null ? aVar.a((String) null, (String) null, j, j2) : new File[0];
    }

    public static File[] a(boolean z, long j, long j2, int i) {
        a aVar = a;
        return aVar != null ? aVar.a(z, j, j2, i) : new File[0];
    }

    public static HashMap<String, String> c() {
        if (a != null) {
            return a.d();
        }
        return null;
    }
}
