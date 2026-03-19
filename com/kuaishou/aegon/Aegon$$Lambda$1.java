package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$1 implements Runnable {
    private final String arg$1;
    private final String arg$2;

    private Aegon$$Lambda$1(String str, String str2) {
        this.arg$1 = str;
        this.arg$2 = str2;
    }

    public static Runnable lambdaFactory$(String str, String str2) {
        return new Aegon$$Lambda$1(str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeUpdateConfig(this.arg$1, this.arg$2);
    }
}
