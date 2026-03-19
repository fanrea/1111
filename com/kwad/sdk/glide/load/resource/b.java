package com.kwad.sdk.glide.load.resource;

import android.content.Context;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.i;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<T> implements i<T> {
    private static final i<?> bXc = new b();

    @Override // com.kwad.sdk.glide.load.i
    public final s<T> transform(Context context, s<T> sVar, int i, int i2) {
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static <T> b<T> ahJ() {
        return (b) bXc;
    }

    private b() {
    }
}
