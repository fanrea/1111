package com.kwad.components.ct.hotspot;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotListResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    public static void loadHotspotData(KsScene ksScene, final KsLoadManager.KsHotSpotDataListener ksHotSpotDataListener) {
        final ImpInfo impInfo = new ImpInfo(SceneImpl.covert(ksScene));
        impInfo.pageScene = 13L;
        new l<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.g.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bW(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: IH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.h createRequest() {
                return new com.kwad.components.ct.request.h(impInfo);
            }

            private static HotspotListResultData bW(String str) {
                JSONObject jSONObject = new JSONObject(str);
                HotspotListResultData hotspotListResultData = new HotspotListResultData();
                hotspotListResultData.parseJson(jSONObject);
                return hotspotListResultData;
            }
        }.request(new o<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.g.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                x(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((HotspotListResultData) baseResultData);
            }

            private void a(HotspotListResultData hotspotListResultData) {
                final ArrayList arrayList = new ArrayList();
                for (HotspotInfo hotspotInfo : hotspotListResultData.hotspotListData.trends) {
                    if (hotspotInfo != null) {
                        arrayList.add(new h(hotspotInfo));
                    }
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.hotspot.g.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        ksHotSpotDataListener.onKsHotspotDataLoad(arrayList);
                    }
                });
            }

            private void x(final int i, final String str) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.hotspot.g.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsCtHotspotLoadManager", "loadHotspotPage onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        ksHotSpotDataListener.onError(i, str);
                    }
                });
            }
        });
    }

    public static void loadHotspotPage(KsScene ksScene, final KsLoadManager.KsHotSpotPageListener ksHotSpotPageListener) {
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        final ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        impInfo.pageScene = 13L;
        new l<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.g.3
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bW(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: IH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.h createRequest() {
                return new com.kwad.components.ct.request.h(impInfo);
            }

            private static HotspotListResultData bW(String str) {
                JSONObject jSONObject = new JSONObject(str);
                HotspotListResultData hotspotListResultData = new HotspotListResultData();
                hotspotListResultData.parseJson(jSONObject);
                return hotspotListResultData;
            }
        }.request(new o<com.kwad.components.ct.request.h, HotspotListResultData>() { // from class: com.kwad.components.ct.hotspot.g.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                x(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((HotspotListResultData) baseResultData);
            }

            private void a(HotspotListResultData hotspotListResultData) {
                final i iVar = new i(sceneImplCovert, hotspotListResultData.hotspotListData);
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.hotspot.g.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        ksHotSpotPageListener.onKsHotspotPageLoad(iVar);
                    }
                });
            }

            private void x(final int i, final String str) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.hotspot.g.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsCtHotspotLoadManager", "loadHotspotPage onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        ksHotSpotPageListener.onError(i, str);
                    }
                });
            }
        });
    }
}
