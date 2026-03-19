package com.kwad.sdk.core.network;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public int bCq = -1;
    public Exception bCr;
    public String bCs;
    public int code;

    public final boolean aao() {
        return this.code == 200;
    }

    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.bCq + ", rawException=" + this.bCr + ", body='" + this.bCs + "'}";
    }
}
