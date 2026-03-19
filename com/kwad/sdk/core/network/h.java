package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private static volatile h bCO;
    private List<a> bCN = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i);
    }

    public static h aap() {
        if (bCO == null) {
            synchronized (h.class) {
                if (bCO == null) {
                    bCO = new h();
                }
            }
        }
        return bCO;
    }

    private h() {
    }

    public final void a(a aVar) {
        this.bCN.add(aVar);
    }

    final void b(f fVar, int i) {
        Iterator<a> it = this.bCN.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
