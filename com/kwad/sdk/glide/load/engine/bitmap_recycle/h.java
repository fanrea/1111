package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class h<K extends m, V> {
    private final a<K, V> bUC = new a<>();
    private final Map<K, a<K, V>> bUD = new HashMap();

    h() {
    }

    public final void a(K k, V v) {
        a<K, V> aVar = this.bUD.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.bUD.put(k, aVar);
        } else {
            k.agT();
        }
        aVar.add(v);
    }

    public final V b(K k) {
        a<K, V> aVar = this.bUD.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.bUD.put(k, aVar);
        } else {
            k.agT();
        }
        a(aVar);
        return aVar.removeLast();
    }

    public final V removeLast() {
        for (a aVar = this.bUC.bUH; !aVar.equals(this.bUC); aVar = aVar.bUH) {
            V v = (V) aVar.removeLast();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.bUD.remove(aVar.bUE);
            ((m) aVar.bUE).agT();
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.bUC.bUG; !aVar.equals(this.bUC); aVar = aVar.bUG) {
            z = true;
            sb.append('{').append(aVar.bUE).append(':').append(aVar.size()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.bUH = this.bUC;
        aVar.bUG = this.bUC.bUG;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.bUH = this.bUC.bUH;
        aVar.bUG = this.bUC;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.bUG.bUH = aVar;
        aVar.bUH.bUG = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.bUH.bUG = aVar.bUG;
        aVar.bUG.bUH = aVar.bUH;
    }

    static class a<K, V> {
        final K bUE;
        private List<V> bUF;
        a<K, V> bUG;
        a<K, V> bUH;

        a() {
            this(null);
        }

        a(K k) {
            this.bUH = this;
            this.bUG = this;
            this.bUE = k;
        }

        public final V removeLast() {
            int size = size();
            if (size > 0) {
                return this.bUF.remove(size - 1);
            }
            return null;
        }

        public final int size() {
            List<V> list = this.bUF;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final void add(V v) {
            if (this.bUF == null) {
                this.bUF = new ArrayList();
            }
            this.bUF.add(v);
        }
    }
}
