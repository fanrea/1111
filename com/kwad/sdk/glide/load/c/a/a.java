package com.kwad.sdk.glide.load.c.a;

import com.kwad.sdk.glide.load.a.j;
import com.kwad.sdk.glide.load.c.g;
import com.kwad.sdk.glide.load.c.m;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.r;
import com.kwad.sdk.glide.load.f;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements n<g, InputStream> {
    public static final com.kwad.sdk.glide.load.e<Integer> bWZ = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final m<g, g> bXa;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(g gVar) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(g gVar, int i, int i2, f fVar) {
        return a(gVar, fVar);
    }

    public a() {
        this(null);
    }

    public a(m<g, g> mVar) {
        this.bXa = mVar;
    }

    private n.a<InputStream> a(g gVar, f fVar) {
        m<g, g> mVar = this.bXa;
        if (mVar != null) {
            g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.bXa.a(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.a(bWZ)).intValue()));
    }

    /* renamed from: com.kwad.sdk.glide.load.c.a.a$a, reason: collision with other inner class name */
    public static class C0605a implements o<g, InputStream> {
        private final m<g, g> bXa = new m<>(500);

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<g, InputStream> a(r rVar) {
            return new a(this.bXa);
        }
    }
}
