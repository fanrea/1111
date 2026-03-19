package com.kwad.sdk.glide.load.engine.a;

import androidx.core.util.Pools;
import com.bytedance.common.utility.StringEncryptUtils;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j {
    private final com.kwad.sdk.glide.e.g<com.kwad.sdk.glide.load.c, String> bVE = new com.kwad.sdk.glide.e.g<>(1000);
    private final Pools.Pool<a> bVF = com.kwad.sdk.glide.e.a.a.a(10, new a.InterfaceC0602a<a>() { // from class: com.kwad.sdk.glide.load.engine.a.j.1
        @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
        public final /* synthetic */ a agF() {
            return ahn();
        }

        private static a ahn() {
            try {
                return new a(MessageDigest.getInstance(StringEncryptUtils.SHA_256));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    public final String g(com.kwad.sdk.glide.load.c cVar) {
        String strH;
        synchronized (this.bVE) {
            strH = this.bVE.get(cVar);
        }
        if (strH == null) {
            strH = h(cVar);
        }
        synchronized (this.bVE) {
            this.bVE.put(cVar, strH);
        }
        return strH;
    }

    private String h(com.kwad.sdk.glide.load.c cVar) {
        a aVar = (a) ax.checkNotNull(this.bVF.acquire());
        try {
            cVar.updateDiskCacheKey(aVar.bVH);
            return com.kwad.sdk.glide.e.j.n(aVar.bVH.digest());
        } finally {
            this.bVF.release(aVar);
        }
    }

    static final class a implements a.c {
        private final com.kwad.sdk.glide.e.a.b bSK = com.kwad.sdk.glide.e.a.b.ajI();
        final MessageDigest bVH;

        a(MessageDigest messageDigest) {
            this.bVH = messageDigest;
        }

        @Override // com.kwad.sdk.glide.e.a.a.c
        public final com.kwad.sdk.glide.e.a.b agy() {
            return this.bSK;
        }
    }
}
