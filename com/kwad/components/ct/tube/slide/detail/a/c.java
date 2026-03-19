package com.kwad.components.ct.tube.slide.detail.a;

import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.tube.slide.detail.reward.watch.TubeWatchResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private boolean aYE;
    private CtPhotoInfo asj;
    private KSTubeParamInner mKSTubeParam;
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.tube.slide.detail.a.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlaying();
            c.this.KT();
        }
    };

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aYE = false;
        this.mKSTubeParam = this.aop.aol.mKSTubeParam;
        this.asj = com.kwad.components.ct.response.a.a.ay(this.aop.mAdTemplate);
        this.aop.aoz.c(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoz.d(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KT() {
        KSTubeParamInner kSTubeParamInner;
        if (this.aYE || (kSTubeParamInner = this.mKSTubeParam) == null || kSTubeParamInner.pageMode == 2) {
            return;
        }
        final com.kwad.components.ct.tube.channel.home.request.c cVarCP = com.kwad.components.ct.tube.channel.home.request.c.Kr().am(com.kwad.components.ct.response.a.c.t(this.asj)).cN(this.mKSTubeParam.freeEpisodeCount).cO(this.mKSTubeParam.unlockEpisodeCount).cP(com.kwad.components.ct.response.a.c.z(this.asj));
        final g gVarFM = g.abH().fL(this.mKSTubeParam.userId).fM(this.mKSTubeParam.userName);
        new l<com.kwad.components.ct.tube.slide.detail.reward.watch.a, TubeWatchResultData>() { // from class: com.kwad.components.ct.tube.slide.detail.a.c.2
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ch(str);
            }

            private static TubeWatchResultData ch(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeWatchResultData tubeWatchResultData = new TubeWatchResultData();
                tubeWatchResultData.parseJson(jSONObject);
                return tubeWatchResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: KU, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.tube.slide.detail.reward.watch.a createRequest() {
                return new com.kwad.components.ct.tube.slide.detail.reward.watch.a(cVarCP, gVarFM);
            }
        }.request(new com.kwad.sdk.core.network.o<com.kwad.components.ct.tube.slide.detail.reward.watch.a, TubeWatchResultData>() { // from class: com.kwad.components.ct.tube.slide.detail.a.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.ct.tube.slide.detail.reward.watch.a aVar, TubeWatchResultData tubeWatchResultData) {
                super.onSuccess(aVar, tubeWatchResultData);
                com.kwad.sdk.core.d.c.d("PhotoWatchReportPresenter", "reportVideoPlay success");
            }
        });
    }
}
