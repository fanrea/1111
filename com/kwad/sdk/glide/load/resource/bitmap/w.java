package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class w implements com.kwad.sdk.glide.load.g<Bitmap, Bitmap> {
    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, com.kwad.sdk.glide.load.f fVar) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ com.kwad.sdk.glide.load.engine.s<Bitmap> a(Bitmap bitmap, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return l(bitmap);
    }

    private static com.kwad.sdk.glide.load.engine.s<Bitmap> l(Bitmap bitmap) {
        return new a(bitmap);
    }

    static final class a implements com.kwad.sdk.glide.load.engine.s<Bitmap> {
        private final Bitmap bkw;

        @Override // com.kwad.sdk.glide.load.engine.s
        public final void recycle() {
        }

        a(Bitmap bitmap) {
            this.bkw = bitmap;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public final Class<Bitmap> afv() {
            return Bitmap.class;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.engine.s
        /* renamed from: ahK, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.bkw;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public final int getSize() {
            return com.kwad.sdk.glide.e.j.m(this.bkw);
        }
    }
}
