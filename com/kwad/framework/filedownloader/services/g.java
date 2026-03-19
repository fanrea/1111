package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class g implements y {
    private final h bgV = new h(com.kwad.framework.filedownloader.download.b.Ny().NB());

    g() {
    }

    private static com.kwad.framework.filedownloader.b.a ON() {
        return com.kwad.framework.filedownloader.download.b.Ny().NA();
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0177 A[Catch: all -> 0x01c0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x0070, B:23:0x0076, B:25:0x007a, B:29:0x008b, B:31:0x0094, B:33:0x009d, B:35:0x00a1, B:40:0x00b4, B:43:0x00bd, B:45:0x00c6, B:47:0x00d5, B:49:0x00d9, B:51:0x00ea, B:55:0x00f4, B:57:0x00fb, B:59:0x0102, B:61:0x0108, B:63:0x010f, B:65:0x0115, B:67:0x011b, B:69:0x0131, B:70:0x0135, B:72:0x013b, B:81:0x0177, B:82:0x017a, B:73:0x0148, B:75:0x0152, B:77:0x0158, B:78:0x015d, B:44:0x00c2, B:30:0x0090), top: B:88:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(java.lang.String r20, java.lang.String r21, boolean r22, int r23, int r24, int r25, boolean r26, com.kwad.framework.filedownloader.d.b r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwad.framework.filedownloader.d.b, boolean):void");
    }

    public final boolean E(String str, String str2) {
        return dK(com.kwad.framework.filedownloader.f.f.G(str, str2));
    }

    private boolean dK(int i) {
        return a(ON().dm(i));
    }

    public final boolean df(int i) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c cVarDm = ON().dm(i);
        if (cVarDm == null) {
            return false;
        }
        cVarDm.d((byte) -2);
        this.bgV.cancel(i);
        return true;
    }

    public final void OO() {
        List<Integer> listOR = this.bgV.OR();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(listOR.size()));
        }
        Iterator<Integer> it = listOR.iterator();
        while (it.hasNext()) {
            df(it.next().intValue());
        }
    }

    public final long dL(int i) {
        com.kwad.framework.filedownloader.b.a aVarON = ON();
        com.kwad.framework.filedownloader.d.c cVarDm = aVarON.dm(i);
        if (cVarDm == null) {
            return 0L;
        }
        int iOy = cVarDm.Oy();
        if (iOy <= 1) {
            return cVarDm.Ov();
        }
        List<com.kwad.framework.filedownloader.d.a> listDn = aVarON.dn(i);
        if (listDn == null || listDn.size() != iOy) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.Z(listDn);
    }

    public final long dB(int i) {
        com.kwad.framework.filedownloader.d.c cVarDm = ON().dm(i);
        if (cVarDm == null) {
            return 0L;
        }
        return cVarDm.getTotal();
    }

    public final byte dg(int i) {
        com.kwad.framework.filedownloader.d.c cVarDm = ON().dm(i);
        if (cVarDm == null) {
            return (byte) 0;
        }
        return cVarDm.Mg();
    }

    public final boolean isIdle() {
        return this.bgV.OQ() <= 0;
    }

    public final synchronized boolean dz(int i) {
        return this.bgV.dz(i);
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean zDM = this.bgV.dM(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.dH(cVar.Mg())) {
            if (!zDM) {
                return false;
            }
        } else if (!zDM) {
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.Mg()));
            return false;
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int p(String str, int i) {
        return this.bgV.p(str, i);
    }

    public final boolean dh(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (dK(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        com.kwad.framework.filedownloader.b.a aVarON = ON();
        aVarON.dp(i);
        aVarON.mo454do(i);
        return true;
    }

    public final void Of() {
        ON().clear();
    }
}
