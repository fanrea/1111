package com.kwad.components.core;

import com.kwad.components.ad.b.b;
import com.kwad.components.ad.b.c;
import com.kwad.components.ad.b.e;
import com.kwad.components.ad.b.f;
import com.kwad.components.ad.b.g;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.b.i;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsContentWallpaperPage;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsTubePage;
import com.kwad.sdk.api.KsWallpaperFeedPage;
import com.kwad.sdk.api.tube.KSTubeDetailParam;
import com.kwad.sdk.api.tube.KSTubeParam;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LoadManager implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestToken(KsScene ksScene) {
        b bVar = (b) d.g(b.class);
        return bVar != null ? bVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestTokenV2(KsScene ksScene) {
        b bVar = (b) d.g(b.class);
        return bVar != null ? bVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadLivePage(KsScene ksScene) {
        EcLiveComponents ecLiveComponents = (EcLiveComponents) d.g(EcLiveComponents.class);
        if (ecLiveComponents != null) {
            return ecLiveComponents.loadLivePage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        e eVar = (e) d.g(e.class);
        if (eVar != null) {
            eVar.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.bCv;
            fullScreenVideoAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        h hVar = (h) d.g(h.class);
        if (hVar != null) {
            hVar.loadRewardVideoAd(ksScene, rewardVideoAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.g(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadFeedAd(ksScene, feedAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.g(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadConfigFeedAd(ksScene, feedAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        try {
            com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) d.g(com.kwad.components.ad.b.a.class);
            if (aVar != null) {
                aVar.loadBannerAd(ksScene, bannerAdListener);
            } else if (a.qr.booleanValue()) {
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
                bannerAdListener.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            bannerAdListener.onError(com.kwad.sdk.core.network.e.bCD.errorCode, com.kwad.sdk.core.network.e.bCD.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        c cVar = (c) d.g(c.class);
        if (cVar != null) {
            cVar.loadDrawAd(ksScene, drawAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            drawAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        g gVar = (g) d.g(g.class);
        if (gVar != null) {
            gVar.loadNativeAd(ksScene, nativeAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        i iVar = (i) d.g(i.class);
        if (iVar != null) {
            iVar.loadSplashScreenAd(ksScene, splashScreenAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        f fVar = (f) d.g(f.class);
        if (fVar != null) {
            fVar.loadInterstitialAd(ksScene, interstitialAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            interstitialAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.loadContentAllianceAd(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPage(KsScene ksScene) {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.loadContentPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.loadContentPageByPush(ksScene, str);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageBySchema(KsScene ksScene, String str) {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.loadContentPageBySchema(ksScene, str);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene) {
        com.kwad.components.ct.api.h hVar = (com.kwad.components.ct.api.h) d.g(com.kwad.components.ct.api.h.class);
        if (hVar != null) {
            return hVar.loadContentWallpaperPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene) {
        com.kwad.components.ct.api.h hVar = (com.kwad.components.ct.api.h) d.g(com.kwad.components.ct.api.h.class);
        if (hVar != null) {
            return hVar.loadWallpaperFeedPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsFeedPage loadFeedPage(KsScene ksScene) {
        com.kwad.components.ct.api.c cVar = (com.kwad.components.ct.api.c) d.g(com.kwad.components.ct.api.c.class);
        if (cVar != null) {
            return cVar.loadFeedPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene) {
        com.kwad.components.ct.api.e eVar = (com.kwad.components.ct.api.e) d.g(com.kwad.components.ct.api.e.class);
        if (eVar != null) {
            return eVar.loadHorizontalFeedPage(ksScene);
        }
        return null;
    }

    public KsHorizontalFeedPage loadHorizontalNewsFeedPage(KsScene ksScene) {
        com.kwad.components.ct.api.e eVar = (com.kwad.components.ct.api.e) d.g(com.kwad.components.ct.api.e.class);
        if (eVar != null) {
            return eVar.loadHorizontalNewsFeedPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene) {
        com.kwad.components.ct.api.e eVar = (com.kwad.components.ct.api.e) d.g(com.kwad.components.ct.api.e.class);
        if (eVar != null) {
            return eVar.loadHorizontalPlayFeedPage(ksScene);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHorizontalVideoData(KsScene ksScene, KsLoadManager.KsHorizontalVideoDataListener ksHorizontalVideoDataListener) {
        com.kwad.components.ct.api.e eVar = (com.kwad.components.ct.api.e) d.g(com.kwad.components.ct.api.e.class);
        if (eVar != null) {
            eVar.loadHorizontalVideoData(ksScene, ksHorizontalVideoDataListener);
        } else {
            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.bCv;
            ksHorizontalVideoDataListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    public KsTubePage loadTubePage(KsScene ksScene, boolean z) {
        com.kwad.components.ct.api.g gVar = (com.kwad.components.ct.api.g) d.g(com.kwad.components.ct.api.g.class);
        if (gVar != null) {
            return gVar.a(ksScene, KSTubeParamInner.obtain().setShowTitleBar(z).setFreeEpisodeCount(KSTubeParamInner.FREE_ALL).setUnlockEpisodeCount(0).setUserId("").setUserName("").setDisableUnLockTipDialog(true).setDisableAutoOpenPlayPage(false));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsTubePage loadTubePage(KsScene ksScene, KSTubeParam kSTubeParam) {
        com.kwad.components.ct.api.g gVar = (com.kwad.components.ct.api.g) d.g(com.kwad.components.ct.api.g.class);
        if (gVar != null) {
            return gVar.a(ksScene, KSTubeParamInner.covertFrom(kSTubeParam));
        }
        return null;
    }

    public KsContentPage loadTubeContentPage(KSTubeDetailParam kSTubeDetailParam) {
        com.kwad.components.ct.api.g gVar = (com.kwad.components.ct.api.g) d.g(com.kwad.components.ct.api.g.class);
        if (gVar == null || !kSTubeDetailParam.isValid()) {
            return null;
        }
        return gVar.loadTubeContentPage(kSTubeDetailParam);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener) {
        com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) d.g(com.kwad.components.ct.api.b.class);
        if (bVar != null) {
            bVar.loadEntryElement(ksScene, entryElementListener, false);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            entryElementListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) d.g(com.kwad.components.ct.api.b.class);
        if (bVar != null) {
            bVar.loadEntryElement(ksScene, entryElementListener, z);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            entryElementListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHotspotData(KsScene ksScene, KsLoadManager.KsHotSpotDataListener ksHotSpotDataListener) {
        com.kwad.components.ct.api.f fVar = (com.kwad.components.ct.api.f) d.g(com.kwad.components.ct.api.f.class);
        if (fVar != null) {
            fVar.loadHotspotData(ksScene, ksHotSpotDataListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            ksHotSpotDataListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHotspotPage(KsScene ksScene, KsLoadManager.KsHotSpotPageListener ksHotSpotPageListener) {
        com.kwad.components.ct.api.f fVar = (com.kwad.components.ct.api.f) d.g(com.kwad.components.ct.api.f.class);
        if (fVar != null) {
            fVar.loadHotspotPage(ksScene, ksHotSpotPageListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.bCv;
            ksHotSpotPageListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
