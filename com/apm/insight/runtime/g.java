package com.apm.insight.runtime;

import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.r;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    private static final Comparator<a> a = new Comparator<a>() { // from class: com.apm.insight.runtime.g.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(a aVar, a aVar2) {
            int i = aVar.b + aVar.c;
            int i2 = aVar2.b + aVar2.c;
            if (i != i2) {
                return i > i2 ? -1 : 1;
            }
            return 0;
        }
    };
    private static byte[] b = new byte[4096];

    public static class a {
        public String a = "unknown";
        public int b;
        public int c;

        a() {
        }
    }

    public static long a(int i) {
        return NativeImpl.c(i) * r.a.a();
    }
}
