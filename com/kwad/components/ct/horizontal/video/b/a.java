package com.kwad.components.ct.horizontal.video.b;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.p;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.b.b<CtAdTemplate, CtAdResultData> {
    private boolean aOZ = true;
    private CtAdTemplate mEntryAdTemplate;
    private int mRequestCount;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aOZ = false;
        return false;
    }

    public a(CtAdTemplate ctAdTemplate) {
        this.mEntryAdTemplate = ctAdTemplate;
    }

    @Override // com.kwad.sdk.lib.b.b
    public final l<f, CtAdResultData> Bn() {
        final p.a aVar = new p.a();
        ImpInfo impInfo = new ImpInfo(this.mEntryAdTemplate.mAdScene);
        if (this.mEntryAdTemplate.mAdScene != null) {
            impInfo.pageScene = this.mEntryAdTemplate.mAdScene.getPageScene();
        }
        impInfo.subPageScene = 103L;
        aVar.Tk = impInfo;
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.aUY = this.aOZ ? 0 : getCount();
        aVar2.aUX = this.mRequestCount;
        aVar.aUG = aVar2;
        aVar.aUV = String.valueOf(com.kwad.components.ct.response.a.a.bg(this.mEntryAdTemplate));
        aVar.contentSourceType = com.kwad.components.ct.response.a.a.bh(this.mEntryAdTemplate);
        aVar.contentType = com.kwad.components.ct.response.a.a.ax(this.mEntryAdTemplate);
        return new l<f, CtAdResultData>() { // from class: com.kwad.components.ct.horizontal.video.b.a.1
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
                a.a(a.this, false);
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(a.this.mEntryAdTemplate.mAdScene);
                ctAdResultData.parseJson(jSONObject);
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

    public final void G(CtAdTemplate ctAdTemplate) {
        this.mRequestCount = 0;
        this.mEntryAdTemplate = ctAdTemplate;
        this.aOZ = true;
    }
}
