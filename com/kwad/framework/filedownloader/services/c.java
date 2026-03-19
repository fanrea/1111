package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final b bgK;

    public interface a {
        c.b NE();
    }

    public c() {
        this.bgK = null;
    }

    public c(b bVar) {
        this.bgK = bVar;
    }

    public final int NB() {
        b bVar = this.bgK;
        if (bVar == null) {
            return OH();
        }
        Integer num = bVar.bgM;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.dN(num.intValue());
        }
        return OH();
    }

    public final com.kwad.framework.filedownloader.b.a OB() {
        b bVar = this.bgK;
        if (bVar == null || bVar.bgL == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a aVarOW = this.bgK.bgL.OW();
        return aVarOW != null ? aVarOW : new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e OC() {
        b bVar = this.bgK;
        if (bVar == null) {
            return OI();
        }
        c.e eVar = bVar.bgN;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return OI();
    }

    public final c.b OD() {
        c.b bVarNE;
        b bVar = this.bgK;
        if (bVar == null) {
            return OJ();
        }
        a aVar = bVar.bgP;
        return (aVar == null || (bVarNE = aVar.NE()) == null) ? OJ() : bVarNE;
    }

    public final c.a OE() {
        b bVar = this.bgK;
        if (bVar == null) {
            return OK();
        }
        c.a aVar = bVar.bgQ;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return OK();
    }

    public final c.d OF() {
        b bVar = this.bgK;
        if (bVar == null) {
            return OG();
        }
        c.d dVar = bVar.bgR;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return OG();
    }

    private static c.d OG() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int OH() {
        return com.kwad.framework.filedownloader.f.e.OX().bho;
    }

    private static c.e OI() {
        return new b.a();
    }

    private static c.b OJ() {
        return new c.b();
    }

    private static c.a OK() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public static class b {
        c.InterfaceC0557c bgL;
        Integer bgM;
        c.e bgN;
        c.b bgO;
        a bgP;
        c.a bgQ;
        c.d bgR;

        public final b dJ(int i) {
            this.bgM = Integer.MAX_VALUE;
            return this;
        }

        public final b a(c.b bVar) {
            this.bgO = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.bgP = aVar;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.c("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.bgL, this.bgM, this.bgN, this.bgO, this.bgQ);
        }
    }
}
