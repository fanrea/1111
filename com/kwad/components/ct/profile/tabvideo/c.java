package com.kwad.components.ct.profile.tabvideo;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.q;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private ProfileTabVideoParam aRP;
    private String mPcursor;
    private int mRequestCount;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ List<CtAdTemplate> a(BaseResultData baseResultData, boolean z) {
        return b((CtAdResultData) baseResultData);
    }

    public c(SceneImpl sceneImpl, ProfileTabVideoParam profileTabVideoParam) {
        this.mSceneImpl = sceneImpl;
        this.aRP = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, CtAdResultData> Bn() {
        final q.a aVar = new q.a();
        aVar.pcursor = this.mPcursor;
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        aVar.Tk = impInfo;
        aVar.authorId = this.aRP.mAuthorId;
        aVar.tabId = this.aRP.mTabId;
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.profile.tabvideo.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Gy, reason: merged with bridge method [inline-methods] */
            public q createRequest() {
                return new q(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(aVar.Tk.adScene);
                ctAdResultData.parseJson(jSONObject);
                if (!ctAdResultData.getCtAdTemplateList().isEmpty()) {
                    Iterator<CtAdTemplate> it = ctAdResultData.getCtAdTemplateList().iterator();
                    while (it.hasNext()) {
                        it.next().mPcursor = ctAdResultData.pcursor;
                    }
                }
                return ctAdResultData;
            }
        };
    }

    private List<CtAdTemplate> b(CtAdResultData ctAdResultData) {
        this.mRequestCount++;
        return ctAdResultData.getCtAdTemplateList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean a(CtAdResultData ctAdResultData) {
        String str = ctAdResultData.pcursor;
        this.mPcursor = str;
        return !"0".equals(str);
    }
}
