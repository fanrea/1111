package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class b implements d.a<Object>, e {
    private final List<com.kwad.sdk.glide.load.c> bSm;
    private final f<?> bSn;
    private final e.a bSo;
    private int bSp;
    private com.kwad.sdk.glide.load.c bSq;
    private List<com.kwad.sdk.glide.load.c.n<File, ?>> bSr;
    private int bSs;
    private volatile n.a<?> bSt;
    private File bSu;

    b(f<?> fVar, e.a aVar) {
        this(fVar.ago(), fVar, aVar);
    }

    b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        this.bSp = -1;
        this.bSm = list;
        this.bSn = fVar;
        this.bSo = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public final boolean agb() {
        while (true) {
            boolean z = false;
            if (this.bSr == null || !agc()) {
                int i = this.bSp + 1;
                this.bSp = i;
                if (i >= this.bSm.size()) {
                    return false;
                }
                com.kwad.sdk.glide.load.c cVar = this.bSm.get(this.bSp);
                File fileE = this.bSn.age().e(new c(cVar, this.bSn.agi()));
                this.bSu = fileE;
                if (fileE != null) {
                    this.bSq = cVar;
                    this.bSr = this.bSn.P(fileE);
                    this.bSs = 0;
                }
            } else {
                this.bSt = null;
                while (!z && agc()) {
                    List<com.kwad.sdk.glide.load.c.n<File, ?>> list = this.bSr;
                    int i2 = this.bSs;
                    this.bSs = i2 + 1;
                    this.bSt = list.get(i2).b(this.bSu, this.bSn.getWidth(), this.bSn.getHeight(), this.bSn.agh());
                    if (this.bSt != null && this.bSn.j(this.bSt.bWC.afT())) {
                        this.bSt.bWC.a(this.bSn.agg(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean agc() {
        return this.bSs < this.bSr.size();
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public final void cancel() {
        n.a<?> aVar = this.bSt;
        if (aVar != null) {
            aVar.bWC.cancel();
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public final void x(Object obj) {
        this.bSo.a(this.bSq, obj, this.bSt.bWC, DataSource.DATA_DISK_CACHE, this.bSq);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public final void g(Exception exc) {
        this.bSo.a(this.bSq, exc, this.bSt.bWC, DataSource.DATA_DISK_CACHE);
    }
}
