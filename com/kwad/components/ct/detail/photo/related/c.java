package com.kwad.components.ct.detail.photo.related;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.p;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private CtAdTemplate mEntryAdTemplate;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.b.b
    public final /* synthetic */ List<CtAdTemplate> a(BaseResultData baseResultData, boolean z) {
        return b((CtAdResultData) baseResultData);
    }

    public c(CtAdTemplate ctAdTemplate) {
        this.mEntryAdTemplate = ctAdTemplate;
        this.mSceneImpl = ctAdTemplate.mAdScene;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, CtAdResultData> Bn() {
        final p.a aVar = new p.a();
        ImpInfo impInfo = new ImpInfo(this.mSceneImpl);
        impInfo.pageScene = this.mSceneImpl.getPageScene();
        aVar.Tk = impInfo;
        aVar.aUG = new com.kwad.components.ct.request.a.a();
        aVar.aUV = String.valueOf(com.kwad.components.ct.response.a.c.j((PhotoInfo) this.mEntryAdTemplate.photoInfo));
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.detail.photo.related.c.1
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
                CtAdResultData ctAdResultData = new CtAdResultData(c.this.mSceneImpl);
                ctAdResultData.parseJson(jSONObject);
                return ctAdResultData;
            }
        };
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean bL(int i) {
        return i != e.bCI.errorCode;
    }

    private static List<CtAdTemplate> b(CtAdResultData ctAdResultData) {
        if (ctAdResultData == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (CtAdTemplate ctAdTemplate : ctAdResultData.getCtAdTemplateList()) {
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                arrayList.add(ctAdTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final boolean Bo() {
        List<CtAdTemplate> listBj = a.Bg().Bj();
        return (listBj == null || listBj.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.b.b
    /* renamed from: Bp, reason: merged with bridge method [inline-methods] */
    public CtAdResultData Bq() {
        List<CtAdTemplate> listBj = a.Bg().Bj();
        if (listBj == null || listBj.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listBj.size());
        for (CtAdTemplate ctAdTemplate : listBj) {
            ctAdTemplate.mAdScene = this.mSceneImpl;
            arrayList.add(ctAdTemplate);
        }
        a.Bg().Bk();
        CtAdResultData ctAdResultData = new CtAdResultData();
        ctAdResultData.setCtAdTemplateList(arrayList);
        return ctAdResultData;
    }
}
