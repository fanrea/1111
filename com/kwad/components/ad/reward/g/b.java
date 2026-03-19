package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.e;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static void a(KsScene ksScene, final c cVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        d.q(sceneImplCovert);
        com.kwad.components.ad.reward.monitor.c.a(true, sceneImplCovert.getPosId());
        boolean zB = p.tH().b(sceneImplCovert, "loadRewardVideoAd");
        sceneImplCovert.setAdStyle(2);
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new j() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.j
            public final void al() {
                com.kwad.components.ad.reward.monitor.c.b(true, sceneImplCovert.posId);
            }
        }).a(new e() { // from class: com.kwad.components.ad.reward.g.b.1
            static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.YK = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(true, i, str, sceneImplCovert.getPosId());
                if (i != com.kwad.sdk.core.network.e.bCy.errorCode && i != com.kwad.sdk.core.network.e.bCt.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i);
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        cVar.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                List list;
                ArrayList arrayList;
                com.kwad.components.ad.reward.monitor.c.c(true, sceneImplCovert.posId);
                List listA = b.a(sceneImplCovert, adResultData.getProceedTemplateList());
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : adResultData.testErrorMsg);
                    k.aw("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Uw());
                final ArrayList<KsRewardVideoAd> arrayList2 = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) listA.get(0);
                arrayList2.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, adVideoPreCacheConfigObtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                d.h(sceneImplCovert, listA.size());
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        try {
                            KsAdLoadManager.P().b(arrayList2);
                            cVar.c(adTemplate, arrayList2);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class) != null) {
                        com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.c.a.class);
                        listA.get(0);
                        com.kwad.sdk.core.response.b.e.eP((AdTemplate) listA.get(0));
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList3 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate);
                final boolean zYS = com.kwad.sdk.core.config.e.YS();
                boolean z2 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList2) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate2);
                    if (adTemplate2.isNativeRewardPreview || com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
                        list = listA;
                        arrayList = arrayList3;
                    } else if (com.kwad.sdk.core.response.b.a.bj(adInfoEP)) {
                        arrayList = arrayList3;
                        list = listA;
                    } else {
                        final ArrayList arrayList4 = arrayList3;
                        com.kwad.components.ad.d.b.a(adTemplate2, true, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void aj() {
                                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList4.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList4);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ak() {
                                if (!zYS || AnonymousClass1.this.YK) {
                                    return;
                                }
                                b.a(adTemplate, cVar, arrayList2);
                            }
                        });
                        listA = listA;
                        arrayList3 = arrayList3;
                    }
                    arrayList.add(ksRewardVideoAd);
                    b.a(adTemplate, cVar, arrayList);
                    arrayList3 = arrayList;
                    z2 = true;
                    listA = list;
                }
                ArrayList arrayList5 = arrayList3;
                List list2 = listA;
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!zYS && !z2 && arrayList5.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCz.errorCode, com.kwad.sdk.core.network.e.bCz.msg);
                    k.aw("rewardAd_", "onRewardVideoAdCacheFailed");
                } else {
                    com.kwad.components.ad.reward.monitor.c.c(true, (AdTemplate) list2.get(0), list2.size(), jElapsedRealtime);
                }
            }
        }).sK());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                k.aw("rewardAd_", "onRewardVideoAdCacheSuccess");
                cVar.d(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
                int iBk = com.kwad.sdk.core.response.b.a.bk(adInfoEP);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
                    arrayList.add(adTemplate);
                } else if (1 == iBk && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(adInfoEP))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bj(adInfoEP)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
