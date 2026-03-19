package com.kwad.components.ct.feed.home;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private int mRequestCount;
    private SceneImpl mSceneImpl;

    public c(SceneImpl sceneImpl) {
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
        aVar2.aUY = getCount();
        aVar.aUG = aVar2;
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.feed.home.c.1
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
                CtAdResultData ctAdResultData = new CtAdResultData(c.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                if (ctAdResultData.getCtAdTemplateList().size() > 0) {
                    Iterator<CtAdTemplate> it = ctAdResultData.getCtAdTemplateList().iterator();
                    while (it.hasNext()) {
                        it.next().mIsFromContent = true;
                    }
                }
                return ctAdResultData;
            }
        };
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return i != e.bCI.errorCode;
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

    @Override // com.kwad.sdk.lib.b.b
    public final boolean Bo() {
        List<CtAdTemplate> listEM = com.kwad.components.ct.feed.b.EL().EM();
        return (listEM == null || listEM.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: Bp, reason: merged with bridge method [inline-methods] */
    public CtAdResultData Bq() {
        List<CtAdTemplate> listEM = com.kwad.components.ct.feed.b.EL().EM();
        if (listEM == null || listEM.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listEM.size());
        for (CtAdTemplate ctAdTemplate : listEM) {
            ctAdTemplate.mAdScene = this.mSceneImpl;
            arrayList.add(ctAdTemplate);
        }
        this.mRequestCount = ((CtAdTemplate) arrayList.get(arrayList.size() - 1)).mRequestCount;
        com.kwad.components.ct.feed.b.EL().EN();
        CtAdResultData ctAdResultData = new CtAdResultData();
        ctAdResultData.setCtAdTemplateList(arrayList);
        return ctAdResultData;
    }
}
