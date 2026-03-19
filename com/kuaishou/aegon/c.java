package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class c implements Runnable {
    private final a a;
    private final AegonRequestFinishedInfo b;

    private c(a aVar, AegonRequestFinishedInfo aegonRequestFinishedInfo) {
        this.a = aVar;
        this.b = aegonRequestFinishedInfo;
    }

    public static Runnable a(a aVar, AegonRequestFinishedInfo aegonRequestFinishedInfo) {
        return new c(aVar, aegonRequestFinishedInfo);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}
