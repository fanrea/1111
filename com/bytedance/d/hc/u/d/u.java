package com.bytedance.d.hc.u.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static volatile u d;
    private Map<com.bytedance.d.hc.b, b> b = new HashMap();
    private hc c;
    private Context hc;
    private c u;

    private u(Context context) {
        this.hc = context;
        this.c = new hc(this.hc);
        this.u = new c(this.hc);
    }

    public static u d() {
        if (d == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return d;
    }

    public static void d(Context context) {
        if (d == null) {
            d = new u(context);
        }
    }

    private b d(com.bytedance.d.hc.b bVar) {
        b hVar = this.b.get(bVar);
        if (hVar != null) {
            return hVar;
        }
        int i = AnonymousClass1.d[bVar.ordinal()];
        if (i == 1) {
            hVar = new h(this.hc, this.c, this.u);
        } else if (i == 2) {
            hVar = new d(this.hc, this.c, this.u);
        } else if (i == 3) {
            hVar = new an(this.hc, this.c, this.u);
        }
        if (hVar != null) {
            this.b.put(bVar, hVar);
        }
        return hVar;
    }

    /* renamed from: com.bytedance.d.hc.u.d.u$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[com.bytedance.d.hc.b.values().length];
            d = iArr;
            try {
                iArr[com.bytedance.d.hc.b.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[com.bytedance.d.hc.b.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[com.bytedance.d.hc.b.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public com.bytedance.d.hc.b.d d(com.bytedance.d.hc.b bVar, com.bytedance.d.hc.b.d dVar) {
        b bVarD;
        return (bVar == null || (bVarD = d(bVar)) == null) ? dVar : bVarD.d(dVar);
    }
}
