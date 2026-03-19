package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c<T> implements j<T> {
    private final int height;
    private com.kwad.sdk.glide.request.e request;
    private final int width;

    @Override // com.kwad.sdk.glide.a.i
    public void onDestroy() {
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
    public final void removeCallback(i iVar) {
    }

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c(int i, int i2) {
        if (!com.kwad.sdk.glide.e.j.Y(i, i2)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
        }
        this.width = i;
        this.height = i2;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void getSize(i iVar) {
        iVar.V(this.width, this.height);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void setRequest(com.kwad.sdk.glide.request.e eVar) {
        this.request = eVar;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final com.kwad.sdk.glide.request.e getRequest() {
        return this.request;
    }
}
