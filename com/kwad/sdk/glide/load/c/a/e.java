package com.kwad.sdk.glide.load.c.a;

import com.kwad.sdk.glide.load.c.g;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.r;
import com.kwad.sdk.glide.load.f;
import java.io.InputStream;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements n<URL, InputStream> {
    private final n<g, InputStream> bXb;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(URL url) {
        return true;
    }

    public e(n<g, InputStream> nVar) {
        this.bXb = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.c.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(URL url, int i, int i2, f fVar) {
        return this.bXb.b(new g(url), i, i2, fVar);
    }

    public static class a implements o<URL, InputStream> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }
    }
}
