package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.dc;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.ttm.utils.AVLogger;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class cb implements com.ss.android.socialbase.downloader.downloader.e {
    private final com.ss.android.socialbase.downloader.downloader.w b;
    private final boolean c;
    private final d d;
    private final com.ss.android.socialbase.downloader.downloader.mq hc;

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void startService() {
    }

    public cb() {
        this(false);
    }

    public cb(boolean z) {
        this.d = com.ss.android.socialbase.downloader.downloader.b.j();
        this.hc = com.ss.android.socialbase.downloader.downloader.b.np();
        if (!z) {
            this.b = com.ss.android.socialbase.downloader.downloader.b.yi();
        } else {
            this.b = com.ss.android.socialbase.downloader.downloader.b.he();
        }
        this.c = com.ss.android.socialbase.downloader.uo.d.b().hc("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.u(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean hc(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.k(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void b(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.an(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void c(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.h(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.hc();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.hc;
        if (mqVar != null) {
            return mqVar.hc(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> c() {
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.hc;
        if (mqVar != null) {
            return mqVar.hc();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(List<String> list) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(List<String> list) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.hc(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public long u(int i) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.hc;
        if (mqVar == null || (bVarHc = mqVar.hc(i)) == null) {
            return 0L;
        }
        int iFj = bVarHc.fj();
        if (iFj <= 1) {
            return bVarHc.js();
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = this.hc.b(i);
        if (listB == null || listB.size() != iFj) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.e.an.hc(listB);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int an(int i) {
        com.ss.android.socialbase.downloader.h.b bVarC;
        d dVar = this.d;
        if (dVar == null || (bVarC = dVar.c(i)) == null) {
            return 0;
        }
        return bVarC.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean h(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.d(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.c(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.hc> tt(int i) {
        return this.hc.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public com.ss.android.socialbase.downloader.h.b hc(String str, String str2) {
        return gb(com.ss.android.socialbase.downloader.downloader.b.d(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int d(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.b.d(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.hc;
        if (mqVar != null) {
            return mqVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.hc(i, z);
        }
    }

    public void c(int i, boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void tc(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.uo(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.hc(i, i2, vvVar, gbVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z, boolean z2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i, i2, vvVar, gbVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, int i2, vv vvVar, com.ss.android.socialbase.downloader.hc.gb gbVar, boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i, i2, vvVar, gbVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean zD = com.ss.android.socialbase.downloader.e.an.d(bVar.w(), bVar.mk(), bVar.gb());
        if (zD) {
            if (com.ss.android.socialbase.downloader.e.d.d(AVLogger.LEVEL_LOG_INFO)) {
                hc(bVar.h(), true);
            } else {
                c(bVar.h(), true);
            }
        }
        return zD;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.w wVar = this.b;
        if (wVar != null) {
            wVar.d(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.w wVar = this.b;
        if (wVar != null) {
            wVar.d(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean hc() {
        com.ss.android.socialbase.downloader.downloader.w wVar = this.b;
        if (wVar != null) {
            return wVar.hc();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean b() {
        return com.ss.android.socialbase.downloader.downloader.b.nv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        com.ss.android.socialbase.downloader.downloader.mq mqVar = this.hc;
        if (mqVar != null) {
            return mqVar.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public List<com.ss.android.socialbase.downloader.h.b> u(String str) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.hc(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.downloader.w wVar = this.b;
        if (wVar != null) {
            wVar.hc(cVar);
        } else if (cVar != null) {
            com.ss.android.socialbase.downloader.gb.d.d(cVar.u(), cVar.d(), new com.ss.android.socialbase.downloader.u.d(1003, "downloadServiceHandler is null"), cVar.d() != null ? cVar.d().w() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.downloader.w wVar = this.b;
        if (wVar != null) {
            wVar.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean mq(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.mk(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void mk(int i) {
        com.ss.android.socialbase.downloader.an.d.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean u() {
        return this.hc.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        this.hc.hc(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        this.hc.d(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void b(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.d().d(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public int uo(int i) {
        return com.ss.android.socialbase.downloader.downloader.c.d().d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        this.hc.d(hcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean b(com.ss.android.socialbase.downloader.h.b bVar) {
        return this.hc.d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean k(int i) {
        return this.hc.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void e(int i) {
        this.hc.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, long j) {
        this.hc.d(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, int i3, long j) {
        this.hc.d(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2, int i3, int i4) {
        this.hc.d(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean cb(int i) {
        return this.hc.an(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void an() {
        this.hc.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        this.hc.hc(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public boolean h() {
        com.ss.android.socialbase.downloader.downloader.w wVar;
        return this.c && (wVar = this.b) != null && wVar.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(dc dcVar) {
        com.ss.android.socialbase.downloader.downloader.b.d(dcVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.b.c() != null) {
            for (dc dcVar : com.ss.android.socialbase.downloader.downloader.b.c()) {
                if (dcVar != null) {
                    dcVar.d(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public s w(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.tt(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public ba yo(int i) {
        d dVar = this.d;
        ba baVarGb = dVar != null ? dVar.gb(i) : null;
        return baVarGb == null ? com.ss.android.socialbase.downloader.downloader.b.r() : baVarGb;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, s sVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i, sVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public sy rf(int i) {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.tc(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.e
    public void d(int i, long j) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.hc(i, j);
        }
    }
}
