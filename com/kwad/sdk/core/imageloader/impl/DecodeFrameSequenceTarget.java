package com.kwad.sdk.core.imageloader.impl;

import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.b.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DecodeFrameSequenceTarget extends BaseDecodeTarget<FrameSequence> {
    private final a<FrameSequence> mFailRequestListener;

    @Override // com.kwad.sdk.glide.request.a.j
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, b bVar) {
        onResourceReady((FrameSequence) obj, (b<? super FrameSequence>) bVar);
    }

    public DecodeFrameSequenceTarget(String str, ImageLoadingListener imageLoadingListener, a<FrameSequence> aVar) {
        super(str, imageLoadingListener);
        this.mFailRequestListener = aVar;
    }

    public void onResourceReady(FrameSequence frameSequence, b<? super FrameSequence> bVar) {
        if (this.mLoadingListener != null) {
            DecodedResult decodedResult = new DecodedResult();
            decodedResult.mFrameSequence = frameSequence;
            this.mLoadingListener.onLoadingComplete(this.url, null, decodedResult);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.impl.BaseDecodeTarget, com.kwad.sdk.glide.request.a.c, com.kwad.sdk.glide.request.a.j
    public void onLoadFailed(Drawable drawable) {
        if (this.mLoadingListener != null) {
            this.mLoadingListener.onLoadingFailed(this.url, null, FailParser.parseFail(this.mFailRequestListener));
        }
    }
}
