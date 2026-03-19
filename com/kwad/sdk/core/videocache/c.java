package com.kwad.sdk.core.videocache;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class c {
    public final File bIT;
    public final com.kwad.sdk.core.videocache.a.c bIU;
    public final com.kwad.sdk.core.videocache.a.a bIV;
    public final com.kwad.sdk.core.videocache.d.c bIW;
    public final com.kwad.sdk.core.videocache.b.b bIX;
    public final int bIY;
    public final int bIZ;

    c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.bIT = file;
        this.bIU = cVar;
        this.bIV = aVar;
        this.bIW = cVar2;
        this.bIX = bVar;
        this.bIY = i;
        this.bIZ = i2;
    }

    final File fX(String str) {
        return new File(this.bIT, this.bIU.gi(str));
    }
}
