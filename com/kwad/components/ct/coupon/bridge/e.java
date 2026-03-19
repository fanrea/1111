package com.kwad.components.ct.coupon.bridge;

import android.app.Activity;
import com.kwad.components.ad.b.h;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeJ;
    private KsRewardVideoAd.RewardAdInteractionListener anj = new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.kwad.components.ct.coupon.bridge.e.1
        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onExtraRewardVerify(int i) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onAdClicked() {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onAdClicked");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onPageDismiss() {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onPageDismiss");
            e.this.aeJ.a(null);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayError(int i, int i2) {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onVideoPlayError");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayEnd() {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onVideoPlayEnd");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoSkipToEnd(long j) {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onVideoSkipToEnd");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayStart() {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onVideoPlayStart");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify() {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onRewardVerify");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(Map<String, Object> map) {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频onRewardVerify 含参extraMap");
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardStepVerify(int i, int i2) {
            com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "激励视频分阶段回调onRewardStepVerify");
        }
    };
    private final Activity mActivity;
    private final SceneImpl mAdScene;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showRewardVideoAd";
    }

    public e(Activity activity, SceneImpl sceneImpl) {
        this.mActivity = activity;
        this.mAdScene = sceneImpl;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                CtAdTemplate ctAdTemplate = new CtAdTemplate();
                ctAdTemplate.parseJson(jSONArray.getJSONObject(i));
                arrayList.add(ctAdTemplate);
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (arrayList.size() <= 0) {
            q(-1, "reward video ad data parse error.");
        } else {
            com.kwad.components.ct.request.e.a(this.mAdScene, arrayList, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.ct.coupon.bridge.e.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i2, String str2) {
                    com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "loadContentRewardAd code=" + i2 + " msg=" + str2);
                    e.this.q(i2, str2);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
                    com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "onRewardVideoResult adList=" + list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "onRewardVideoAdLoad: " + list);
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    boolean zCo = false;
                    KsRewardVideoAd ksRewardVideoAd = list.get(0);
                    h hVar = (h) com.kwad.sdk.components.d.g(h.class);
                    if (hVar != null) {
                        h.a aVarV = hVar.V();
                        if (aVarV.a(ksRewardVideoAd)) {
                            zCo = com.kwad.sdk.core.response.b.a.co(aVarV.b(ksRewardVideoAd));
                            aVarV.a(ksRewardVideoAd, 2);
                        }
                    }
                    com.kwad.sdk.core.d.c.d("WebCardShowRewardVideoAdHandler", "onRewardVideoAdLoad, videoVoiceOpen: " + zCo);
                    VideoPlayConfigImpl videoPlayConfigImpl = new VideoPlayConfigImpl();
                    videoPlayConfigImpl.setVideoSoundEnable(zCo);
                    e.this.a(ksRewardVideoAd, videoPlayConfigImpl);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsRewardVideoAd ksRewardVideoAd, KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable()) {
            ksRewardVideoAd.setRewardAdInteractionListener(this.anj);
            ksRewardVideoAd.showRewardVideoAd(this.mActivity, ksVideoPlayConfig);
        } else {
            q(-1, "reward video ad is not enable.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        com.kwad.sdk.core.webview.c.c cVar = this.aeJ;
        if (cVar != null) {
            cVar.onError(i, str);
        }
    }
}
