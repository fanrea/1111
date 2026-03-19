package com.kwad.sdk.core.imageloader.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FrameSequenceImageViewTarget extends e<FrameSequence> {
    private final a<FrameSequence> mFailRequestListener;
    private final ImageLoadingListener mLoadingListener;
    private final String url;

    public FrameSequenceImageViewTarget(ImageView imageView, a<FrameSequence> aVar, String str, ImageLoadingListener imageLoadingListener) {
        super(imageView);
        this.mFailRequestListener = aVar;
        this.mLoadingListener = imageLoadingListener;
        this.url = str;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.request.a.e
    public void setResource(FrameSequence frameSequence) {
        if (this.mLoadingListener != null) {
            DecodedResult decodedResult = new DecodedResult();
            decodedResult.mFrameSequence = frameSequence;
            this.mLoadingListener.onLoadingComplete(this.url, getView(), decodedResult);
        }
    }
}
