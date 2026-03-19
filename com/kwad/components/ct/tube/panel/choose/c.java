package com.kwad.components.ct.tube.panel.choose;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private final TubeEpisodeChooseParam aXo;
    private final g aXp;
    private final ImpInfo amX;
    private final int mPcursor;
    private final SceneImpl mScene;
    private final long mTubeId;

    @Override // com.kwad.sdk.lib.b.b
    public final boolean Bo() {
        return true;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* bridge */ /* synthetic */ boolean a(BaseResultData baseResultData) {
        return false;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return false;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ List<CtAdTemplate> a(BaseResultData baseResultData, boolean z) {
        return b((CtAdResultData) baseResultData);
    }

    public c(SceneImpl sceneImpl, TubeEpisodeChooseParam tubeEpisodeChooseParam) {
        this.mScene = sceneImpl;
        this.aXo = tubeEpisodeChooseParam;
        ImpInfo impInfo = new ImpInfo(sceneImpl);
        this.amX = impInfo;
        impInfo.pageScene = sceneImpl.getPageScene();
        impInfo.subPageScene = 100L;
        this.aXp = g.abH().fL(tubeEpisodeChooseParam.mKSTubeParam.userId).fM(tubeEpisodeChooseParam.mKSTubeParam.userName);
        this.mPcursor = tubeEpisodeChooseParam.mPcursor;
        this.mTubeId = com.kwad.components.ct.tube.d.b.d(tubeEpisodeChooseParam.mPlayingTubeEpisode);
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, CtAdResultData> Bn() {
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.tube.panel.choose.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(c.this.mScene);
                ctAdResultData.parseJson(jSONObject);
                com.kwad.components.ct.tube.slide.b.b.KX().a(c.this.mTubeId, c.this.mPcursor, ctAdResultData);
                return ctAdResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            public final f createRequest() {
                return new com.kwad.components.ct.tube.slide.b.c(c.this.amX, com.kwad.components.ct.tube.channel.home.request.c.Kr().am(c.this.mTubeId).cN(c.this.aXo.mKSTubeParam.freeEpisodeCount).cO(c.this.aXo.mKSTubeParam.unlockEpisodeCount).cL(30).cM(c.this.mPcursor), c.this.aXp);
            }
        };
    }

    @Override // com.kwad.sdk.lib.b.a, com.kwad.sdk.lib.b.c
    public final List<CtAdTemplate> KE() {
        ArrayList arrayList = new ArrayList(super.KE());
        for (int size = arrayList.size() - 1; size > 0; size--) {
            if (((CtAdTemplate) arrayList.get(size)).contentType == 2) {
                arrayList.remove(arrayList.get(size));
            }
        }
        return arrayList;
    }

    public final List<CtAdTemplate> KF() {
        return super.getItems();
    }

    @Override // com.kwad.sdk.lib.b.a
    public final int getCount() {
        return getItems().size();
    }

    @Override // com.kwad.sdk.lib.b.a, com.kwad.sdk.lib.b.c
    public final List<CtAdTemplate> getItems() {
        ArrayList arrayList = new ArrayList(super.getItems());
        for (int size = arrayList.size() - 1; size > 0; size--) {
            if (((CtAdTemplate) arrayList.get(size)).contentType == 2) {
                arrayList.remove(arrayList.get(size));
            }
        }
        return arrayList;
    }

    private static List<CtAdTemplate> b(CtAdResultData ctAdResultData) {
        return ctAdResultData.getCtAdTemplateList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: Bp, reason: merged with bridge method [inline-methods] */
    public CtAdResultData Bq() {
        return com.kwad.components.ct.tube.slide.b.b.KX().e(this.mTubeId, this.mPcursor);
    }
}
