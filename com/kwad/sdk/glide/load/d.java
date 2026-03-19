package com.kwad.sdk.glide.load;

import android.content.Context;
import com.kwad.sdk.glide.load.engine.s;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d<T> implements i<T> {
    private final Collection<? extends i<T>> bRz;

    @SafeVarargs
    public d(i<T>... iVarArr) {
        if (iVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.bRz = Arrays.asList(iVarArr);
    }

    @Override // com.kwad.sdk.glide.load.i
    public final s<T> transform(Context context, s<T> sVar, int i, int i2) {
        Iterator<? extends i<T>> it = this.bRz.iterator();
        s<T> sVar2 = sVar;
        while (it.hasNext()) {
            s<T> sVarTransform = it.next().transform(context, sVar2, i, i2);
            if (sVar2 != null && !sVar2.equals(sVar) && !sVar2.equals(sVarTransform)) {
                sVar2.recycle();
            }
            sVar2 = sVarTransform;
        }
        return sVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.bRz.equals(((d) obj).bRz);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return this.bRz.hashCode();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends i<T>> it = this.bRz.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
