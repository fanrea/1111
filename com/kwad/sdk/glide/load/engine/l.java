package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class l implements com.kwad.sdk.glide.load.c {
    private final Class<?> bQh;
    private final Object bQj;
    private final Map<Class<?>, com.kwad.sdk.glide.load.i<?>> bSB;
    private final com.kwad.sdk.glide.load.c bSv;
    private final com.kwad.sdk.glide.load.f bSx;
    private final Class<?> bSz;
    private int bUb;
    private final int height;
    private final int width;

    l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.i<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.f fVar) {
        this.bQj = ax.checkNotNull(obj);
        this.bSv = (com.kwad.sdk.glide.load.c) ax.f(cVar, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.bSB = (Map) ax.checkNotNull(map);
        this.bSz = (Class) ax.f(cls, "Resource class must not be null");
        this.bQh = (Class) ax.f(cls2, "Transcode class must not be null");
        this.bSx = (com.kwad.sdk.glide.load.f) ax.checkNotNull(fVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.bQj.equals(lVar.bQj) && this.bSv.equals(lVar.bSv) && this.height == lVar.height && this.width == lVar.width && this.bSB.equals(lVar.bSB) && this.bSz.equals(lVar.bSz) && this.bQh.equals(lVar.bQh) && this.bSx.equals(lVar.bSx)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        if (this.bUb == 0) {
            int iHashCode = this.bQj.hashCode();
            this.bUb = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.bSv.hashCode()) * 31) + this.width) * 31) + this.height;
            this.bUb = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.bSB.hashCode();
            this.bUb = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.bSz.hashCode();
            this.bUb = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.bQh.hashCode();
            this.bUb = iHashCode5;
            this.bUb = (iHashCode5 * 31) + this.bSx.hashCode();
        }
        return this.bUb;
    }

    public final String toString() {
        return "EngineKey{model=" + this.bQj + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.bSz + ", transcodeClass=" + this.bQh + ", signature=" + this.bSv + ", hashCode=" + this.bUb + ", transformations=" + this.bSB + ", options=" + this.bSx + '}';
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
