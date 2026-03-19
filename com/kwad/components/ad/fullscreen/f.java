package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
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
public final class f {
    public static void a(KsScene ksScene, final e eVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.q(sceneImplCovert);
        com.kwad.components.ad.reward.monitor.c.a(false, sceneImplCovert.getPosId());
        boolean zB = p.tH().b(sceneImplCovert, "loadFullScreenVideoAd");
        sceneImplCovert.setAdStyle(3);
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new j() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.j
            public final void al() {
                com.kwad.components.ad.reward.monitor.c.b(false, sceneImplCovert.posId);
            }
        }).a(new com.kwad.components.core.request.e() { // from class: com.kwad.components.ad.fullscreen.f.1
            static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.YK = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(false, i, str, sceneImplCovert.getPosId());
                if (i != com.kwad.sdk.core.network.e.bCy.errorCode && i != com.kwad.sdk.core.network.e.bCt.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i);
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        eVar.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                List list;
                String str;
                com.kwad.components.ad.reward.monitor.c.c(false, sceneImplCovert.posId);
                List<AdTemplate> listA = f.a(sceneImplCovert, adResultData.getAdTemplateList());
                String str2 = "onFullScreenVideoAdCacheFailed";
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : adResultData.testErrorMsg);
                    k.aw("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Uw());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : listA) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, adVideoPreCacheConfigObtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) listA.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, listA.size(), jElapsedRealtime);
                com.kwad.sdk.commercial.d.d.h(sceneImplCovert, listA.size());
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate2);
                final boolean zYS = com.kwad.sdk.core.config.e.YS();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate3);
                    if (com.kwad.sdk.core.response.b.a.bj(adInfoEP) || com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
                        list = listA;
                        str = str2;
                        arrayList2.add(ksFullScreenVideoAd);
                        this.YK = true;
                        f.a(adTemplate2, eVar, arrayList2);
                    } else {
                        list = listA;
                        str = str2;
                        com.kwad.components.ad.d.b.a(adTemplate3, false, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void aj() {
                                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ak() {
                                if (!zYS || AnonymousClass1.this.YK) {
                                    return;
                                }
                                f.a(adTemplate2, eVar, arrayList);
                            }
                        });
                    }
                    listA = list;
                    str2 = str;
                }
                List list2 = listA;
                String str3 = str2;
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!zYS && arrayList2.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCz.errorCode, com.kwad.sdk.core.network.e.bCz.msg);
                    k.aw("fullAd_", str3);
                } else {
                    com.kwad.components.ad.reward.monitor.c.c(false, (AdTemplate) list2.get(0), list2.size(), jElapsedRealtime);
                }
            }
        }).sK());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                k.aw("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.P().b(list);
                eVar.b(adTemplate, list);
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
                if (1 == com.kwad.sdk.core.response.b.a.bk(adInfoEP) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(adInfoEP))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bj(adInfoEP)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
