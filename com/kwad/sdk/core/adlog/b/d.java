package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String buF;
    public int buM;
    public int bvV;
    public int retryCount;
    public int status;

    public static d Xr() {
        return new d();
    }

    public final d eD(int i) {
        this.status = i;
        return this;
    }

    public final d eE(String str) {
        this.buF = str;
        return this;
    }

    public final d eE(int i) {
        this.buM = i;
        return this;
    }

    public final d eF(int i) {
        this.bvV = 1;
        return this;
    }

    public final d eG(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: eF, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: eH, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cx, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
