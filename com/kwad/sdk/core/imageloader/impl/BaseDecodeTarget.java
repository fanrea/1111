package com.kwad.sdk.core.imageloader.impl;

import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.request.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseDecodeTarget<T> extends c<T> {
    protected final ImageLoadingListener mLoadingListener;
    protected final String url;

    public BaseDecodeTarget(String str) {
        this(str, null);
    }

    public BaseDecodeTarget(String str, ImageLoadingListener imageLoadingListener) {
        this.mLoadingListener = imageLoadingListener;
        this.url = str;
    }

    @Override // com.kwad.sdk.glide.request.a.c, com.kwad.sdk.glide.request.a.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingStarted(this.url, null);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.c, com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingFailed(this.url, null, new FailReason(FailReason.FailType.UNKNOWN, null));
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void onLoadCleared(Drawable drawable) {
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingCancelled(this.url, null);
        }
    }
}
