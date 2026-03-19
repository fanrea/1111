package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class b implements Runnable {
    private final a a;
    private final String b;

    private b(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    public static Runnable a(a aVar, String str) {
        return new b(aVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}
