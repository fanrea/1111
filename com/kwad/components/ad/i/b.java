package com.kwad.components.ad.i;

import com.kwad.components.core.proxy.f;
import com.kwad.components.core.proxy.l;
import com.kwad.components.core.proxy.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.core.internal.api.b {
    private static final Object sq = new Object();
    private static volatile b sr;
    private Set<Integer> ss = new HashSet();
    private List<c> st = new ArrayList();
    private Map<com.kwad.components.core.internal.api.a, Object> su = new WeakHashMap();
    private Map<f, Object> sv = new WeakHashMap();
    private m sw = new m() { // from class: com.kwad.components.ad.i.b.1
        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(f fVar) {
            super.d(fVar);
            b.this.sv.put(fVar, b.sq);
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(f fVar) {
            super.c(fVar);
            b.this.sv.remove(fVar);
            if (b.this.sv.isEmpty()) {
                b.this.fX();
            }
        }
    };

    public static b fW() {
        if (sr == null) {
            synchronized (b.class) {
                if (sr == null) {
                    sr = new b();
                }
            }
        }
        return sr;
    }

    private b() {
        l.sj().a(this.sw);
        this.ss.add(2);
        this.ss.add(3);
        this.ss.add(13);
        this.ss.add(6);
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.st.remove(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fX() {
        boolean zFY = fY();
        com.kwad.sdk.core.d.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + zFY);
        if (zFY) {
            Iterator<c> it = this.st.iterator();
            while (it.hasNext()) {
                it.next().gc();
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.su.put(aVar, sq);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.ga();
            this.st.add(cVar);
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.su.remove(aVar);
        Iterator<c> it = this.st.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        if (K(aVar.getAdTemplate())) {
            fX();
        }
    }

    public final synchronized boolean fY() {
        Iterator<com.kwad.components.core.internal.api.a> it = this.su.keySet().iterator();
        while (it.hasNext()) {
            if (K(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.sv.isEmpty();
    }

    private boolean K(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.ss.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (aVar.supportPushAd()) {
            return com.kwad.sdk.core.response.b.a.m456do(com.kwad.sdk.core.response.b.e.eP(aVar.getAdTemplate()));
        }
        return false;
    }
}
