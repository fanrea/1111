package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$14 implements Runnable {
    private final long arg$1;
    private final boolean arg$2;

    private Aegon$$Lambda$14(long j, boolean z) {
        this.arg$1 = j;
        this.arg$2 = z;
    }

    public static Runnable lambdaFactory$(long j, boolean z) {
        return new Aegon$$Lambda$14(j, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeSetLoggingCallback(this.arg$1, this.arg$2);
    }
}
