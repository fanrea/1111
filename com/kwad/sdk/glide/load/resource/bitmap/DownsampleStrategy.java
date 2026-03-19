package com.kwad.sdk.glide.load.resource.bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy bXj = new e();
    public static final DownsampleStrategy bXk;
    public static final DownsampleStrategy bXl;
    public static final DownsampleStrategy bXm;
    public static final DownsampleStrategy bXn;
    public static final DownsampleStrategy bXo;
    public static final DownsampleStrategy bXp;
    public static final com.kwad.sdk.glide.load.e<DownsampleStrategy> bXq;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public abstract SampleSizeRounding ahL();

    public abstract float c(int i, int i2, int i3, int i4);

    static {
        d dVar = new d();
        bXk = dVar;
        bXl = new a();
        bXm = new b();
        bXn = new c();
        bXo = new f();
        bXp = dVar;
        bXq = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.QUALITY;
        }
    }

    static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.QUALITY;
        }
    }

    static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.QUALITY;
        }
    }

    static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.MEMORY;
        }
    }

    static class f extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        f() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.QUALITY;
        }
    }

    static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final float c(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, bXj.c(i, i2, i3, i4));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding ahL() {
            return SampleSizeRounding.QUALITY;
        }
    }
}
