package com.kwad.components.core.p.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String UH;
    public long UI;
    public long UJ;
    public String UL;
    public long UM;

    public final d aB(String str) {
        this.UH = str;
        return this;
    }

    public final d H(long j) {
        this.UI = j;
        return this;
    }

    public final d I(long j) {
        this.UJ = j;
        return this;
    }

    public final d J(long j) {
        this.UM = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: aT, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final d aC(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d aD(String str) {
        this.UL = str;
        return this;
    }
}
