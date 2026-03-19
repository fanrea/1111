package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface j<R> extends com.kwad.sdk.glide.a.i {
    com.kwad.sdk.glide.request.e getRequest();

    void getSize(i iVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, com.kwad.sdk.glide.request.b.b<? super R> bVar);

    void removeCallback(i iVar);

    void setRequest(com.kwad.sdk.glide.request.e eVar);
}
