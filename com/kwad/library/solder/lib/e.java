package com.kwad.library.solder.lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c bhV;
    private final com.kwad.library.solder.lib.a.c bhX;
    private final com.kwad.library.solder.lib.a.f bhY;
    private final com.kwad.library.solder.lib.a.b bhZ;
    private final com.kwad.library.solder.lib.ext.a bia;
    private Map<String, b> bib;

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.bhX = cVar;
        this.bhY = fVar;
        this.bhZ = bVar;
        this.bhV = cVar2;
        this.bia = aVar;
    }

    public final com.kwad.library.solder.lib.a.e a(com.kwad.library.solder.lib.a.e eVar, a aVar) {
        if (eVar.Pv() == null) {
            eVar.a(this);
        }
        new StringBuilder("request pluginId:").append(eVar.Pz()).append(", state: ").append(eVar.Pw());
        aVar.j(eVar);
        return eVar;
    }

    public final b a(com.kwad.library.solder.lib.a.e eVar, int i) {
        return b(eVar, a.a(this, 16));
    }

    private b b(final com.kwad.library.solder.lib.a.e eVar, final a aVar) {
        b bVarCS = cS(eVar.Pz());
        if (bVarCS != null) {
            bVarCS.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.bhV.PS().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Pn, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.Pz(), bVar);
        return bVar;
    }

    public final void i(com.kwad.library.solder.lib.a.e eVar) {
        b bVarCS = cS(eVar.Pz());
        if (bVarCS != null) {
            bVarCS.cancel();
        }
        a(eVar.Pz(), (b) null);
    }

    private synchronized b cS(String str) {
        Map<String, b> mapG = g(this.bib);
        this.bib = mapG;
        if (str == null) {
            return null;
        }
        return mapG.get(str);
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> mapG = g(this.bib);
        this.bib = mapG;
        if (str != null) {
            mapG.put(str, bVar);
        }
    }

    private static Map<String, b> g(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c Pi() {
        return this.bhV;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c Pj() {
        return this.bhX;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f Pk() {
        return this.bhY;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b Pl() {
        return this.bhZ;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a Pm() {
        return this.bia;
    }

    public static abstract class a {
        final com.kwad.library.solder.lib.a.d bif;

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            if (i == 1) {
                return new b(dVar);
            }
            return new C0564a(dVar);
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.bif = dVar;
        }

        static class b extends a {
            b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.bif.Pk().k(eVar);
            }
        }

        /* renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        static class C0564a extends a {
            C0564a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.bif.Pj().g(eVar);
            }
        }
    }

    public static class b {
        private final com.kwad.library.solder.lib.a.e big;
        private final Future<com.kwad.library.solder.lib.a.e> bih;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.big = eVar;
            this.bih = future;
        }

        public final void cancel() {
            this.big.cancel();
            this.bih.cancel(true);
        }
    }
}
