package com.tachikoma.lottie.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private static final f KV = new f();
    private final android.support.v4.d.f<String, com.tachikoma.lottie.e> KW = new android.support.v4.d.f<>(20);

    public static f kA() {
        return KV;
    }

    f() {
    }

    public final com.tachikoma.lottie.e af(String str) {
        if (str == null) {
            return null;
        }
        return this.KW.get(str);
    }

    public final void a(String str, com.tachikoma.lottie.e eVar) {
        if (str == null) {
            return;
        }
        this.KW.put(str, eVar);
    }
}
