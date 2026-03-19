package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class c implements l {
    private final b bUx = new b();
    private final h<a, Bitmap> bUy = new h<>();

    c() {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final void e(Bitmap bitmap) {
        this.bUy.a(this.bUx.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        return this.bUy.b((h<a, Bitmap>) this.bUx.f(i, i2, config));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final Bitmap agS() {
        return this.bUy.removeLast();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final String f(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final String c(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final int g(Bitmap bitmap) {
        return com.kwad.sdk.glide.e.j.m(bitmap);
    }

    public final String toString() {
        return "AttributeStrategy:\n  " + this.bUy;
    }

    private static String h(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    static String d(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    static class b extends d<a> {
        b() {
        }

        final a f(int i, int i2, Bitmap.Config config) {
            a aVarAgW = agW();
            aVarAgW.e(i, i2, config);
            return aVarAgW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: agU, reason: merged with bridge method [inline-methods] */
        public a agV() {
            return new a(this);
        }
    }

    static class a implements m {
        private Bitmap.Config bUA;
        private final b bUz;
        private int height;
        private int width;

        public a(b bVar) {
            this.bUz = bVar;
        }

        public final void e(int i, int i2, Bitmap.Config config) {
            this.width = i;
            this.height = i2;
            this.bUA = config;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.width == aVar.width && this.height == aVar.height && this.bUA == aVar.bUA) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.bUA;
            return i + (config != null ? config.hashCode() : 0);
        }

        public final String toString() {
            return c.d(this.width, this.height, this.bUA);
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public final void agT() {
            this.bUz.a(this);
        }
    }
}
