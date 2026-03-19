package com.kwad.sdk.core.imageloader.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.b.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DecodeBitmapTargedt extends BaseDecodeTarget<Bitmap> {
    private final a<Bitmap> mFailRequestListener;

    @Override // com.kwad.sdk.glide.request.a.j
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, b bVar) {
        onResourceReady((Bitmap) obj, (b<? super Bitmap>) bVar);
    }

    public DecodeBitmapTargedt(String str, ImageLoadingListener imageLoadingListener, a<Bitmap> aVar) {
        super(str, imageLoadingListener);
        this.mFailRequestListener = aVar;
    }

    public void onResourceReady(Bitmap bitmap, b<? super Bitmap> bVar) {
        if (this.mLoadingListener != null) {
            DecodedResult decodedResult = new DecodedResult();
            decodedResult.mBitmap = bitmap;
            this.mLoadingListener.onLoadingComplete(this.url, null, decodedResult);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.impl.BaseDecodeTarget, com.kwad.sdk.glide.request.a.c, com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        if (this.mLoadingListener != null) {
            this.mLoadingListener.onLoadingFailed(this.url, null, FailParser.parseFail(this.mFailRequestListener));
        }
    }
}
