package com.ss.android.socialbase.downloader.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private int b;
    private int c = 10;
    private d d;
    private d hc;

    public boolean d(long j, long j2) {
        synchronized (this) {
            d dVar = this.d;
            if (dVar != null) {
                if (j >= dVar.d && j2 >= dVar.hc) {
                    d dVar2 = dVar.b;
                    if (dVar2 != null && j2 - dVar2.hc < 1000) {
                        dVar.d = j;
                        dVar.hc = j2;
                        return true;
                    }
                }
                return false;
            }
            d dVarD = d();
            dVarD.d = j;
            dVarD.hc = j2;
            if (dVar != null) {
                dVarD.b = dVar;
                dVar.c = dVarD;
            }
            this.d = dVarD;
            return true;
        }
    }

    public long hc(long j, long j2) {
        synchronized (this) {
            d dVar = this.d;
            if (dVar == null) {
                return -1L;
            }
            d dVarD = d(j);
            if (dVarD == null) {
                return -1L;
            }
            long j3 = dVar.d - dVarD.d;
            long j4 = j2 - dVarD.hc;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private d d() {
        d dVar;
        int i = this.b;
        if (i >= this.c && (dVar = this.hc) != null) {
            d dVar2 = dVar.c;
            dVar.c = null;
            this.hc = dVar2;
            if (dVar2 != null) {
                dVar2.b = null;
            }
            return dVar;
        }
        this.b = i + 1;
        return new d();
    }

    private d d(long j) {
        d dVar = this.d;
        d dVar2 = null;
        while (dVar != null && dVar.hc > j) {
            dVar2 = dVar;
            dVar = dVar.b;
        }
        return (dVar == null || dVar2 == null || dVar == dVar2 || j - dVar.hc >= dVar2.hc - j) ? dVar2 : dVar;
    }

    private static class d {
        d b;
        d c;
        long d;
        long hc;

        private d() {
        }
    }
}
