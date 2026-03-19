package com.android.gdt.qone.y;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements Runnable {
    public final /* synthetic */ HttpURLConnection a;

    public a(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.android.gdt.qone.z.a.a(((HttpsURLConnection) this.a).getServerCertificates());
        } catch (Exception unused) {
        }
    }
}
