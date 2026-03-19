package com.kwad.sdk.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.c.o;
import com.kwad.sdk.glide.load.c.r;
import com.kwad.sdk.glide.load.f;
import com.kwad.sdk.glide.load.resource.bitmap.x;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements n<Uri, InputStream> {
    private final Context dR;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    public d(Context context) {
        this.dR = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.c.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i, int i2, f fVar) {
        if (com.kwad.sdk.glide.load.a.a.b.Q(i, i2) && c(fVar)) {
            return new n.a<>(new com.kwad.sdk.glide.d.b(uri), com.kwad.sdk.glide.load.a.a.c.b(this.dR, uri));
        }
        return null;
    }

    private static boolean c(f fVar) {
        Long l = (Long) fVar.a(x.bXN);
        return l != null && l.longValue() == -1;
    }

    private static boolean j(Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.c(uri);
    }

    public static class a implements o<Uri, InputStream> {
        private final Context dR;

        public a(Context context) {
            this.dR = context;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            return new d(this.dR);
        }
    }
}
