package com.kwad.components.core.p.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String UH;
    public long UI;
    public long UJ;
    public long UK;
    public String UL;

    public final b ay(String str) {
        this.UH = str;
        return this;
    }

    public final b F(long j) {
        this.UI = j;
        return this;
    }

    public final b G(long j) {
        this.UJ = j;
        return this;
    }

    public final b aR(int i) {
        this.UK = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: aS, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final b az(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b aA(String str) {
        this.UL = str;
        return this;
    }
}
