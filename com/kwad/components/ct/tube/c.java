package com.kwad.components.ct.tube;

import android.app.Activity;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.detail.listener.DetailPageListener;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.b.a;
import com.kwad.components.ct.tube.channel.home.TubeChannelParam;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsTubePage;
import com.kwad.sdk.api.core.AbstractKsTubePage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import com.kwad.sdk.api.tube.detail.KSTubeEpisodeLoadListener;
import com.kwad.sdk.api.tube.detail.KSTubeEpisodeResult;
import com.kwad.sdk.api.tube.log.KSTubeLog;
import com.kwad.sdk.api.tube.request.KSTubeLoadListener;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.z;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends AbstractKsTubePage {
    private KsTubePage.InteractListener aVv;
    private final com.kwad.components.ct.tube.a.a aVw;
    private final boolean aVx;
    private b aVy;
    private WeakReference<com.kwad.components.ct.tube.channel.home.c> alL;
    private KsContentPage.PageListener alM;
    private KsContentPage.VideoListener alN;
    private final SceneImpl mSceneImpl;
    private final KSTubeParamInner mTubeParam;
    private final DetailPageListener alX = new DetailPageListener() { // from class: com.kwad.components.ct.tube.c.1
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
    private final com.kwad.components.ct.detail.listener.a alY = new com.kwad.components.ct.detail.listener.a() { // from class: com.kwad.components.ct.tube.c.2
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
    private final com.kwad.components.ct.tube.b.c aVz = new com.kwad.components.ct.tube.b.c() { // from class: com.kwad.components.ct.tube.c.3
        @Override // com.kwad.components.ct.tube.b.c
        public final int a(KsContentPage.ContentItem contentItem) {
            if (c.this.Kd()) {
                return 0;
            }
            try {
                return c.this.aVv.isNeedBlock(contentItem) ? 1 : 2;
            } catch (Throwable unused) {
                return 0;
            }
        }

        @Override // com.kwad.components.ct.tube.b.c
        public final void a(Activity activity, KsContentPage.ContentItem contentItem, final com.kwad.components.ct.tube.b.b bVar) {
            try {
                if (c.this.aVv != null) {
                    c.this.aVv.showAdIfNeeded(activity, contentItem, new KsTubePage.RewardCallback() { // from class: com.kwad.components.ct.tube.c.3.1
                        @Override // com.kwad.sdk.api.KsTubePage.RewardCallback
                        public final void onRewardArrived() {
                            bVar.onRewardArrived();
                        }

                        @Override // com.kwad.sdk.api.KsTubePage.RewardCallback
                        public final void onRewardFail(int i) {
                            bVar.onRewardFail(i);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    };
    private final a.b aVA = new a.b() { // from class: com.kwad.components.ct.tube.c.4
        @Override // com.kwad.components.ct.tube.b.a.b
        public final void a(TubeInfo tubeInfo) {
            try {
                try {
                    if (c.this.aVv != null) {
                        c.this.aVv.onTubeChannelClick(com.kwad.components.ct.tube.d.b.g(tubeInfo));
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                if (c.this.aVv != null) {
                    z.callMethod(c.this.aVv, "onTubeChannelClick", com.kwad.components.ct.tube.d.b.a(c.this.mSceneImpl, c.this.mTubeParam, tubeInfo));
                }
            }
        }
    };

    public c(SceneImpl sceneImpl, KSTubeParamInner kSTubeParamInner) {
        this.mSceneImpl = sceneImpl;
        this.mTubeParam = kSTubeParamInner;
        boolean z = e.a(com.kwad.sdk.core.config.c.bzH) == 0;
        this.aVx = z;
        this.aVw = new com.kwad.components.ct.tube.a.a(sceneImpl.entryScene, kSTubeParamInner, z);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsTubePage
    public final KsFragment getFragment2() {
        TubeChannelParam tubeChannelParam = new TubeChannelParam(this.mSceneImpl.getPosId(), 25);
        tubeChannelParam.mTubeParam = this.mTubeParam;
        com.kwad.components.ct.tube.channel.home.c cVarA = com.kwad.components.ct.tube.channel.home.c.a(tubeChannelParam);
        this.alL = new WeakReference<>(cVarA);
        return cVarA;
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final boolean onBackPressed() {
        com.kwad.components.ct.tube.channel.home.c cVar;
        WeakReference<com.kwad.components.ct.tube.channel.home.c> weakReference = this.alL;
        return (weakReference == null || (cVar = weakReference.get()) == null || !cVar.onBackPressed()) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        if (pageListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alX);
        }
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
        if (videoListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alY);
        }
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void setPageInteractListener(KsTubePage.InteractListener interactListener) {
        this.aVv = interactListener;
        com.kwad.components.ct.tube.b.a.Kv().a(this.aVz);
        com.kwad.components.ct.tube.b.a.Kv().a(this.aVA);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void requestTube(int i, int i2, KSTubeLoadListener kSTubeLoadListener) {
        this.aVw.requestTube(i, i2, kSTubeLoadListener);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void requestTube(List<Long> list, KSTubeLoadListener kSTubeLoadListener) {
        this.aVw.requestTube(list, kSTubeLoadListener);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void requestTubeHistory(int i, int i2, KSTubeLoadListener kSTubeLoadListener) {
        this.aVw.a(i, i2, kSTubeLoadListener);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final KsContentPage loadTubeContentPage(KSTubeChannelData kSTubeChannelData) {
        if (this.aVy == null) {
            TubeInfo tubeInfoA = com.kwad.components.ct.tube.d.b.a(kSTubeChannelData);
            this.aVy = new b(TubeEpisodeHomeParam.obtain().setEntryScene(this.mSceneImpl.entryScene).setKSTubeParam(this.mTubeParam).setTubeId(tubeInfoA.tubeId).setWatchEpisodeNum(tubeInfoA.watchEpisodeNum), this);
        }
        return this.aVy;
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void playSelectPage(int i) {
        b bVar = this.aVy;
        if (bVar != null) {
            bVar.playSelectPage(i);
        }
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void requestTubeEpisodeNumList(KSTubeChannelData kSTubeChannelData, KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener) {
        if (Kd()) {
            kSTubeEpisodeLoadListener.onError(com.kwad.sdk.core.network.e.bCG.errorCode, com.kwad.sdk.core.network.e.bCG.msg);
            return;
        }
        List<Integer> listAp = com.kwad.components.ct.tube.slide.b.b.KX().ap(kSTubeChannelData.getTubeId());
        if (ap.aM(listAp)) {
            kSTubeEpisodeLoadListener.onSuccess(KSTubeEpisodeResult.obtain().setTubeEpisodeNumList(listAp));
        } else {
            kSTubeEpisodeLoadListener.onError(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void requestTubeEpisode(KSTubeChannelData kSTubeChannelData, int i, KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener) {
        this.aVw.requestTubeEpisode(kSTubeChannelData, i, kSTubeEpisodeLoadListener);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void reportKSTubeLog(KSTubeLog kSTubeLog) {
        this.aVw.reportKSTubeLog(kSTubeLog);
    }

    @Override // com.kwad.sdk.api.KsTubePage
    public final void destroy() {
        this.alM = null;
        this.alN = null;
        this.aVv = null;
        com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        com.kwad.components.ct.tube.b.a.Kv().b(this.aVA);
        com.kwad.components.ct.tube.b.a.Kv().b(this.aVz);
        this.aVw.destroy();
    }

    public final boolean Kd() {
        return this.aVx;
    }
}
