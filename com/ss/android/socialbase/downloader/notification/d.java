package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.h.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d {
    private int an = 0;
    private long b;
    private long c;
    protected Notification d;
    private int gb;
    private long h;
    private int hc;
    private boolean tt;
    private String u;

    public abstract void d(com.ss.android.socialbase.downloader.u.d dVar, boolean z);

    public d(int i, String str) {
        this.hc = i;
        this.u = str;
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.hc = bVar.h();
        this.u = bVar.tt();
    }

    public int d() {
        return this.hc;
    }

    public long hc() {
        return this.b;
    }

    public void d(long j) {
        this.b = j;
    }

    public long b() {
        return this.c;
    }

    public void hc(long j) {
        this.c = j;
    }

    public String c() {
        return this.u;
    }

    public int u() {
        return this.an;
    }

    public void d(int i, com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        d(i, dVar, z, false);
    }

    public void d(int i, com.ss.android.socialbase.downloader.u.d dVar, boolean z, boolean z2) {
        if (z2 || this.an != i) {
            this.an = i;
            d(dVar, z);
        }
    }

    public long an() {
        if (this.h == 0) {
            this.h = System.currentTimeMillis();
        }
        return this.h;
    }

    public void d(long j, long j2) {
        this.b = j;
        this.c = j2;
        this.an = 4;
        d((com.ss.android.socialbase.downloader.u.d) null, false);
    }

    public void d(Notification notification) {
        if (this.hc == 0 || notification == null) {
            return;
        }
        hc.d().d(this.hc, this.an, notification);
    }

    public synchronized void h() {
        this.gb++;
    }

    public boolean gb() {
        return this.tt;
    }
}
