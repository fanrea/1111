package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class g implements Runnable {
    private final NetworkStateHelper a;

    private g(NetworkStateHelper networkStateHelper) {
        this.a = networkStateHelper;
    }

    public static Runnable a(NetworkStateHelper networkStateHelper) {
        return new g(networkStateHelper);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.nativeOnSignalStrengthChanged();
    }
}
