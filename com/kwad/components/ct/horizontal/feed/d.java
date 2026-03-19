package com.kwad.components.ct.horizontal.feed;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private int mRequestCount;
    private final SceneImpl mSceneImpl;

    public d(SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, CtAdResultData> Bn() {
        final k.a aVar = new k.a();
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        impInfo.subPageScene = 100L;
        aVar.anZ.add(impInfo);
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.feed.d.1
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
                CtAdResultData ctAdResultData = new CtAdResultData(d.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        };
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return i != e.bCI.errorCode;
    }

    @Override // com.kwad.sdk.lib.b.b, com.kwad.sdk.lib.b.c
    public final void refresh() {
        super.refresh();
        if (akP()) {
            com.kwad.components.ct.e.b.JK().k(this.mSceneImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    public List<CtAdTemplate> a(CtAdResultData ctAdResultData, boolean z) {
        if (ctAdResultData == null) {
            return new ArrayList();
        }
        List<CtAdTemplate> ctAdTemplateList = ctAdResultData.getCtAdTemplateList();
        if (!z) {
            this.mRequestCount++;
            for (CtAdTemplate ctAdTemplate : ctAdTemplateList) {
                ctAdTemplate.mRequestCount = this.mRequestCount;
                ctAdTemplate.mIsFromContent = true;
            }
        }
        return ctAdTemplateList;
    }
}
