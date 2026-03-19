package com.kwad.components.ct.tube.history.d;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.request.ChannelDetailResultData;
import com.kwad.components.ct.tube.channel.home.request.c;
import com.kwad.components.ct.tube.history.TubeHistoryDetailParam;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.b.b<TubeInfo, ChannelDetailResultData> {
    private int aWJ = 1;
    private final TubeHistoryDetailParam aXd;
    private final SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return false;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ List<TubeInfo> a(BaseResultData baseResultData, boolean z) {
        return b((ChannelDetailResultData) baseResultData);
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ boolean a(BaseResultData baseResultData) {
        return c((ChannelDetailResultData) baseResultData);
    }

    public a(SceneImpl sceneImpl, TubeHistoryDetailParam tubeHistoryDetailParam) {
        this.mSceneImpl = sceneImpl;
        this.aXd = tubeHistoryDetailParam;
    }

    @Override // com.kwad.sdk.lib.b.b, com.kwad.sdk.lib.b.c
    public final void refresh() {
        super.refresh();
        this.aWJ = 1;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, ChannelDetailResultData> Bn() {
        return new l<f, ChannelDetailResultData>() { // from class: com.kwad.components.ct.tube.history.d.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: ce, reason: merged with bridge method [inline-methods] */
            public ChannelDetailResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ChannelDetailResultData channelDetailResultData = new ChannelDetailResultData(a.this.mSceneImpl);
                channelDetailResultData.parseJson(jSONObject);
                return channelDetailResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                ImpInfo impInfo = new ImpInfo(a.this.mSceneImpl);
                impInfo.pageScene = a.this.mSceneImpl.getPageScene();
                return new b(impInfo, c.Kr().cN(a.this.aXd.mKSTubeParam.freeEpisodeCount).cO(a.this.aXd.mKSTubeParam.unlockEpisodeCount).cL(30).cM(a.this.aWJ), g.abH().fL(a.this.aXd.mKSTubeParam.userId).fM(a.this.aXd.mKSTubeParam.userName));
            }
        };
    }

    private List<TubeInfo> b(ChannelDetailResultData channelDetailResultData) {
        List<TubeInfo> list = channelDetailResultData.tubes;
        S(list);
        return list;
    }

    private static boolean c(ChannelDetailResultData channelDetailResultData) {
        return channelDetailResultData.hasMore;
    }

    private void S(List<TubeInfo> list) {
        if (ap.aF(list)) {
            return;
        }
        this.aWJ = list.get(0).pcursor + 1;
    }
}
