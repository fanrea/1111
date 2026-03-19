package com.kwad.sdk.glide.d;

import com.kwad.sdk.glide.load.c;
import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements c {
    private final Object aBm;

    public b(Object obj) {
        this.aBm = ax.checkNotNull(obj);
    }

    public final String toString() {
        return "ObjectKey{object=" + this.aBm + '}';
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.aBm.equals(((b) obj).aBm);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return this.aBm.hashCode();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.aBm.toString().getBytes(bRy));
    }
}
