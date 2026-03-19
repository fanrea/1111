package com.kwad.sdk.glide;

import com.kwad.sdk.glide.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class h<CHILD extends h<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private com.kwad.sdk.glide.request.b.c<? super TranscodeType> bQD = com.kwad.sdk.glide.request.b.a.aju();

    /* renamed from: aft, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    final com.kwad.sdk.glide.request.b.c<? super TranscodeType> afu() {
        return this.bQD;
    }
}
