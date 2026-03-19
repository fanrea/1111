package com.ss.android.socialbase.downloader.tc;

import com.ss.android.socialbase.downloader.e.an;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements hc {
    private final InputStream d;
    private final com.ss.android.socialbase.downloader.mk.d hc;

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public void d(com.ss.android.socialbase.downloader.mk.d dVar) {
    }

    public b(InputStream inputStream, int i) {
        this.d = inputStream;
        this.hc = new com.ss.android.socialbase.downloader.mk.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public com.ss.android.socialbase.downloader.mk.d d() throws IOException {
        com.ss.android.socialbase.downloader.mk.d dVar = this.hc;
        dVar.b = this.d.read(dVar.d);
        return this.hc;
    }

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public void hc() {
        an.d(this.d);
    }
}
