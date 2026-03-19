package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    public static void loadInterstitialAd(KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.UL().TT()) {
            com.kwad.sdk.core.d.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.interstitial.f.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    interstitialAdListener.onError(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.q(sceneImplCovert);
        boolean zB = p.tH().b(sceneImplCovert, "loadInterstitialAd");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        sceneImplCovert.setAdStyle(23);
        com.kwad.components.ad.interstitial.report.c.eX().m(sceneImplCovert.getPosId());
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.f.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.report.c.eX().a(i, str, sceneImplCovert.getPosId());
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.interstitial.f.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interstitialAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : adResultData.testErrorMsg);
                    k.aw("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.interstitial.f.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class) != null) {
                        com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.b.e.eP(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.eX().a(adTemplateList.get(0), z);
                com.kwad.sdk.commercial.d.d.h(sceneImplCovert, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                if (com.kwad.sdk.core.response.b.c.v(adResultData)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adTemplateList) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = sceneImplCovert;
                            }
                            String strL = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate));
                            if (!com.kwad.sdk.core.response.b.b.dG(adTemplate)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.fb();
                                com.kwad.components.ad.interstitial.report.realtime.a.G(adTemplate);
                            }
                            if (!TextUtils.isEmpty(strL)) {
                                boolean zT = com.kwad.components.ad.interstitial.a.a.t(adTemplate);
                                if (com.kwad.sdk.core.config.e.XE() || zT) {
                                    arrayList2.add(adTemplate);
                                }
                            } else {
                                arrayList2.add(adTemplate);
                            }
                        }
                    }
                    adResultData.setAdTemplateList(arrayList2);
                    arrayList.add(e.f(adResultData));
                } else {
                    for (AdTemplate adTemplate2 : adTemplateList) {
                        if (adTemplate2 != null) {
                            if (adTemplate2.mAdScene == null) {
                                adTemplate2.mAdScene = sceneImplCovert;
                            }
                            String strL2 = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate2));
                            if (!com.kwad.sdk.core.response.b.b.dG(adTemplate2)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.fb();
                                com.kwad.components.ad.interstitial.report.realtime.a.G(adTemplate2);
                            }
                            AdResultData adResultDataA = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate2);
                            if (!TextUtils.isEmpty(strL2)) {
                                boolean zT2 = com.kwad.components.ad.interstitial.a.a.t(adTemplate2);
                                if (com.kwad.sdk.core.config.e.XE() || zT2) {
                                    arrayList.add(e.f(adResultDataA));
                                }
                            } else {
                                arrayList.add(e.f(adResultDataA));
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.fb();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.bCy);
                    k.aw("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.interstitial.report.c.eX().b(adTemplateList.get(0), z);
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.interstitial.f.2.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        KsAdLoadManager.P().b(arrayList);
                        k.aw("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }
        }).sK());
    }
}
