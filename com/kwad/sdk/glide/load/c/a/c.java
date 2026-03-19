package com.kwad.sdk.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.r;
import com.kwad.sdk.glide.load.f;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements n<Uri, InputStream> {
    private final Context dR;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a<InputStream> b(Uri uri, int i, int i2, f fVar) {
        return a(uri, i, i2);
    }

    public c(Context context) {
        this.dR = context.getApplicationContext();
    }

    private n.a<InputStream> a(Uri uri, int i, int i2) {
        if (com.kwad.sdk.glide.load.a.a.b.Q(i, i2)) {
            return new n.a<>(new com.kwad.sdk.glide.d.b(uri), com.kwad.sdk.glide.load.a.a.c.a(this.dR, uri));
        }
        return null;
    }

    private static boolean j(Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.d(uri);
    }

    public static class a implements o<Uri, InputStream> {
        private final Context dR;

        public a(Context context) {
            this.dR = context;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            return new c(this.dR);
        }
    }
}
