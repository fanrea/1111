package com.kwad.sdk.glide.d;

import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements c {
    private static final a cac = new a();

    public final String toString() {
        return "EmptySignature";
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static a ajw() {
        return cac;
    }

    private a() {
    }
}
