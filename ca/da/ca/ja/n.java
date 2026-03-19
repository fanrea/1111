package ca.da.ca.ja;

import android.content.Context;

/* compiled from: PrivateAgreement.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class n implements Runnable {
    public final /* synthetic */ Context a;

    public n(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.b.b(this.a).edit().putBoolean("_install_started_v2", true).apply();
    }
}
