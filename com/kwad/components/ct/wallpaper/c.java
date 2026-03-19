package com.kwad.components.ct.wallpaper;

import com.kwad.components.ct.detail.listener.DetailPageListener;
import com.kwad.components.ct.home.i;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.AbstractKsWallpaperFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends AbstractKsWallpaperFeedPage {
    private WeakReference<com.kwad.components.ct.feed.home.b> alL;
    private KsContentPage.PageListener alM;
    private KsContentPage.VideoListener alN;
    private KsContentPage.KsShareListener alT;
    private final DetailPageListener alX = new DetailPageListener() { // from class: com.kwad.components.ct.wallpaper.c.1
        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageEnter(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alM != null) {
                c.this.alM.onPageEnter(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageResume(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alM != null) {
                c.this.alM.onPageResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPagePause(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alM != null) {
                c.this.alM.onPagePause(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageLeave(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alM != null) {
                c.this.alM.onPageLeave(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }
    };
    private final com.kwad.components.ct.detail.listener.a alY = new com.kwad.components.ct.detail.listener.a() { // from class: com.kwad.components.ct.wallpaper.c.2
        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alN != null) {
                c.this.alN.onVideoPlayStart(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alN != null) {
                c.this.alN.onVideoPlayPaused(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alN != null) {
                c.this.alN.onVideoPlayResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void d(int i, CtAdTemplate ctAdTemplate) {
            if (c.this.alN != null) {
                c.this.alN.onVideoPlayCompleted(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            if (c.this.alN != null) {
                c.this.alN.onVideoPlayError(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate), i2, i3);
            }
        }
    };
    private SceneImpl mAdScene;

    public c(SceneImpl sceneImpl) {
        this.mAdScene = sceneImpl;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsWallpaperFeedPage
    public final KsFragment getFragment2() {
        com.kwad.components.ct.feed.home.b bVarA = com.kwad.components.ct.feed.home.b.a(this.mAdScene, 15);
        this.alL = new WeakReference<>(bVarA);
        return bVarA;
    }

    @Override // com.kwad.sdk.api.KsWallpaperFeedPage
    public final boolean onBackPressed() {
        com.kwad.components.ct.feed.home.b bVar;
        WeakReference<com.kwad.components.ct.feed.home.b> weakReference = this.alL;
        return (weakReference == null || (bVar = weakReference.get()) == null || !bVar.onBackPressed()) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsWallpaperFeedPage
    public final void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
        if (videoListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alY);
        }
    }

    @Override // com.kwad.sdk.api.KsWallpaperFeedPage
    public final void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        if (pageListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alX);
        }
    }

    @Override // com.kwad.sdk.api.KsWallpaperFeedPage
    public final void setShareListener(KsContentPage.KsShareListener ksShareListener) {
        this.alT = ksShareListener;
        i.a(ksShareListener);
    }
}
