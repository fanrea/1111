package com.kwad.sdk.core.imageloader.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.a.d;
import com.kwad.sdk.glide.request.b.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BaseDrawableImageViewTarget extends d {
    private final a<Drawable> mFailRequestListener;
    private final ImageLoadingListener mLoadingListener;
    private final String url;

    @Override // com.kwad.sdk.glide.request.a.e, com.kwad.sdk.glide.request.a.j
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, b bVar) {
        onResourceReady((Drawable) obj, (b<? super Drawable>) bVar);
    }

    public BaseDrawableImageViewTarget(ImageView imageView, String str, ImageLoadingListener imageLoadingListener, a<Drawable> aVar) {
        super(imageView);
        this.mLoadingListener = imageLoadingListener;
        this.url = str;
        this.mFailRequestListener = aVar;
    }

    @Override // com.kwad.sdk.glide.request.a.e, com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingStarted(this.url, getView());
        }
    }

    @Override // com.kwad.sdk.glide.request.a.e, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingFailed(this.url, getView(), FailParser.parseFail(this.mFailRequestListener));
        }
    }

    @Override // com.kwad.sdk.glide.request.a.e, com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        ImageLoadingListener imageLoadingListener = this.mLoadingListener;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingCancelled(this.url, getView());
        }
    }

    public void onResourceReady(Drawable drawable, b<? super Drawable> bVar) {
        super.onResourceReady((BaseDrawableImageViewTarget) drawable, (b<? super BaseDrawableImageViewTarget>) bVar);
        if (this.mLoadingListener != null) {
            DecodedResult decodedResult = new DecodedResult();
            if (drawable instanceof BitmapDrawable) {
                decodedResult.mBitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            this.mLoadingListener.onLoadingComplete(this.url, getView(), decodedResult);
        }
    }
}
