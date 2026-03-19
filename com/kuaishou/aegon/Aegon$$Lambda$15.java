package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$15 implements Runnable {
    private final boolean arg$1;

    private Aegon$$Lambda$15(boolean z) {
        this.arg$1 = z;
    }

    public static Runnable lambdaFactory$(boolean z) {
        return new Aegon$$Lambda$15(z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeSetLoggingCallback(0L, this.arg$1);
    }
}
