package com.ss.android.socialbase.downloader.h;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    public final int b;
    private long c;
    public final String d;
    public final com.ss.android.socialbase.downloader.tt.h hc;
    private long u;

    public an(String str, com.ss.android.socialbase.downloader.tt.h hVar) throws IOException {
        this.d = str;
        this.b = hVar.hc();
        this.hc = hVar;
    }

    public boolean d() {
        return com.ss.android.socialbase.downloader.e.an.b(this.b);
    }

    public boolean hc() {
        return com.ss.android.socialbase.downloader.e.an.d(this.b, this.hc.d("Accept-Ranges"));
    }

    public String b() {
        return this.hc.d("Etag");
    }

    public String c() {
        return this.hc.d("Content-Type");
    }

    public String u() {
        return com.ss.android.socialbase.downloader.e.an.hc(this.hc, "Content-Range");
    }

    public String an() {
        String strHc = com.ss.android.socialbase.downloader.e.an.hc(this.hc, "last-modified");
        return TextUtils.isEmpty(strHc) ? com.ss.android.socialbase.downloader.e.an.hc(this.hc, "Last-Modified") : strHc;
    }

    public String h() {
        return com.ss.android.socialbase.downloader.e.an.hc(this.hc, "Cache-Control");
    }

    public long gb() {
        if (this.c <= 0) {
            this.c = com.ss.android.socialbase.downloader.e.an.d(this.hc);
        }
        return this.c;
    }

    public boolean tt() {
        if (com.ss.android.socialbase.downloader.e.d.d(8)) {
            return com.ss.android.socialbase.downloader.e.an.b(this.hc);
        }
        return com.ss.android.socialbase.downloader.e.an.hc(gb());
    }

    public long tc() {
        if (this.u <= 0) {
            if (!tt()) {
                String strU = u();
                if (!TextUtils.isEmpty(strU)) {
                    this.u = com.ss.android.socialbase.downloader.e.an.hc(strU);
                }
            } else {
                this.u = -1L;
            }
        }
        return this.u;
    }

    public long mk() {
        return com.ss.android.socialbase.downloader.e.an.tt(h());
    }
}
