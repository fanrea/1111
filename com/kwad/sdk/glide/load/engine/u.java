package com.kwad.sdk.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class u implements com.kwad.sdk.glide.load.c {
    private static final com.kwad.sdk.glide.e.g<Class<?>, byte[]> bUp = new com.kwad.sdk.glide.e.g<>(50);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private final com.kwad.sdk.glide.load.c bSq;
    private final com.kwad.sdk.glide.load.c bSv;
    private final com.kwad.sdk.glide.load.f bSx;
    private final Class<?> bUq;
    private final com.kwad.sdk.glide.load.i<?> bUr;
    private final int height;
    private final int width;

    u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.i<?> iVar, Class<?> cls, com.kwad.sdk.glide.load.f fVar) {
        this.bPD = bVar;
        this.bSq = cVar;
        this.bSv = cVar2;
        this.width = i;
        this.height = i2;
        this.bUr = iVar;
        this.bUq = cls;
        this.bSx = fVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.height == uVar.height && this.width == uVar.width && com.kwad.sdk.glide.e.j.c(this.bUr, uVar.bUr) && this.bUq.equals(uVar.bUq) && this.bSq.equals(uVar.bSq) && this.bSv.equals(uVar.bSv) && this.bSx.equals(uVar.bSx)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        int iHashCode = (((((this.bSq.hashCode() * 31) + this.bSv.hashCode()) * 31) + this.width) * 31) + this.height;
        com.kwad.sdk.glide.load.i<?> iVar = this.bUr;
        if (iVar != null) {
            iHashCode = (iHashCode * 31) + iVar.hashCode();
        }
        return (((iHashCode * 31) + this.bUq.hashCode()) * 31) + this.bSx.hashCode();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.bPD.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.bSv.updateDiskCacheKey(messageDigest);
        this.bSq.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.i<?> iVar = this.bUr;
        if (iVar != null) {
            iVar.updateDiskCacheKey(messageDigest);
        }
        this.bSx.updateDiskCacheKey(messageDigest);
        messageDigest.update(agQ());
        this.bPD.put(bArr);
    }

    private byte[] agQ() {
        com.kwad.sdk.glide.e.g<Class<?>, byte[]> gVar = bUp;
        byte[] bArr = gVar.get(this.bUq);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.bUq.getName().getBytes(bRy);
        gVar.put(this.bUq, bytes);
        return bytes;
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.bSq + ", signature=" + this.bSv + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.bUq + ", transformation='" + this.bUr + "', options=" + this.bSx + '}';
    }
}
