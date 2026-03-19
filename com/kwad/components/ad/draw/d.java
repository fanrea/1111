package com.kwad.components.ad.draw;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        if (sceneImplCovert.getAdNum() <= 0) {
            com.kwad.components.ad.draw.a.c.a(sceneImplCovert, "ad_num");
        }
        boolean zB = p.tH().b(sceneImplCovert, "loadDrawAd");
        sceneImplCovert.setAdStyle(6);
        com.kwad.components.ad.draw.a.c.b(sceneImplCovert);
        com.kwad.sdk.commercial.d.d.q(sceneImplCovert);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.draw.a.c.a(sceneImplCovert, i, str, SystemClock.elapsedRealtime() - jElapsedRealtime);
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        drawAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(AdResultData adResultData) {
                com.kwad.components.ad.draw.a.c.a(sceneImplCovert, adResultData.getAdTemplateList().size(), SystemClock.elapsedRealtime() - jElapsedRealtime);
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        AdInfo adInfoEP = e.eP(adTemplate);
                        if (adTemplate.adStyle != 6) {
                            com.kwad.components.ad.draw.a.c.i(adTemplate);
                        }
                        if (!com.kwad.sdk.core.response.b.a.df(adInfoEP) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(adInfoEP))) {
                            com.kwad.components.ad.draw.a.c.i(adTemplate);
                        } else {
                            arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg + "(无视频资源)" : adResultData.testErrorMsg);
                } else {
                    bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            KsAdLoadManager.P().b(arrayList);
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                }
                com.kwad.components.ad.draw.a.c.b(sceneImplCovert, arrayList.size(), SystemClock.elapsedRealtime() - jElapsedRealtime);
                com.kwad.sdk.commercial.d.d.h(sceneImplCovert, arrayList.size());
            }
        }).sK());
    }
}
