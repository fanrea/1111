package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c beQ;
    private c.a beR;
    private c.b beS;
    private c.e beT;
    private volatile com.kwad.framework.filedownloader.b.a beU;
    private c.d beV;

    static final class a {
        private static final b beW = new b();
    }

    public static b Ny() {
        return a.beW;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.beQ = new com.kwad.framework.filedownloader.services.c(bVar);
            this.beS = null;
            this.beT = null;
            this.beU = null;
            this.beV = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.beQ = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b ct(String str) {
        try {
            return NE().cq(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.beS = bVar;
            return bVar.cq(str);
        }
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return NF().c(file);
    }

    public final c.d Nz() {
        c.d dVar = this.beV;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.beV == null) {
                this.beV = NG().OF();
            }
        }
        return this.beV;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a NA() {
        if (this.beU != null) {
            return this.beU;
        }
        this.beU = NG().OB();
        a(this.beU.Np());
        return this.beU;
    }

    public final int NB() {
        return NG().NB();
    }

    public final boolean NC() {
        NF();
        return true;
    }

    public final int a(int i, String str, String str2, long j) {
        return ND().at(j);
    }

    private c.a ND() {
        c.a aVar = this.beR;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.beR == null) {
                this.beR = NG().OE();
            }
        }
        return this.beR;
    }

    private c.b NE() {
        c.b bVar = this.beS;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.beS == null) {
                this.beS = NG().OD();
            }
        }
        return this.beS;
    }

    private c.e NF() {
        c.e eVar = this.beT;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.beT == null) {
                this.beT = NG().OC();
            }
        }
        return this.beT;
    }

    private com.kwad.framework.filedownloader.services.c NG() {
        com.kwad.framework.filedownloader.services.c cVar = this.beQ;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.beQ == null) {
                this.beQ = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.beQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01a2  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0552a r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
