package com.ss.android.socialbase.downloader.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class u extends b implements jh {
    protected abstract com.ss.android.socialbase.downloader.notification.d d();

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        super.d(bVar);
        mk(bVar);
        d(1, bVar, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        super.hc(bVar);
        d(2, bVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void b(com.ss.android.socialbase.downloader.h.b bVar) {
        super.b(bVar);
        mq(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void c(com.ss.android.socialbase.downloader.h.b bVar) {
        super.c(bVar);
        d(-2, bVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void u(com.ss.android.socialbase.downloader.h.b bVar) {
        super.u(bVar);
        d(-3, bVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
    public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        super.d(bVar, dVar);
        d(-1, bVar, dVar, false);
    }

    private void mk(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || !bVar.tj()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
        if (dVarU == null) {
            com.ss.android.socialbase.downloader.notification.hc.d().d(d());
        } else {
            dVarU.d(bVar);
        }
    }

    private void d(int i, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        if (bVar == null || !bVar.tj() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
        if (dVarU == null) {
            dVarU = d();
        }
        dVarU.hc(bVar.mb());
        if (i == -3) {
            dVarU.d(bVar.mb());
        } else {
            dVarU.d(bVar.js());
        }
        dVarU.d(i, dVar, z);
    }

    private void mq(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar != null && bVar.tj() && bVar.w() == 4) {
            com.ss.android.socialbase.downloader.notification.d dVarU = com.ss.android.socialbase.downloader.notification.hc.d().u(bVar.h());
            if (dVarU == null) {
                dVarU = d();
            }
            dVarU.d(bVar.js(), bVar.mb());
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.jh
    public void h(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || bVar.p()) {
            return;
        }
        d(11, bVar, null, true);
    }
}
