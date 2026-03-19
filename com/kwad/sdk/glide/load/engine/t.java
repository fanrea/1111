package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class t implements d.a<Object>, e {
    private final f<?> bSn;
    private final e.a bSo;
    private int bSp;
    private com.kwad.sdk.glide.load.c bSq;
    private List<com.kwad.sdk.glide.load.c.n<File, ?>> bSr;
    private int bSs;
    private volatile n.a<?> bSt;
    private File bSu;
    private int bUn = -1;
    private u bUo;

    t(f<?> fVar, e.a aVar) {
        this.bSn = fVar;
        this.bSo = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public final boolean agb() {
        List<com.kwad.sdk.glide.load.c> listAgo = this.bSn.ago();
        boolean z = false;
        if (listAgo.isEmpty()) {
            return false;
        }
        List<Class<?>> listAgl = this.bSn.agl();
        if (listAgl.isEmpty()) {
            if (File.class.equals(this.bSn.agj())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.bSn.agk() + " to " + this.bSn.agj());
        }
        while (true) {
            if (this.bSr == null || !agc()) {
                int i = this.bUn + 1;
                this.bUn = i;
                if (i >= listAgl.size()) {
                    int i2 = this.bSp + 1;
                    this.bSp = i2;
                    if (i2 >= listAgo.size()) {
                        return false;
                    }
                    this.bUn = 0;
                }
                com.kwad.sdk.glide.load.c cVar = listAgo.get(this.bSp);
                Class<?> cls = listAgl.get(this.bUn);
                this.bUo = new u(this.bSn.afa(), cVar, this.bSn.agi(), this.bSn.getWidth(), this.bSn.getHeight(), this.bSn.l(cls), cls, this.bSn.agh());
                File fileE = this.bSn.age().e(this.bUo);
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
                    int i3 = this.bSs;
                    this.bSs = i3 + 1;
                    this.bSt = list.get(i3).b(this.bSu, this.bSn.getWidth(), this.bSn.getHeight(), this.bSn.agh());
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
        this.bSo.a(this.bSq, obj, this.bSt.bWC, DataSource.RESOURCE_DISK_CACHE, this.bUo);
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public final void g(Exception exc) {
        this.bSo.a(this.bUo, exc, this.bSt.bWC, DataSource.RESOURCE_DISK_CACHE);
    }
}
