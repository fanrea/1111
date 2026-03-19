package com.kwad.components.ct.tube.channel.detail.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.b.b<TubeInfo, ChannelDetailResultData> {
    private final int aWl;
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

    public a(SceneImpl sceneImpl, int i) {
        this.mSceneImpl = sceneImpl;
        this.aWl = i;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, ChannelDetailResultData> Bn() {
        return new l<f, ChannelDetailResultData>() { // from class: com.kwad.components.ct.tube.channel.detail.request.a.1
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
                impInfo.subPageScene = 100L;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < a.this.ccz.size(); i++) {
                    arrayList.add(Long.valueOf(((TubeInfo) a.this.ccz.get(i)).tubeId));
                }
                return new b(new b.a(impInfo, a.this.aWl, arrayList));
            }
        };
    }

    private static List<TubeInfo> b(ChannelDetailResultData channelDetailResultData) {
        return channelDetailResultData.tubes;
    }

    private static boolean c(ChannelDetailResultData channelDetailResultData) {
        return channelDetailResultData.hasMore;
    }
}
