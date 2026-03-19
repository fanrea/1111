package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a<Z> implements j<Z> {
    private com.kwad.sdk.glide.request.e request;

    @Override // com.kwad.sdk.glide.a.i
    public void onDestroy() {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.a.i
    public void onStart() {
    }

    @Override // com.kwad.sdk.glide.a.i
    public void onStop() {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void setRequest(com.kwad.sdk.glide.request.e eVar) {
        this.request = eVar;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public com.kwad.sdk.glide.request.e getRequest() {
        return this.request;
    }
}
