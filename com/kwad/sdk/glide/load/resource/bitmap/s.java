package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class s implements com.kwad.sdk.glide.load.g<Uri, Bitmap> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final com.kwad.sdk.glide.load.resource.b.d bXK;

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ boolean a(Uri uri, com.kwad.sdk.glide.load.f fVar) {
        return l(uri);
    }

    public s(com.kwad.sdk.glide.load.resource.b.d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.bXK = dVar;
        this.bPy = eVar;
    }

    private static boolean l(Uri uri) {
        return "android.resource".equals(uri.getScheme());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(Uri uri, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        com.kwad.sdk.glide.load.engine.s<Drawable> sVarM = this.bXK.m(uri);
        if (sVarM == null) {
            return null;
        }
        return l.a(this.bPy, sVarM.get(), i, i2);
    }
}
