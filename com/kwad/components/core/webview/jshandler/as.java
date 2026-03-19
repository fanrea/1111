package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public as(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplateA;
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.adlog.c.k(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            adTemplateA = this.mAdTemplate;
        } catch (Exception e) {
            e = e;
        }
        try {
            if (cVar2.adS > 0) {
                adTemplateA = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.p.a.e.a.a.aO(cVar2.adS), cVar2.PD);
            }
            if (adTemplateA == null) {
                com.kwad.sdk.core.adlog.c.k(this.mAdTemplate, 2);
                cVar.onError(-1, "adTemplate为空：" + cVar2.adS);
                return;
            }
            if (com.kwad.components.core.e.d.e.a(this.mContext, cVar2.aZ(com.kwad.sdk.core.response.b.a.dA(com.kwad.sdk.core.response.b.e.eP(adTemplateA))), JumpFrom.H5, adTemplateA) == 1) {
                cVar.a(null);
            } else {
                cVar.onError(-1, "跳转失败");
            }
        } catch (Exception e2) {
            e = e2;
            adTemplate = adTemplateA;
            com.kwad.sdk.core.adlog.c.k(adTemplate, 2);
            cVar.onError(-1, "解析失败");
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
