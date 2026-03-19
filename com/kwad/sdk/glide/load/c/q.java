package com.kwad.sdk.glide.load.c;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> bSr;
    private final Pools.Pool<List<Throwable>> bWH;

    q(List<n<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.bSr = list;
        this.bWH = pool;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final n.a<Data> b(Model model, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        n.a<Data> aVarB;
        int size = this.bSr.size();
        ArrayList arrayList = new ArrayList(size);
        com.kwad.sdk.glide.load.c cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n<Model, Data> nVar = this.bSr.get(i3);
            if (nVar.E(model) && (aVarB = nVar.b(model, i, i2, fVar)) != null) {
                cVar = aVarB.bSq;
                arrayList.add(aVarB.bWC);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.bWH));
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final boolean E(Model model) {
        Iterator<n<Model, Data>> it = this.bSr.iterator();
        while (it.hasNext()) {
            if (it.next().E(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.bSr.toArray()) + '}';
    }

    static class a<Data> implements com.kwad.sdk.glide.load.a.d<Data>, d.a<Data> {
        private final Pools.Pool<List<Throwable>> bQe;
        private boolean bRS;
        private Priority bSE;
        private final List<com.kwad.sdk.glide.load.a.d<Data>> bWI;
        private d.a<? super Data> bWJ;
        private List<Throwable> bWK;
        private int currentIndex;

        a(List<com.kwad.sdk.glide.load.a.d<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.bQe = pool;
            ax.d(list);
            this.bWI = list;
            this.currentIndex = 0;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super Data> aVar) {
            this.bSE = priority;
            this.bWJ = aVar;
            this.bWK = this.bQe.acquire();
            this.bWI.get(this.currentIndex).a(priority, this);
            if (this.bRS) {
                cancel();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
            List<Throwable> list = this.bWK;
            if (list != null) {
                this.bQe.release(list);
            }
            this.bWK = null;
            Iterator<com.kwad.sdk.glide.load.a.d<Data>> it = this.bWI.iterator();
            while (it.hasNext()) {
                it.next().afU();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
            this.bRS = true;
            Iterator<com.kwad.sdk.glide.load.a.d<Data>> it = this.bWI.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<Data> afT() {
            return this.bWI.get(0).afT();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return this.bWI.get(0).afV();
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public final void x(Data data) {
            if (data != null) {
                this.bWJ.x(data);
            } else {
                ahF();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public final void g(Exception exc) {
            ((List) ax.checkNotNull(this.bWK)).add(exc);
            ahF();
        }

        private void ahF() {
            if (this.bRS) {
                return;
            }
            if (this.currentIndex < this.bWI.size() - 1) {
                this.currentIndex++;
                a(this.bSE, this.bWJ);
            } else {
                ax.checkNotNull(this.bWK);
                this.bWJ.g(new GlideException("Fetch failed", new ArrayList(this.bWK)));
            }
        }
    }
}
