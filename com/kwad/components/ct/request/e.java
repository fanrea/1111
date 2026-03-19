package com.kwad.components.ct.request;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static void a(CtAdTemplate ctAdTemplate, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImpl = ctAdTemplate.mAdScene;
        sceneImpl.setAdStyle(12);
        ImpInfo impInfo = new ImpInfo(sceneImpl);
        impInfo.pageScene = sceneImpl.getPageScene();
        impInfo.subPageScene = 105L;
        impInfo.sdkExtraData = com.kwad.components.ct.response.a.a.aZ(ctAdTemplate);
        a(impInfo, null, false, new f() { // from class: com.kwad.components.ct.request.e.1
            @Override // com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("ContentRewardLoadManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        rewardVideoAdListener.onError(i, str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.components.core.request.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(final CtAdResultData ctAdResultData) {
                boolean z;
                com.kwad.components.ad.b.h hVar = (com.kwad.components.ad.b.h) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.h.class);
                final ArrayList arrayList = new ArrayList(ctAdResultData.getCtAdTemplateList().size());
                if (hVar != null) {
                    arrayList.addAll(hVar.c(com.kwad.components.ct.response.a.a.O(ctAdResultData.getCtAdTemplateList())));
                }
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.1.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        try {
                            rewardVideoAdListener.onRewardVideoResult(arrayList);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                final ArrayList arrayList2 = new ArrayList();
                int iUw = com.kwad.sdk.core.config.e.Uw();
                boolean z2 = false;
                loop0: while (true) {
                    z = z2;
                    for (CtAdTemplate ctAdTemplate2 : ctAdResultData.getCtAdTemplateList()) {
                        if (ctAdTemplate2 != null) {
                            if (ctAdTemplate2.mAdScene == null) {
                                ctAdTemplate2.mAdScene = sceneImpl;
                            }
                            if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(com.kwad.components.ct.response.a.a.eP(ctAdTemplate2)))) {
                                continue;
                            } else if (com.kwad.components.core.video.m.g(ctAdTemplate2, iUw)) {
                                if (hVar != null) {
                                    arrayList2.add(hVar.V().a(ctAdTemplate2));
                                }
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                        }
                    }
                    break loop0;
                }
                if (!z2) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg + "(无视频资源)" : ctAdResultData.testErrorMsg);
                } else if (!z) {
                    onError(com.kwad.sdk.core.network.e.bCz.errorCode, com.kwad.sdk.core.network.e.bCz.msg);
                } else {
                    bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.1.3
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                            e.b(ctAdResultData.getCtAdTemplateList(), jElapsedRealtime);
                        }
                    });
                }
            }
        });
    }

    public static void a(SceneImpl sceneImpl, List<CtAdTemplate> list, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        boolean z;
        sceneImpl.setAdStyle(12);
        ImpInfo impInfo = new ImpInfo(sceneImpl);
        com.kwad.sdk.core.d.c.d("ContentRewardLoadManager", "loadContentRewardAd pageScene: " + sceneImpl.getPageScene());
        impInfo.pageScene = sceneImpl.getPageScene();
        impInfo.subPageScene = 105L;
        final ArrayList arrayList = new ArrayList();
        int iUw = com.kwad.sdk.core.config.e.Uw();
        boolean z2 = false;
        loop0: while (true) {
            z = z2;
            for (CtAdTemplate ctAdTemplate : list) {
                if (ctAdTemplate != null) {
                    if (ctAdTemplate.mAdScene == null) {
                        ctAdTemplate.mAdScene = sceneImpl;
                    }
                    if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(com.kwad.components.ct.response.a.a.eP(ctAdTemplate)))) {
                        continue;
                    } else if (com.kwad.components.core.video.m.g(ctAdTemplate, iUw)) {
                        com.kwad.components.ad.b.h hVar = (com.kwad.components.ad.b.h) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.h.class);
                        if (hVar != null) {
                            arrayList.add(hVar.V().a(ctAdTemplate));
                        }
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                }
            }
            break loop0;
        }
        if (!z2) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    rewardVideoAdListener.onError(com.kwad.sdk.core.network.e.bCy.errorCode, com.kwad.sdk.core.network.e.bCy.msg + "(无视频资源)");
                }
            });
        } else if (!z) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.3
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    rewardVideoAdListener.onError(com.kwad.sdk.core.network.e.bCz.errorCode, com.kwad.sdk.core.network.e.bCz.msg);
                }
            });
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.request.e.4
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    rewardVideoAdListener.onRewardVideoAdLoad(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<CtAdTemplate> list, long j) {
        CtAdTemplate ctAdTemplate;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null || list.size() <= 0 || (ctAdTemplate = list.get(0)) == null) {
            return;
        }
        com.kwad.components.ct.e.b.JK().h(ctAdTemplate, jElapsedRealtime - j);
    }

    private static void a(final ImpInfo impInfo, List<String> list, boolean z, final f fVar) {
        final List list2 = null;
        final boolean z2 = false;
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.e.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo, list2, z2, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(impInfo.adScene);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        }.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.e.6
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar2, int i, String str) {
                k(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar2, BaseResultData baseResultData) {
                h((CtAdResultData) baseResultData);
            }

            private void h(CtAdResultData ctAdResultData) {
                if (ctAdResultData.isAdResultDataEmpty()) {
                    fVar.onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : ctAdResultData.testErrorMsg);
                } else {
                    fVar.b(ctAdResultData);
                }
            }

            private void k(int i, String str) {
                fVar.onError(i, str);
            }
        });
    }
}
