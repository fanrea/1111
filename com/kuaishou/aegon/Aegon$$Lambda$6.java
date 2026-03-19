package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$6 implements Runnable {
    private final String arg$1;
    private final String[] arg$2;
    private final String[] arg$3;
    private final boolean arg$4;

    private Aegon$$Lambda$6(String str, String[] strArr, String[] strArr2, boolean z) {
        this.arg$1 = str;
        this.arg$2 = strArr;
        this.arg$3 = strArr2;
        this.arg$4 = z;
    }

    public static Runnable lambdaFactory$(String str, String[] strArr, String[] strArr2, boolean z) {
        return new Aegon$$Lambda$6(str, strArr, strArr2, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeSetPreconnectUrlsByIps(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}
