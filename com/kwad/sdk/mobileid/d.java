package com.kwad.sdk.mobileid;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private String cga;
    private String errorReason;
    private boolean success;

    public d(boolean z, String str) {
        this.success = z;
        this.errorReason = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String alR() {
        return this.errorReason;
    }

    public final String alS() {
        return this.cga;
    }

    public final void hK(String str) {
        this.cga = str;
    }

    public final String toString() {
        return "UaidErrorReason{success=" + this.success + ", errorReason='" + this.errorReason + "', extraErrorMsg='" + this.cga + "'}";
    }
}
