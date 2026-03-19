package com.kwad.components.ct.horizontal.detail;

import android.content.Context;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsHorizontalVideoModel;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements KsHorizontalVideoModel {
    private KsContentPage.VideoListener aLJ;
    private KsContentPage.PageListener alM;
    private KsContentPage.ExternalViewControlListener alU;
    private final SceneImpl mAdScene;
    private CtAdTemplate mAdTemplate;

    public c(CtAdTemplate ctAdTemplate, SceneImpl sceneImpl) {
        this.mAdTemplate = ctAdTemplate;
        this.mAdScene = sceneImpl;
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final String getAuthorName() {
        return com.kwad.components.ct.response.a.a.aL(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final String getAuthorIcon() {
        return com.kwad.components.ct.response.a.a.bf(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final String getTitle() {
        return com.kwad.components.ct.response.a.a.aN(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final String getContentDesc() {
        return com.kwad.components.ct.response.a.a.aQ(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final long getPublishTime() {
        return com.kwad.components.ct.response.a.a.aP(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final String getCoverUrl() {
        return com.kwad.components.ct.response.a.a.aE(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final long getWatchCount() {
        return com.kwad.components.ct.response.a.a.aU(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final long getContentLikeCount() {
        return com.kwad.components.ct.response.a.a.aH(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final long getVideoDuration() {
        return com.kwad.components.ct.response.a.a.aB(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.aLJ = videoListener;
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final void setExternalViewControlListener(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
    }

    @Override // com.kwad.sdk.api.KsHorizontalVideoModel
    public final void handleClick(Context context) {
        KsContentPage.VideoListener videoListener = this.aLJ;
        if (videoListener != null) {
            com.kwad.components.ct.horizontal.video.a.b(videoListener);
        }
        KsContentPage.ExternalViewControlListener externalViewControlListener = this.alU;
        if (externalViewControlListener != null) {
            com.kwad.components.ct.horizontal.video.a.a(externalViewControlListener);
        }
        KsContentPage.PageListener pageListener = this.alM;
        if (pageListener != null) {
            com.kwad.components.ct.horizontal.video.a.a(pageListener);
        }
        HorizontalFeedParam horizontalFeedParam = new HorizontalFeedParam();
        SceneImpl sceneImpl = this.mAdScene;
        sceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 21));
        horizontalFeedParam.mScene = sceneImpl;
        horizontalFeedParam.mAdTemplate = this.mAdTemplate;
        a.a(context, horizontalFeedParam);
    }
}
