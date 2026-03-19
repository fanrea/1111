package com.kwad.sdk.glide.webp.decoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class WebpFrameCacheStrategy {
    public static final WebpFrameCacheStrategy caS = new a().ajP().ajS();
    public static final WebpFrameCacheStrategy caT = new a().ajR().ajS();
    public static final WebpFrameCacheStrategy caU = new a().ajQ().ajS();
    private CacheControl caV;
    private int caW;

    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    /* synthetic */ WebpFrameCacheStrategy(a aVar, byte b) {
        this(aVar);
    }

    private WebpFrameCacheStrategy(a aVar) {
        this.caV = aVar.caX;
        this.caW = aVar.Pw;
    }

    public final boolean noCache() {
        return this.caV == CacheControl.CACHE_NONE;
    }

    public final boolean ajO() {
        return this.caV == CacheControl.CACHE_ALL;
    }

    public final int oq() {
        return this.caW;
    }

    public static final class a {
        private int Pw;
        private CacheControl caX;

        public final a ajP() {
            this.caX = CacheControl.CACHE_NONE;
            return this;
        }

        public final a ajQ() {
            this.caX = CacheControl.CACHE_ALL;
            return this;
        }

        public final a ajR() {
            this.caX = CacheControl.CACHE_AUTO;
            return this;
        }

        public final WebpFrameCacheStrategy ajS() {
            return new WebpFrameCacheStrategy(this, (byte) 0);
        }
    }
}
