package com.kwad.components.ct.horizontal;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.horizontal.detail.c;
import com.kwad.components.ct.horizontal.feed.KsHorizontalFeedPageImpl;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new KsHorizontalFeedPageImpl(SceneImpl.covert(ksScene), false, false);
    }

    public static KsHorizontalFeedPage loadHorizontalNewsFeedPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new KsHorizontalFeedPageImpl(SceneImpl.covert(ksScene), true, false);
    }

    public static KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new KsHorizontalFeedPageImpl(SceneImpl.covert(ksScene), false, true);
    }

    public static void loadHorizontalVideoData(KsScene ksScene, final KsLoadManager.KsHorizontalVideoDataListener ksHorizontalVideoDataListener) {
        final k.a aVar = new k.a();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        sceneImplCovert.setUrlPackage(new URLPackage(UUID.randomUUID().toString(), 21));
        ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        impInfo.pageScene = sceneImplCovert.getPageScene();
        impInfo.subPageScene = 100L;
        aVar.anZ.add(impInfo);
        aVar.aUG = new com.kwad.components.ct.request.a.a();
        new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: EY, reason: merged with bridge method [inline-methods] */
            public k createRequest() {
                return new k(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(sceneImplCovert);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        }.request(new o<f, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(f fVar, CtAdResultData ctAdResultData) {
                super.onSuccess(fVar, ctAdResultData);
                List<CtAdTemplate> ctAdTemplateList = ctAdResultData.getCtAdTemplateList();
                final ArrayList arrayList = new ArrayList();
                for (CtAdTemplate ctAdTemplate : ctAdTemplateList) {
                    if (!com.kwad.components.ct.response.a.a.eH(ctAdTemplate) && !com.kwad.components.ct.response.a.a.at(ctAdTemplate)) {
                        arrayList.add(new c(ctAdTemplate, sceneImplCovert));
                    }
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.horizontal.b.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        ksHorizontalVideoDataListener.onKsHorizontalVideoDataLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(f fVar, final int i, final String str) {
                super.onError(fVar, i, str);
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.horizontal.b.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsCtHorizontalLoadManager", "loadHotspotPage onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        ksHorizontalVideoDataListener.onError(i, str);
                    }
                });
            }
        });
    }
}
