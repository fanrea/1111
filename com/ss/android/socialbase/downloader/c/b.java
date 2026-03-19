package com.ss.android.socialbase.downloader.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b implements vv {
    private static final String d = "b";

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onPrepare -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onStart -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void b(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null || bVar.mb() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, String.format("onProgress %s %.2f%%", bVar.gb(), Float.valueOf((bVar.js() / bVar.mb()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void c(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onPause -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void u(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onSuccessed -- " + bVar.gb() + " " + bVar.kb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        String str = d;
        Object[] objArr = new Object[2];
        objArr[0] = bVar.gb();
        objArr[1] = dVar != null ? dVar.hc() : "unkown";
        com.ss.android.socialbase.downloader.an.d.hc(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void an(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onCanceled -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void gb(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onFirstStart -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void tt(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onFirstSuccess -- " + bVar.gb());
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void hc(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        String str = d;
        Object[] objArr = new Object[2];
        objArr[0] = bVar.gb();
        objArr[1] = dVar != null ? dVar.hc() : "unkown";
        com.ss.android.socialbase.downloader.an.d.hc(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.c.vv
    public void b(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        String str = d;
        Object[] objArr = new Object[2];
        objArr[0] = bVar.gb();
        objArr[1] = dVar != null ? dVar.hc() : "unkown";
        com.ss.android.socialbase.downloader.an.d.hc(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    public void tc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!com.ss.android.socialbase.downloader.an.d.d() || bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, " onIntercept -- " + bVar.gb());
    }
}
