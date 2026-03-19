package com.kwad.components.ct.horizontal.news;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.p;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private final CtAdTemplate mEntryAdTemplate;
    private int mRequestCount;
    private final SceneImpl mSceneImpl;

    public e(SceneImpl sceneImpl, CtAdTemplate ctAdTemplate) {
        this.mSceneImpl = sceneImpl;
        this.mEntryAdTemplate = ctAdTemplate;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<com.kwad.sdk.core.network.f, CtAdResultData> Bn() {
        final p.a aVar = new p.a();
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        impInfo.subPageScene = 103L;
        aVar.Tk = impInfo;
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUY = getCount();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        aVar.aUV = String.valueOf(com.kwad.components.ct.response.a.a.bg(this.mEntryAdTemplate));
        aVar.contentSourceType = com.kwad.components.ct.response.a.a.bh(this.mEntryAdTemplate);
        aVar.contentType = com.kwad.components.ct.response.a.a.ax(this.mEntryAdTemplate);
        return new l<com.kwad.sdk.core.network.f, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.news.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Br, reason: merged with bridge method [inline-methods] */
            public p createRequest() {
                return new p(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(e.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        };
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return i != com.kwad.sdk.core.network.e.bCI.errorCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    public List<CtAdTemplate> a(CtAdResultData ctAdResultData, boolean z) {
        List<CtAdTemplate> ctAdTemplateList = ctAdResultData.getCtAdTemplateList();
        if (!z) {
            this.mRequestCount++;
            Iterator<CtAdTemplate> it = ctAdTemplateList.iterator();
            while (it.hasNext()) {
                it.next().mRequestCount = this.mRequestCount;
            }
        }
        return ctAdTemplateList;
    }
}
