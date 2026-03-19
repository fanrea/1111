package com.ss.android.socialbase.downloader.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends d {
    private final long d;
    private final long hc;

    public u(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.d = j;
        this.hc = j2;
    }

    public long c() {
        return this.d;
    }

    public long u() {
        return this.hc;
    }
}
