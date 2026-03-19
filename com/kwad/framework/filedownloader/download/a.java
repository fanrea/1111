package com.kwad.framework.filedownloader.download;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    final long beN;
    final long beO;
    final long beP;
    final long contentLength;

    a(long j, long j2, long j3, long j4) {
        this.beN = j;
        this.beO = j2;
        this.beP = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("range[%d, %d) current offset[%d]", Long.valueOf(this.beN), Long.valueOf(this.beP), Long.valueOf(this.beO));
    }
}
