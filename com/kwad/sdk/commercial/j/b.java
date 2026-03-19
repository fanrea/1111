package com.kwad.sdk.commercial.j;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String buE;
    public String buF;
    public int buM;
    public int requestType;
    public int status;

    public static b WM() {
        return new b();
    }

    public final b es(int i) {
        this.status = i;
        return this;
    }

    public final b et(int i) {
        this.buM = i;
        return this;
    }

    public final b er(String str) {
        this.buE = str;
        return this;
    }

    public final b es(String str) {
        this.buF = str;
        return this;
    }

    public final b eu(int i) {
        this.requestType = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ev, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: et, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ce, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
