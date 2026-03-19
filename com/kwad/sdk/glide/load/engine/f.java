package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class f<Transcode> {
    private com.kwad.sdk.glide.e bPB;
    private Class<Transcode> bQh;
    private Object bQj;
    private DecodeJob.d bSA;
    private Map<Class<?>, com.kwad.sdk.glide.load.i<?>> bSB;
    private boolean bSC;
    private boolean bSD;
    private Priority bSE;
    private h bSF;
    private boolean bSG;
    private boolean bSH;
    private com.kwad.sdk.glide.load.c bSv;
    private com.kwad.sdk.glide.load.f bSx;
    private Class<?> bSz;
    private int height;
    private int width;
    private final List<n.a<?>> bSy = new ArrayList();
    private final List<com.kwad.sdk.glide.load.c> bSm = new ArrayList();

    f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    final <R> void a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.kwad.sdk.glide.load.f fVar, Map<Class<?>, com.kwad.sdk.glide.load.i<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.bPB = eVar;
        this.bQj = obj;
        this.bSv = cVar;
        this.width = i;
        this.height = i2;
        this.bSF = hVar;
        this.bSz = cls;
        this.bSA = dVar;
        this.bQh = cls2;
        this.bSE = priority;
        this.bSx = fVar;
        this.bSB = map;
        this.bSG = z;
        this.bSH = z2;
    }

    final void clear() {
        this.bPB = null;
        this.bQj = null;
        this.bSv = null;
        this.bSz = null;
        this.bQh = null;
        this.bSx = null;
        this.bSE = null;
        this.bSB = null;
        this.bSF = null;
        this.bSy.clear();
        this.bSC = false;
        this.bSm.clear();
        this.bSD = false;
    }

    final com.kwad.sdk.glide.load.engine.a.a age() {
        return this.bSA.age();
    }

    final h agf() {
        return this.bSF;
    }

    final Priority agg() {
        return this.bSE;
    }

    final com.kwad.sdk.glide.load.f agh() {
        return this.bSx;
    }

    final com.kwad.sdk.glide.load.c agi() {
        return this.bSv;
    }

    final int getWidth() {
        return this.width;
    }

    final int getHeight() {
        return this.height;
    }

    final com.kwad.sdk.glide.load.engine.bitmap_recycle.b afa() {
        return this.bPB.afa();
    }

    final Class<?> agj() {
        return this.bQh;
    }

    final Class<?> agk() {
        return this.bQj.getClass();
    }

    final List<Class<?>> agl() {
        return this.bPB.afe().c(this.bQj.getClass(), this.bSz, this.bQh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean j(Class<?> cls) {
        return k(cls) != null;
    }

    final <Data> q<Data, ?, Transcode> k(Class<Data> cls) {
        return this.bPB.afe().a(cls, this.bSz, this.bQh);
    }

    final boolean agm() {
        return this.bSH;
    }

    final <Z> com.kwad.sdk.glide.load.i<Z> l(Class<Z> cls) {
        com.kwad.sdk.glide.load.i<Z> iVar = (com.kwad.sdk.glide.load.i) this.bSB.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, com.kwad.sdk.glide.load.i<?>>> it = this.bSB.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.kwad.sdk.glide.load.i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (com.kwad.sdk.glide.load.i) next.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (this.bSB.isEmpty() && this.bSG) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return com.kwad.sdk.glide.load.resource.b.ahJ();
    }

    final boolean a(s<?> sVar) {
        return this.bPB.afe().a(sVar);
    }

    final <Z> com.kwad.sdk.glide.load.h<Z> b(s<Z> sVar) {
        return this.bPB.afe().b(sVar);
    }

    final List<com.kwad.sdk.glide.load.c.n<File, ?>> P(File file) {
        return this.bPB.afe().t(file);
    }

    final boolean c(com.kwad.sdk.glide.load.c cVar) {
        List<n.a<?>> listAgn = agn();
        int size = listAgn.size();
        for (int i = 0; i < size; i++) {
            if (listAgn.get(i).bSq.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    final List<n.a<?>> agn() {
        if (!this.bSC) {
            this.bSC = true;
            this.bSy.clear();
            List listT = this.bPB.afe().t(this.bQj);
            int size = listT.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVarB = ((com.kwad.sdk.glide.load.c.n) listT.get(i)).b(this.bQj, this.width, this.height, this.bSx);
                if (aVarB != null) {
                    this.bSy.add(aVarB);
                }
            }
        }
        return this.bSy;
    }

    final List<com.kwad.sdk.glide.load.c> ago() {
        if (!this.bSD) {
            this.bSD = true;
            this.bSm.clear();
            List<n.a<?>> listAgn = agn();
            int size = listAgn.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVar = listAgn.get(i);
                if (!this.bSm.contains(aVar.bSq)) {
                    this.bSm.add(aVar.bSq);
                }
                for (int i2 = 0; i2 < aVar.bWB.size(); i2++) {
                    if (!this.bSm.contains(aVar.bWB.get(i2))) {
                        this.bSm.add(aVar.bWB.get(i2));
                    }
                }
            }
        }
        return this.bSm;
    }

    final <X> com.kwad.sdk.glide.load.a<X> r(X x) {
        return this.bPB.afe().r(x);
    }
}
