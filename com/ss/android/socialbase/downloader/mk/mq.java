package com.ss.android.socialbase.downloader.mk;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class mq implements u {
    private final u b;
    private final tt d;
    private final com.ss.android.socialbase.downloader.h.h hc;

    public mq(com.ss.android.socialbase.downloader.h.b bVar, hc hcVar, tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        this.d = ttVar;
        this.hc = d(bVar, ttVar);
        this.b = new gb(hcVar, this);
    }

    public u d() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.mk.u
    public void hc(d dVar) throws IOException {
        this.hc.d(dVar.d, 0, dVar.b);
        this.d.hc(dVar.b);
    }

    public void hc() throws IOException {
        this.hc.hc();
    }

    public void b() throws IOException {
        this.hc.b();
    }

    public void c() {
        com.ss.android.socialbase.downloader.e.an.d(this.hc);
    }

    public tt u() {
        return this.d;
    }

    private com.ss.android.socialbase.downloader.h.h d(com.ss.android.socialbase.downloader.h.b bVar, tt ttVar) throws com.ss.android.socialbase.downloader.u.d, InterruptedException, IOException {
        com.ss.android.socialbase.downloader.h.h hVarD = com.ss.android.socialbase.downloader.e.an.d(bVar, bVar.mq(), bVar.uo(), com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("flush_buffer_size_byte", -1));
        try {
            hVarD.d(ttVar.u());
            return hVarD;
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.u.d(1054, e);
        }
    }
}
