package com.kwad.sdk.core.adlog.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    public JSONObject bvE;
    public com.kwad.sdk.core.adlog.c.a bvF;
    public long bvG;
    public int bvH;
    public String bvI;
    public int retryCount;
    public String url;

    public static a Xh() {
        return new a();
    }

    public final a eB(String str) {
        this.url = str;
        return this;
    }

    public final a m(JSONObject jSONObject) {
        this.bvE = jSONObject;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.bvF = aVar;
        return this;
    }

    public final a aR(long j) {
        this.bvG = j;
        return this;
    }

    public final a ew(int i) {
        this.bvH = i;
        return this;
    }

    public final a eC(String str) {
        this.bvI = str;
        return this;
    }

    public final String toString() {
        return "AdLogCache {actionType=" + this.bvF.buM + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.bvH + ", retryErrorMsg=" + this.bvI + '}';
    }
}
