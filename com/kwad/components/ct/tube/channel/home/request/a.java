package com.kwad.components.ct.tube.channel.home.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.b.b<TubeInfo, TubeChannelResultData> {
    private int aWJ = 1;
    private final KSTubeParamInner mKSTubeParam;
    private final SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return false;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ List<TubeInfo> a(BaseResultData baseResultData, boolean z) {
        return c((TubeChannelResultData) baseResultData);
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ boolean a(BaseResultData baseResultData) {
        return b((TubeChannelResultData) baseResultData);
    }

    public a(SceneImpl sceneImpl, KSTubeParamInner kSTubeParamInner) {
        this.mSceneImpl = sceneImpl;
        this.mKSTubeParam = kSTubeParamInner;
    }

    @Override // com.kwad.sdk.lib.b.b, com.kwad.sdk.lib.b.c
    public final void refresh() {
        super.refresh();
        this.aWJ = 1;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, TubeChannelResultData> Bn() {
        return new l<f, TubeChannelResultData>() { // from class: com.kwad.components.ct.tube.channel.home.request.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: cf, reason: merged with bridge method [inline-methods] */
            public TubeChannelResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeChannelResultData tubeChannelResultData = new TubeChannelResultData(a.this.mSceneImpl);
                tubeChannelResultData.parseJson(jSONObject);
                return tubeChannelResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                ImpInfo impInfo = new ImpInfo(a.this.mSceneImpl);
                impInfo.pageScene = a.this.mSceneImpl.getPageScene();
                return new b(impInfo, c.Kr().cN(a.this.mKSTubeParam.freeEpisodeCount).cO(a.this.mKSTubeParam.unlockEpisodeCount).cL(30).cM(a.this.aWJ), g.abH().fL(a.this.mKSTubeParam.userId).fM(a.this.mKSTubeParam.userName));
            }
        };
    }

    private static boolean b(TubeChannelResultData tubeChannelResultData) {
        return tubeChannelResultData.hasMore;
    }

    private List<TubeInfo> c(TubeChannelResultData tubeChannelResultData) {
        List<TubeInfo> list = tubeChannelResultData.recommendTubeChannel.tubes;
        S(list);
        return list;
    }

    private void S(List<TubeInfo> list) {
        if (ap.aF(list)) {
            return;
        }
        this.aWJ = list.get(0).pcursor + 1;
    }
}
