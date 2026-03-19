package com.kwad.components.ct.horizontal.feed;

import com.kwad.components.core.u.k;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.api.core.AbstractKsHorizontalFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsHorizontalFeedPageImpl extends AbstractKsHorizontalFeedPage {
    private KsContentPage.VideoListener aLJ;
    private final boolean aLR;
    private final boolean aLS;
    private WeakReference<c> alL;
    private KsContentPage.PageListener alM;
    private KsContentPage.ExternalViewControlListener alU;
    private final SceneImpl mAdScene;

    public KsHorizontalFeedPageImpl(SceneImpl sceneImpl, boolean z, boolean z2) {
        this.mAdScene = sceneImpl;
        this.aLR = z;
        this.aLS = z2;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsHorizontalFeedPage
    public KsFragment getFragment2() {
        c cVarA = c.a(this.mAdScene, this.aLR, this.aLS);
        this.alL = new WeakReference<>(cVarA);
        return cVarA;
    }

    @Override // com.kwad.sdk.api.KsHorizontalFeedPage
    public boolean onBackPressed() {
        c cVar;
        WeakReference<c> weakReference = this.alL;
        return (weakReference == null || (cVar = weakReference.get()) == null || !cVar.onBackPressed()) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsHorizontalFeedPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.aLJ = videoListener;
        com.kwad.components.ct.horizontal.video.a.b(videoListener);
        c.b(this.aLJ);
    }

    @Override // com.kwad.sdk.api.KsHorizontalFeedPage
    public void setExternalViewControlListener(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
        com.kwad.components.ct.horizontal.video.a.a(externalViewControlListener);
        com.kwad.components.ct.horizontal.news.c.a(this.alU);
        c.a(this.alU);
    }

    @Override // com.kwad.sdk.api.KsHorizontalFeedPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        com.kwad.components.ct.horizontal.video.a.a(pageListener);
        if (pageListener instanceof KsHorizontalFeedPage.NewsPageListener) {
            com.kwad.components.ct.horizontal.news.c.a((KsHorizontalFeedPage.NewsPageListener) this.alM);
        }
    }

    public void setsHorizontalNewsFeedTitleSize(int i) {
        k.setsHorizontalNewsFeedTitleSize(i);
    }
}
