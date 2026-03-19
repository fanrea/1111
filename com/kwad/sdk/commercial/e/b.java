package com.kwad.sdk.commercial.e;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String buw;
    public String bux;

    public static b WD() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cc, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b ed(String str) {
        this.buw = str;
        return this;
    }

    public final b ee(String str) {
        this.bux = str;
        return this;
    }
}
