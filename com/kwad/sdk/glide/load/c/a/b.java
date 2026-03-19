package com.kwad.sdk.glide.load.c.a;

import android.net.Uri;
import com.kwad.sdk.glide.load.c.g;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.r;
import com.kwad.sdk.glide.load.f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements n<Uri, InputStream> {
    private static final Set<String> bWW = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.alipay.sdk.m.l.a.r, "https")));
    private final n<g, InputStream> bWY;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    public b(n<g, InputStream> nVar) {
        this.bWY = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.c.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i, int i2, f fVar) {
        return this.bWY.b(new g(uri.toString()), i, i2, fVar);
    }

    private static boolean j(Uri uri) {
        return bWW.contains(uri.getScheme());
    }

    public static class a implements o<Uri, InputStream> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            return new b(rVar.a(g.class, InputStream.class));
        }
    }
}
