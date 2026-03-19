package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.d.d.hc.w;
import com.ss.android.d.d.hc.yi;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tc {
    private static volatile tc d;
    private long an;
    private final gb b;
    private final com.ss.android.hc.d.d c;
    private final com.ss.android.d.d.d hc;
    private com.ss.android.hc.d.hc u;

    public static tc d(final Context context) {
        if (d == null) {
            synchronized (tc.class) {
                if (d == null) {
                    com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tc unused = tc.d = new tc(context);
                        }
                    });
                }
            }
        }
        return d;
    }

    private tc(Context context) {
        this.b = gb.d();
        this.hc = new an();
        this.an = System.currentTimeMillis();
        hc(context);
        this.c = d.d();
    }

    private void hc(Context context) {
        mq.d(context);
        com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext());
        com.ss.android.downloadlib.addownload.hc.an.d().hc();
        com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), "misc_config", new com.ss.android.downloadlib.b.h(), new com.ss.android.downloadlib.b.an(context), new b());
        com.ss.android.downloadlib.b.c cVar = new com.ss.android.downloadlib.b.c();
        com.ss.android.socialbase.appdownloader.c.mk().d(cVar);
        com.ss.android.socialbase.downloader.downloader.h.hc(context).d(cVar);
        com.ss.android.socialbase.appdownloader.c.mk().d(new k());
        com.ss.android.socialbase.downloader.downloader.b.d(new com.ss.android.downloadlib.b.u());
        com.ss.android.socialbase.appdownloader.c.mk().d(com.ss.android.downloadlib.an.b.d());
    }

    public com.ss.android.d.d.d d() {
        return this.hc;
    }

    public com.ss.android.d.d.d d(String str) {
        com.ss.android.d.d.hc.an anVarHc = h.d().hc();
        if (anVarHc != null && anVarHc.d(str)) {
            return anVarHc.hc(str);
        }
        return this.hc;
    }

    public long hc() {
        return this.an;
    }

    public void b() {
        this.an = System.currentTimeMillis();
    }

    public com.ss.android.hc.d.d c() {
        return this.c;
    }

    public com.ss.android.hc.d.hc u() {
        if (this.u == null) {
            this.u = hc.d();
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gb gb() {
        return this.b;
    }

    public void d(final Context context, final int i, final com.ss.android.d.d.b.c cVar, final com.ss.android.d.d.b.b bVar) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.4
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(context, i, cVar, bVar);
            }
        });
    }

    public void d(final String str, final long j, final int i, final com.ss.android.d.d.b.hc hcVar, final com.ss.android.d.d.b.d dVar, final yi yiVar, final w wVar) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.5
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(str, j, i, hcVar, dVar, yiVar, wVar);
            }
        });
    }

    public void d(final String str, final long j, final int i, final com.ss.android.d.d.b.hc hcVar, final com.ss.android.d.d.b.d dVar) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.6
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(str, j, i, hcVar, dVar);
            }
        });
    }

    public void d(final String str, final long j, final int i, final com.ss.android.d.d.b.hc hcVar, final com.ss.android.d.d.b.d dVar, final w wVar) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.7
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(str, j, i, hcVar, dVar, wVar);
            }
        });
    }

    public void d(final String str, final int i) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.2
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(str, i);
            }
        });
    }

    public void d(final String str, final boolean z) {
        com.ss.android.downloadlib.u.hc.d(new Runnable() { // from class: com.ss.android.downloadlib.tc.3
            @Override // java.lang.Runnable
            public void run() {
                tc.this.gb().d(str, z);
            }
        });
    }

    public void d(com.ss.android.d.d.b.d.d dVar) {
        gb().d(dVar);
    }

    public String an() {
        return mq.k();
    }

    public void h() {
        u.d().an();
    }

    public com.ss.android.socialbase.downloader.h.b hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), str);
    }

    public com.ss.android.socialbase.downloader.h.b d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return hc(str);
        }
        return com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).hc(str, str2);
    }
}
