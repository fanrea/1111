package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int buM;
    public int bvH;
    public String bvI;
    public boolean bvR;
    public int bvS;
    public int bvT;
    public long bvU;
    public int retryCount;
    public int status;

    public static b Xq() {
        return new b();
    }

    public final b ex(int i) {
        this.status = i;
        return this;
    }

    public final b cv(boolean z) {
        this.bvR = z;
        return this;
    }

    public final b ey(int i) {
        this.buM = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b ez(int i) {
        this.retryCount = i;
        return this;
    }

    public final b eA(int i) {
        this.bvH = i;
        return this;
    }

    public final b eD(String str) {
        this.bvI = str;
        return this;
    }

    public final b eB(int i) {
        this.bvS = i;
        return this;
    }

    public final b eC(int i) {
        this.bvT = i;
        return this;
    }

    public final b aS(long j) {
        this.bvU = j;
        return this;
    }
}
