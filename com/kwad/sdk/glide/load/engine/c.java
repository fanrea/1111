package com.kwad.sdk.glide.load.engine;

import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class c implements com.kwad.sdk.glide.load.c {
    private final com.kwad.sdk.glide.load.c bSq;
    private final com.kwad.sdk.glide.load.c bSv;

    c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.bSq = cVar;
        this.bSv = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.bSq.equals(cVar.bSq) && this.bSv.equals(cVar.bSv)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return (this.bSq.hashCode() * 31) + this.bSv.hashCode();
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.bSq + ", signature=" + this.bSv + '}';
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.bSq.updateDiskCacheKey(messageDigest);
        this.bSv.updateDiskCacheKey(messageDigest);
    }
}
