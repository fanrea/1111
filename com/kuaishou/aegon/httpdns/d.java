package com.kuaishou.aegon.httpdns;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class d implements Runnable {
    private final ResolveFinishedInfo a;

    private d(ResolveFinishedInfo resolveFinishedInfo) {
        this.a = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.a);
    }
}
