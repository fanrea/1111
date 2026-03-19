package com.kwad.components.core.c;

import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a PH;

    protected boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    public j(com.kwad.components.core.request.model.a aVar) {
        this.PH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a aVarOh = a.oh();
        if (aVarOh == null || proceedTemplateList.size() <= 0) {
            return;
        }
        AdTemplate adTemplate = proceedTemplateList.get(0);
        e eVarX = e.x(adResultData.getPosId());
        aVarOh.oi();
        aVarOh.l(h.a(eVarX, adResultData));
        aVarOh.a(e.av(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.kwad.components.core.request.a aVar, final AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.ach().submit(new bh() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                j jVar = j.this;
                j.m(adResultData);
            }
        });
        if (a(this.PH, adResultData)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.PH, adResultData, false);
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(com.kwad.components.core.request.a aVar, int i, String str) {
        super.onError(aVar, i, str);
        com.kwad.components.core.request.model.a.a(this.PH, i, str, false);
    }
}
