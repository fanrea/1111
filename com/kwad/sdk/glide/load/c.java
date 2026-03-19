package com.kwad.sdk.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface c {
    public static final Charset bRy = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
