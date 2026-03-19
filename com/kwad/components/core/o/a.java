package com.kwad.components.core.o;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo Tk;

    public a(ImpInfo impInfo) {
        this.Tk = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    /* renamed from: oC */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Tk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: ak */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Tk.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        p(adResultData);
    }

    private static void p(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo adInfoEP = e.eP(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bj(adInfoEP)) {
                if (com.kwad.sdk.core.response.b.a.bg(adInfoEP).size() == 0) {
                    com.kwad.components.core.q.a.ss().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bo(adInfoEP) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(adInfoEP))) {
                com.kwad.components.core.q.a.ss().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public ExecutorService getExecutor() {
        return GlobalThreadPools.aci();
    }
}
