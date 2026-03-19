package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import com.ss.android.socialbase.downloader.c.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc extends u {
    private String an;
    private String b;
    private String c;
    private Context d;
    private com.ss.android.socialbase.downloader.notification.d h;
    private int hc;
    private String u;

    public hc(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.d = context.getApplicationContext();
        } else {
            this.d = com.ss.android.socialbase.downloader.downloader.b.tr();
        }
        this.hc = i;
        this.b = str;
        this.c = str2;
        this.u = str3;
        this.an = str4;
    }

    public hc(com.ss.android.socialbase.downloader.notification.d dVar) {
        this.d = com.ss.android.socialbase.downloader.downloader.b.tr();
        this.h = dVar;
    }

    @Override // com.ss.android.socialbase.downloader.c.u
    public com.ss.android.socialbase.downloader.notification.d d() {
        com.ss.android.socialbase.downloader.notification.d dVar = this.h;
        return (dVar != null || this.d == null) ? dVar : new d(this.d, this.hc, this.b, this.c, this.u, this.an);
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || bVar.p()) {
            return;
        }
        super.d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || bVar.p()) {
            return;
        }
        super.hc(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void c(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || bVar.p()) {
            return;
        }
        super.c(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void b(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || bVar.p()) {
            return;
        }
        super.b(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void u(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || this.d == null) {
            return;
        }
        if (bVar.tj() && (!bVar.p() || !bVar.hr())) {
            super.u(bVar);
        }
        if (bVar.hr()) {
            com.ss.android.socialbase.appdownloader.an.hc.d(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.u, com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        if (bVar == null || this.d == null || !bVar.tj() || bVar.p()) {
            return;
        }
        super.d(bVar, dVar);
    }
}
