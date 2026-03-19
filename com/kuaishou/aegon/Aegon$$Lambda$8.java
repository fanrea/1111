package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class Aegon$$Lambda$8 implements Runnable {
    private static final Aegon$$Lambda$8 instance = new Aegon$$Lambda$8();

    private Aegon$$Lambda$8() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Aegon.nativeClearHttpCache();
    }
}
