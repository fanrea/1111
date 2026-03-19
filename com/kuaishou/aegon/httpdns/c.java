package com.kuaishou.aegon.httpdns;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class c implements Runnable {
    private final String a;

    private c(String str) {
        this.a = str;
    }

    public static Runnable a(String str) {
        return new c(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpDnsResolver.nativeSetJsonConfig(this.a);
    }
}
