package com.kwad.sdk.core.imageloader.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BaseBitmapImageViewTarget extends b {
    private final a<Bitmap> mFailRequestListener;
    private final ImageLoadingListener mLoadingListener;
    private final String url;

    @Override // com.kwad.sdk.glide.request.a.e, com.kwad.sdk.glide.request.a.j
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
        onResourceReady((Bitmap) obj, (com.kwad.sdk.glide.request.b.b<? super Bitmap>) bVar);
    }

    public BaseBitmapImageViewTarget(ImageView imageView, String str, ImageLoadingListener imageLoadingListener) {
        this(imageView, str, imageLoadingListener, null);
    }

    public BaseBitmapImageViewTarget(ImageView imageView, String str, ImageLoadingListener imageLoadingListener, a<Bitmap> aVar) {
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

    public void onResourceReady(Bitmap bitmap, com.kwad.sdk.glide.request.b.b<? super Bitmap> bVar) {
        super.onResourceReady((BaseBitmapImageViewTarget) bitmap, (com.kwad.sdk.glide.request.b.b<? super BaseBitmapImageViewTarget>) bVar);
        if (this.mLoadingListener != null) {
            DecodedResult decodedResult = new DecodedResult();
            decodedResult.mBitmap = bitmap;
            this.mLoadingListener.onLoadingComplete(this.url, getView(), decodedResult);
        }
    }
}
