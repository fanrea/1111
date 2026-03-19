package com.sigmob.sdk.downloader.core.download;

import android.net.Uri;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    boolean a;
    boolean b;
    boolean c;
    private boolean d;
    private final com.sigmob.sdk.downloader.f e;
    private final com.sigmob.sdk.downloader.core.breakpoint.c f;
    private final long g;

    public a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info, long responseInstanceLength) {
        this.e = task;
        this.f = info;
        this.g = responseInstanceLength;
    }

    public boolean a() {
        return this.d;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        if (!this.b) {
            return com.sigmob.sdk.downloader.core.cause.b.INFO_DIRTY;
        }
        if (!this.a) {
            return com.sigmob.sdk.downloader.core.cause.b.FILE_NOT_EXIST;
        }
        if (this.c) {
            throw new IllegalStateException("No cause find with dirty: " + this.d);
        }
        return com.sigmob.sdk.downloader.core.cause.b.OUTPUT_STREAM_NOT_SUPPORT;
    }

    public boolean c() {
        int iG = this.f.g();
        if (iG <= 0 || this.f.b() || this.f.o() == null) {
            return false;
        }
        if (!this.f.o().equals(this.e.m()) || this.f.o().length() > this.f.j()) {
            return false;
        }
        if (this.g > 0 && this.f.j() != this.g) {
            return false;
        }
        for (int i = 0; i < iG; i++) {
            if (this.f.b(i).d() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return true;
        }
        return this.f.g() == 1 && !com.sigmob.sdk.downloader.g.j().f().b(this.e);
    }

    public boolean e() {
        Uri uriH = this.e.h();
        if (com.sigmob.sdk.downloader.core.c.a(uriH)) {
            return com.sigmob.sdk.downloader.core.c.c(uriH) > 0;
        }
        File fileM = this.e.m();
        return fileM != null && fileM.exists();
    }

    public void f() {
        this.a = e();
        this.b = c();
        boolean zD = d();
        this.c = zD;
        this.d = (this.b && this.a && zD) ? false : true;
    }

    public String toString() {
        return "fileExist[" + this.a + "] infoRight[" + this.b + "] outputStreamSupport[" + this.c + "] " + super.toString();
    }
}
