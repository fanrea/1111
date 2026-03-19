package com.qq.e.comm.plugin;

import java.lang.ref.SoftReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z0 {
    private static SoftReference<a> a;

    /* compiled from: A */
    public interface a {
        void a();
    }

    public static void a(a aVar) {
        a = new SoftReference<>(aVar);
    }

    public static void a() {
        SoftReference<a> softReference = a;
        if (softReference == null) {
            return;
        }
        a aVar = softReference.get();
        if (aVar != null) {
            aVar.a();
        }
        a = null;
    }
}
