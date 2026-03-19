package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$18 implements Runnable {
    private final String arg$1;
    private final int arg$2;
    private final int arg$3;

    private Aegon$$Lambda$18(String str, int i, int i2) {
        this.arg$1 = str;
        this.arg$2 = i;
        this.arg$3 = i2;
    }

    public static Runnable lambdaFactory$(String str, int i, int i2) {
        return new Aegon$$Lambda$18(str, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeSetKProxyConfig(this.arg$1, this.arg$2, this.arg$3);
    }
}
