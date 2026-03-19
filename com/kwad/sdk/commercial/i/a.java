package com.kwad.sdk.commercial.i;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String buE;
    public String buF;
    public String buG;
    public String buw;

    public static a WJ() {
        return new a();
    }

    public final a ej(String str) {
        this.buG = str;
        return this;
    }

    public final a ek(String str) {
        this.buw = str;
        return this;
    }

    public final a el(String str) {
        this.buE = str;
        return this;
    }

    public final a em(String str) {
        this.buF = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cd, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
